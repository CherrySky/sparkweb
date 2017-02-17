package sdomain;

import sdomain.controller.ReceiptController;
import sdomain.controller.WolfController;
import sdomain.dao.DatabaseConfig;

import javax.sql.DataSource;

import static spark.Spark.*;

public class Server {

    public static void main(String[] args) {

        staticFileLocation("/public");

        //DataSource dataSource = DatabaseConfig.init("sql/create-data.sql");

        //Spark.externalStaticFileLocation("/sdomain/src/main/resources/public");

        //new ReceiptController(dataSource);

        new WolfController();

        System.out.println("server started...");

    }

}
