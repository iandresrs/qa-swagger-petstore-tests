package io.petstore.swagger.questions;

import io.petstore.swagger.enums.Constant;
import io.petstore.swagger.exeptions.GenerateException;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidatePetName implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        
        String expectedName = actor.recall(Constant.EXPECTED_PET_NAME_KEY.getValue());
        String realName = SerenityRest.lastResponse()
                .jsonPath()
                .getString("name");

        if (!expectedName.equals(realName)) {
            throw new GenerateException(GenerateException.ERROR_PET_NAME_MISMATCH);
        }

        return true;
    }

    public static ValidatePetName withName() {
        return new ValidatePetName();
    }

}
