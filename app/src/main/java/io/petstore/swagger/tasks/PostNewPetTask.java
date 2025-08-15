package io.petstore.swagger.tasks;

import io.petstore.swagger.enums.Constant;
import io.petstore.swagger.exeptions.GenerateException;
import io.petstore.swagger.models.HaspDataPostPetExcel;
import io.petstore.swagger.models.buildPosPet.Category;
import io.petstore.swagger.models.buildPosPet.Tag;
import io.petstore.swagger.utils.PetRequestBuilder;
import io.petstore.swagger.utils.ReadConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PostNewPetTask implements Task {

    private final HaspDataPostPetExcel data;
    private final String pet;

    public PostNewPetTask(HaspDataPostPetExcel data, String pet) {
        this.data = data;
        this.pet = pet;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = buildBodyFromData();
        actor.attemptsTo(
                Post.to(ReadConfiguration.getEndpoint("post_pet"))
                        .with(rq -> rq
                                .headers(contentTypeHeader())
                                .relaxedHTTPSValidation()
                                .body(body)));
        actor.remember(Constant.EXPECTED_PET_NAME_KEY.getValue(), data.getDataPostPetExcel().get(pet).getName());
    }

    private static Map<String, Object> contentTypeHeader() {
        return Map.of(
                Constant.CONTENT_TYPE_NAME.getValue(),
                Constant.CONTENT_TYPE_VALUE.getValue());
    }

    private String buildBodyFromData() {
        var dataPet = data.getDataPostPetExcel().get(pet);
        if (dataPet == null) {
            throw new IllegalArgumentException(GenerateException.PET_DATA_NOT_FOUND + pet);
        }

        List<Tag> tags = (dataPet.getTags() != null)
                ? dataPet.getTags().stream()
                        .map(t -> new Tag(t.getId(), t.getName()))
                        .collect(Collectors.toList())
                : Collections.emptyList();

        Category category = (dataPet.getCategory() != null)
                ? new Category(dataPet.getCategory().getId(), dataPet.getCategory().getName())
                : null;

        return new PetRequestBuilder()
                .withId(dataPet.getId())
                .withCategory(category)
                .withName(dataPet.getName())
                .withPhotoUrls(dataPet.getPhotoUrls())
                .withTags(tags)
                .withStatus(dataPet.getStatus())
                .build();
    }

    public static PostNewPetTask withData(HaspDataPostPetExcel data, String pet) {
        return instrumented(PostNewPetTask.class, data, pet);
    }

}
