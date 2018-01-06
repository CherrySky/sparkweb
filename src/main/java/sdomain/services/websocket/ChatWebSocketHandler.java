package sdomain.services.websocket;

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import sdomain.controller.WebSocketController;

@WebSocket(maxIdleTime = 60000)
public class ChatWebSocketHandler {

    private String sender, msg;

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception {
        String username = "User" + WebSocketController.nextUserNumber++;
        WebSocketController.userUsernameMap.put(user, username);
        WebSocketController.broadcastMessage(sender = "Server", msg = (username + " joined the chat"));
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
        String username = WebSocketController.userUsernameMap.get(user);
        WebSocketController.userUsernameMap.remove(user);
        WebSocketController.broadcastMessage(sender = "Server", msg = (username + " left the chat"));
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        WebSocketController.broadcastMessage(sender = WebSocketController.userUsernameMap.get(user), msg = message);
    }

}