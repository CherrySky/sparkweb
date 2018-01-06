package sdomain.controller;

import spark.TemplateViewRoute;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.get;

public abstract class SparkController {

    TemplateViewRoute mainRoute;

    SparkController(boolean isDefault) {
        createControllerRoute();
        start();

        if (isDefault) {
            get("/", mainRoute, new FreeMarkerEngine());
        }
    }

    public abstract void createControllerRoute();

    public abstract void start();


}
