package io.petstore.swagger.utils;

import java.util.Collections;
import java.util.List;

import io.petstore.swagger.enums.Constant;
import io.petstore.swagger.models.buildPosPet.Category;
import io.petstore.swagger.models.buildPosPet.Tag;

public class PetRequestBuilder {

    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    public PetRequestBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public PetRequestBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public PetRequestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PetRequestBuilder withPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

    public PetRequestBuilder withTags(List<Tag> tags) {
        this.tags = (tags != null) ? tags : Collections.emptyList();
        return this;
    }

    public PetRequestBuilder withStatus(String status) {
        this.status = status;
        return this;
    }

    public String build() {
        return BuildBody.withTemplate(Constant.STRUCTURE_POST_PET.getValue())
                .withValueNew(
                        BuildBodyPostPet.withData(id, category, name, photoUrls, tags, status));
    }

}
