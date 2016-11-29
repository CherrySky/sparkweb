package server;

import controller.ReceiptController;
import model.Receipt;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Server {
    public static void main(String[] args) {

        staticFiles.location("/public");


        new ReceiptController();

        get("/hello", (request, response) -> {
            System.out.println("get hello");
            Map<String, Object> model = new HashMap<>();
            model.put("message", "Hello Freemarker!");
            return new ModelAndView(model, "index.ftl"); // located in src/test/resources/spark/template/freemarker
        }, new FreeMarkerEngine());
    }
}
