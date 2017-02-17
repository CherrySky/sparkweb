package sdomain.controller;

import sdomain.dao.ReceiptDao;
import sdomain.domain.Receipt;
import spark.ModelAndView;
import spark.TemplateViewRoute;
import spark.template.freemarker.FreeMarkerEngine;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ReceiptController {
    final ReceiptDao dao;

    public ReceiptController(DataSource dataSource) {
        dao = new ReceiptDao(dataSource);
        init();
    }

    private void init() {
        TemplateViewRoute mainRoute = (req, res) -> {
            List<Receipt> receipts = dao.getAll();
            Map<String, Object> model = new HashMap<>();
            model.put("data", receipts);

            return new ModelAndView(model, "receipt/index.ftl");
        };

        get("/", mainRoute, new FreeMarkerEngine());
        get("/receipt", mainRoute, new FreeMarkerEngine());

        post("/searchReceipt", (req, res) -> {
            String searchText = req.body().split("=")[1];
            System.out.println("search: " + searchText);

            List<Receipt> receipts = dao.search(searchText);
            Map<String, Object> model = new HashMap<>();
            model.put("data", receipts);

            return new ModelAndView(model, "receipt/index.ftl");
        }, new FreeMarkerEngine());

        get("/receipt/:id", (req, res) -> {
            String id = req.params(":id");
            System.out.println("ID: " + id);
            Receipt receipt = dao.getByID(id);
            Map<String, Object> model = new HashMap<>();
            model.put("data", receipt);

            System.out.println();

            return new ModelAndView(model, "receipt/edit.ftl");
        }, new FreeMarkerEngine());

        get("/createReceipt", (req, res) -> {
            System.out.println("in create");
            Map<String, Object> model = new HashMap<>();
            Receipt receipt = new Receipt();
            //receipt.setProductName("iphone7");
            receipt.setPurchaseDate(new Date(2016,10,12));
            model.put("data", receipt);
            return new ModelAndView(model, "receipt/create.ftl");
        }, new FreeMarkerEngine());

        post("updateReceipt", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "receipt/create.ftl");
        }, new FreeMarkerEngine());


    }

}
