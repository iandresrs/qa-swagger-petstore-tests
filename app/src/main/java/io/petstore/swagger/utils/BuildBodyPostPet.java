package io.petstore.swagger.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.petstore.swagger.models.buildPosPet.Category;
import io.petstore.swagger.models.buildPosPet.Tag;


public class BuildBodyPostPet {

    public static Map<String, Object> withData(Long id, Category category, String name, List<String> photoUrls,
            List<Tag> tag, String status) {
        Map<String, Object> body = new HashMap<>();
        body.put("id", id);
        body.put("category", category);
        body.put("name", name);
        body.put("photoUrls", photoUrls);
        body.put("tags", tag);
        body.put("status", status);

        return body;
    }
}
