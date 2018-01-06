package sdomain.controller;

import sdomain.domain.WolfUser;
import sdomain.domain.Wolfs;
import sdomain.services.WolfStatWebService;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static spark.Spark.get;

public class WolfController extends SparkController {

    private ExecutorService executorService = Executors.newFixedThreadPool(8);
    private WolfStatWebService wolfStatWebService = new WolfStatWebService();

    public WolfController(boolean isDefault) {
        super(isDefault);
    }

    @Override
    public void createControllerRoute() {
        mainRoute = (req, res) -> {
            List<WolfUser> wolfUsers = new CopyOnWriteArrayList<>();
            CountDownLatch latch = new CountDownLatch(Wolfs.values().length);

            for (Wolfs wolfs : Wolfs.values()) {
                if (wolfs.isEnable()) {
                    executorService.execute(() -> {
                        try {
                            WolfUser wolfUser = wolfStatWebService.getWolfUserStatus(wolfs);
                            if (wolfUser.getGamesPlayedTotal() != null) {
                                wolfUsers.add(wolfUser);
                            }
                            latch.countDown();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }

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
    }

    public void start() {
        get("/wolf", mainRoute, new FreeMarkerEngine());
    }

}
