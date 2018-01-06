package sdomain;

import sdomain.controller.TelegramBotController;
import sdomain.controller.WebSocketController;
import sdomain.controller.WolfController;

import static spark.Spark.*;

public class Server {

    public static void main(String[] args) {
        new Server().start();
    }

    private void start() {

        staticFiles.location("/public");
        staticFiles.expireTime(60000);

        //DataSource dataSource = DatabaseConfig.init("sql/create-data.sql");

        //Spark.externalStaticFileLocation("/sdomain/src/main/resources/public");

        //new ReceiptController(dataSource);
        new TelegramBotController();

        createSparkControllers();

        init();
        System.out.println("server started...");
    }

    private void createSparkControllers() {
        new WebSocketController(true);
        new WolfController(false);
    }

}
