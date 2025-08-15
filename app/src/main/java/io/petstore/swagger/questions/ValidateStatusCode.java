package io.petstore.swagger.questions;

import io.petstore.swagger.exeptions.GenerateException;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateStatusCode implements Question<Boolean> {

    private Integer expectedCode;

    public ValidateStatusCode(Integer expectedCode) {
        this.expectedCode = expectedCode;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        Integer realCode = SerenityRest.lastResponse().getStatusCode();

        if (!expectedCode.equals(realCode)) {
            throw new GenerateException(GenerateException.STATUS_CODE_ERROR);
        }

        return true;
    }

    public static ValidateStatusCode withCode(Integer expectedCode) {
        return new ValidateStatusCode(expectedCode);
    }

}
