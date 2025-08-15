package io.petstore.swagger.questions;

import io.petstore.swagger.exeptions.GenerateException;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidatePetName implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String expectedName = actor.recall("expectedPetName");
        String realName = SerenityRest.lastResponse()
                .jsonPath()
                .getString("name");

        System.out.println("Expected Name: " + expectedName);
        System.out.println("Real Name: " + realName);

        if (!expectedName.equals(realName)) {
            throw new GenerateException(GenerateException.ERROR_PET_NAME_MISMATCH);
        }

        return true;
    }

    public static ValidatePetName withName() {
        return new ValidatePetName();
    }

}
