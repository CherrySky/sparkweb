package sdomain;

import sdomain.controller.TelegramBotController;
import sdomain.controller.WolfController;

import static spark.Spark.*;

public class Server {

    public static void main(String[] args) {

        staticFileLocation("/public");

        //DataSource dataSource = DatabaseConfig.init("sql/create-data.sql");

        //Spark.externalStaticFileLocation("/sdomain/src/main/resources/public");

        //new ReceiptController(dataSource);

        new WolfController();
        //new TelegramBotController();

        System.out.println("server started...");

    }

}
