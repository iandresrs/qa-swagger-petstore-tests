package io.petstore.swagger.tasks;

import io.petstore.swagger.enums.Constant;
import io.petstore.swagger.models.HaspDataPostPetExcel;
import io.petstore.swagger.models.buildPosPet.Category;
import io.petstore.swagger.models.buildPosPet.Tag;
import io.petstore.swagger.utils.BuildBody;
import io.petstore.swagger.utils.BuildBodyPostPet;
import io.petstore.swagger.utils.ReadConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.ArrayList;
import java.util.List;

public class ConsumptionCreatePetTask implements Task {

    private final HaspDataPostPetExcel data;
    private final String pet;

    public ConsumptionCreatePetTask(HaspDataPostPetExcel data, String pet) {
        this.data = data;
        this.pet = pet;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = buildBody(pet);
        actor.attemptsTo(
                Post.to(ReadConfiguration.getEndpoint("post_pet"))
                        .with(rq -> rq
                                .header(Constant.CONTENT_TYPE_NAME.getValue(), Constant.CONTENT_TYPE_VALUE.getValue())
                                .relaxedHTTPSValidation()
                                .body(body)));
        actor.remember("expectedPetName", data.getDataPostPetExcel().get(pet).getName());
    }

    private String buildBody(String pet) {
        var dataPet = data.getDataPostPetExcel().get(pet);

        List<Tag> listTags = new ArrayList<>();
        if (dataPet.getTags() != null) {
            for (Tag t : dataPet.getTags()) {
                listTags.add(new Tag(t.getId(), t.getName()));
            }
        }

        return BuildBody.withTemplate(Constant.STRUCTURE_POST_PET.getValue()).withValueNew(
                BuildBodyPostPet.withData(
                        dataPet.getId(),
                        new Category(dataPet.getCategory().getId(), dataPet.getCategory().getName()),
                        dataPet.getName(),
                        dataPet.getPhotoUrls(),
                        listTags,
                        dataPet.getStatus()
                )
            );
    }

    public static ConsumptionCreatePetTask withData(HaspDataPostPetExcel data, String pet) {
        return instrumented(ConsumptionCreatePetTask.class, data, pet);
    }

}
