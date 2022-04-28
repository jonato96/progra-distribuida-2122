package com.programacion;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.programacion.entities.Owner;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class AppMain {
    public static void main(String[] args) {

        //ThymeleafTemplateEngine engine = new ThymeleafTemplateEngine();

        final Gson gson = new Gson();
        port(9099);

        staticFiles.location("/templates");
        get("/owners", (request, response) -> {
            String uriOwners = "http://localhost/pet-owner/sanchez1/petowner/owners";

            URL url = new URL(uriOwners);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            InputStream is = connection.getInputStream();

            Type type = new TypeToken<List<Owner>>() {
            }.getType();
            List<Owner> ownersList = gson.fromJson(new InputStreamReader(is, StandardCharsets.UTF_8), type);

            for (Owner o:ownersList) {
                System.out.println(o.toString());
            }

            HashMap<String, Object> model = new HashMap<>();
            model.put("listado", ownersList);
            return render(model, "listarOwners");
        });
    }

    private static String render(Map<String, Object> model, String pageName) {
        return new ThymeleafTemplateEngine().render(
                new ModelAndView(model, pageName)
        );
    }

}
