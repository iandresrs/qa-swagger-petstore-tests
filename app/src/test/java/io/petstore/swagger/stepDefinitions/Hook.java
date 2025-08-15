package io.petstore.swagger.stepDefinitions;

import io.cucumber.java.Before;
import io.petstore.swagger.enums.Actors;
import io.petstore.swagger.enums.Constant;
import io.petstore.swagger.utils.FeedData;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class Hook {

    @Before
    public void setupStage(){
        setTheStage(new OnlineCast());
        theActor(Actors.ACTOR.getNameActor());
        FeedData feedData = new FeedData();
        feedData.extractData(
                Constant.PATH_FILE_EXCEL.getValue(),
                Constant.NAME_SHEET_EXCEL.getValue()
        );
    }

}
