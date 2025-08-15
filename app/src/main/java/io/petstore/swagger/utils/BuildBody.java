package io.petstore.swagger.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import io.petstore.swagger.exeptions.GenerateException;

public class BuildBody {

    private String templateRoute;
    private static final Logger logger = Logger.getLogger("com.library.books");
    private static final Gson gson = new Gson();

    public BuildBody(String templateRoute) {
        this.templateRoute = templateRoute;
    }

    public static BuildBody withTemplate(String template) {
        return new BuildBody(template);
    }

    private static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    private String parseJson(String route) {
        String result = "";
        try {
            result = readFileAsString(route);
        } catch (Exception e) {
            logger.log(Level.SEVERE, GenerateException.JSON_TEMPLATE_READ_ERROR, e);
        }
        return result;
    }

    public String withValueNew(Map<String, Object> values) {
        String newTemplate = parseJson(templateRoute);

        for (Map.Entry<String, Object> entry : values.entrySet()) {
            String placeholder = "${" + entry.getKey() + "}";
            Object val = entry.getValue();

            if (val instanceof List || val instanceof Map ||
                    (!(val instanceof String) && !(val instanceof Number) && !(val instanceof Boolean))) {
                String valueJson = gson.toJson(val);
                newTemplate = newTemplate.replace("\"" + placeholder + "\"", valueJson);
            } else if (val instanceof Number) {
                newTemplate = newTemplate.replace("\"" + placeholder + "\"", val.toString());
            } else {
                newTemplate = newTemplate.replace(placeholder, val.toString());
            }
        }
        return newTemplate;
    }

}
