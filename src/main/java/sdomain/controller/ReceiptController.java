package sdomain.controller;

import sdomain.dao.ReceiptDao;
import sdomain.domain.Receipt;
import spark.ModelAndView;
import spark.TemplateViewRoute;
import spark.template.freemarker.FreeMarkerEngine;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ReceiptController {
    final ReceiptDao dao;

    public ReceiptController(DataSource dataSource) {
        dao = new ReceiptDao(dataSource);
        mainPage();
        search();

    }

    private void search() {
        TemplateViewRoute route = (req, res) -> {
            String searchText = req.body().split("=")[1];
            System.out.println("search: " + searchText);

            List<Receipt> receipts = dao.search(searchText);
            Map<String, Object> model = new HashMap<>();
            model.put("data", receipts);

            return new ModelAndView(model, "receipt.ftl");
        };

        post("/searchReceipt", route, new FreeMarkerEngine());
    }

    private void mainPage() {
        TemplateViewRoute route = (req, res) -> {
            List<Receipt> receipts = dao.getAll();
            Map<String, Object> model = new HashMap<>();
            model.put("data", receipts);

            return new ModelAndView(model, "receipt.ftl");
        };

        get("/", route, new FreeMarkerEngine());
        get("/receipt", route, new FreeMarkerEngine());
    }

}
