package sdomain.controller;

import sdomain.dao.ReceiptDao;
import sdomain.domain.Receipt;
import sdomain.domain.WolfUser;
import sdomain.domain.Wolfs;
import sdomain.services.WolfStatWebService;
import spark.ModelAndView;
import spark.TemplateViewRoute;
import spark.template.freemarker.FreeMarkerEngine;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.sql.Date;
import java.util.*;
import java.util.concurrent.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class WolfController {

    private ExecutorService executorService = Executors.newFixedThreadPool(5);
    private WolfStatWebService wolfStatWebService = new WolfStatWebService();


    public WolfController() {
        init();
    }

    private void init() {
        TemplateViewRoute mainRoute = (req, res) -> {
            List<WolfUser> wolfUsers = new CopyOnWriteArrayList<>();
            CountDownLatch latch = new CountDownLatch(Wolfs.values().length);

            for (Wolfs wolfs : Wolfs.values()) {
                executorService.execute(() -> {
                    try {
                        WolfUser wolfUser = wolfStatWebService.getWolfUserStatus(wolfs);
                        wolfUsers.add(wolfUser);
                        latch.countDown();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }

            try {
                latch.await();
            } catch (InterruptedException e) {

            }

            Map<String, Object> model = new HashMap<>();
            Collections.sort(wolfUsers);
            model.put("data", wolfUsers);

            return new ModelAndView(model, "wolf/index.ftl");
        };

        get("/", mainRoute, new FreeMarkerEngine());
        get("/wolf", mainRoute, new FreeMarkerEngine());


    }

}
