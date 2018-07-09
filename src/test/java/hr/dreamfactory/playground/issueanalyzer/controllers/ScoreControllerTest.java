package hr.dreamfactory.playground.issueanalyzer.controllers;

import hr.dreamfactory.playground.issueanalyzer.model.TermScore;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreControllerTest {

    @Autowired
    ScoreController scoreController;

    @Test
    public void search_Empty_Null() throws Exception {
        TermScore shouldBeNull = scoreController.score("");
        TermScore shouldAlsoBeNull = scoreController.score(null);

        Assert.assertNull(shouldBeNull);
        Assert.assertNull(shouldAlsoBeNull);
    }

    @Test
    public void search_NonEmpty_HasValue() throws Exception {
        TermScore test = scoreController.score("test");

        Assert.assertNotNull(test.getId());
        Assert.assertNotNull(test.getScore());
        Assert.assertNotNull("test", test.getTerm());
    }
}