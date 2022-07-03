package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase{

    @Test
    public void boardCreation1 ()  {


        int boardCountBeforeCreation = app.getBoard().getBoardCount();

        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm("test 5");
        app.getBoard().scrollDowmTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        int boardCountAfterCreation = app.getBoard().getBoardCount();

        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }
    @Test
    public void boardCreation2 ()  {



        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm("test7");
        app.getBoard().scrollDowmTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());
    }
}
