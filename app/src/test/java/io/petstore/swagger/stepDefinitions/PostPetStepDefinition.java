package io.petstore.swagger.stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.petstore.swagger.models.HaspDataPostPetExcel;
import io.petstore.swagger.questions.ValidatePetName;
import io.petstore.swagger.questions.ValidateStatusCode;
import io.petstore.swagger.tasks.PostNewPetTask;
import io.petstore.swagger.utils.ReadConfiguration;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class PostPetStepDefinition {

    HaspDataPostPetExcel data = new HaspDataPostPetExcel();

    @Given("that can consume the service")
    public void thatCanConsumeTheService() {
        theActorInTheSpotlight()
                .whoCan(
                        CallAnApi.at(
                                ReadConfiguration.getUrl("baseurl")));
    }

    @When("i carry out the validation of the pet {string}")
    public void iCarryOutTheValidationOfThePet(String pet) {
        theActorInTheSpotlight().attemptsTo(
                PostNewPetTask.withData(data, pet));
    }

    @Then("the service responds with status code {int}")
    public void theServiceRespondsWithStatusCode(Integer code) {
        theActorInTheSpotlight().should(
                seeThat(ValidateStatusCode.withCode(code)));
    }

    @Then("i can validate the pet's name in the response")
    public void iCanValidateThePetSNameInTheResponse() {
        theActorInTheSpotlight().should(
            seeThat(ValidatePetName.withName()));
    }

}
