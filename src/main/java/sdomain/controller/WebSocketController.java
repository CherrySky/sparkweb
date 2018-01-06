package sdomain.controller;

import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;
import sdomain.services.websocket.ChatWebSocketHandler;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static j2html.TagCreator.*;
import static spark.Spark.get;
import static spark.Spark.webSocket;

public class WebSocketController extends SparkController {
    // this map is shared between sessions and threads, so it needs to be thread-safe (http://stackoverflow.com/a/2688817)
    public static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
    public static int nextUserNumber = 1; //Assign to username for next connecting user

    public WebSocketController(boolean isDefault) {
        super(isDefault);
    }

    @Override
    public void createControllerRoute() {
        System.out.println("create controller web socket");
        mainRoute = (req, res) -> new ModelAndView(null, "chat/index.ftl");
    }

    @Override
    public void start() {
        webSocket("/chats", ChatWebSocketHandler.class);
        get("/chat", mainRoute, new FreeMarkerEngine());
    }

    public static void broadcastMessage(String sender, String message) {
        userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                session.getRemote().sendString(String.valueOf(new JSONObject()
                        .put("userMessage", createHtmlMessageFromSender(sender, message))
                        .put("userlist", userUsernameMap.values())
                ));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    //Builds a HTML element with a sender-name, a message, and a timestamp,
    private static String createHtmlMessageFromSender(String sender, String message) {
        return article(
                b(sender + " says:"),
                span(attrs(".timestamp"), new SimpleDateFormat("HH:mm:ss").format(new Date())),
                p(message)
        ).render();
    }


}
