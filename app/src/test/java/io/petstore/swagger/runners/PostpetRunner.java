package io.petstore.swagger.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin = "pretty",
    glue = "io.petstore.swagger.stepDefinitions",
    features = "src/test/resources/features/post_pet.feature",
    tags = "@PostPet",
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class PostpetRunner {

}
