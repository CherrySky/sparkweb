package sdomain.controller;

import sdomain.domain.WolfUser;
import sdomain.domain.Wolfs;
import sdomain.services.WolfStatWebService;
import spark.ModelAndView;
import spark.TemplateViewRoute;
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

public class NihongoController {


    public NihongoController() {
        init();
    }

    private void init() {
        TemplateViewRoute mainRoute = (req, res) -> {


//            Map<String, Object> model = new HashMap<>();
//            model.put("data", wolfUsers);

            //return new ModelAndView(model, "wolf/index.ftl");

            return null;
        };

        get("/nihongo", (req, res) -> new ModelAndView(null, "nihongo/index.ftl"), new FreeMarkerEngine());


    }

}
