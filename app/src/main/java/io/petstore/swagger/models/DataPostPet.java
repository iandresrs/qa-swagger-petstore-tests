package io.petstore.swagger.models;

import io.petstore.swagger.models.buildPosPet.Category;
import io.petstore.swagger.models.buildPosPet.Tag;

import java.util.List;

public class DataPostPet {

    private String scenario;
    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    

    public DataPostPet() {
    }

    public DataPostPet(String scenario, Long id, Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
        this.scenario = scenario;
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public String getScenario() {
        return scenario;
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }
    
}
