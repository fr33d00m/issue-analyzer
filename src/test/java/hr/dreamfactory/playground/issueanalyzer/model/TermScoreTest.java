package hr.dreamfactory.playground.issueanalyzer.model;

import org.junit.Assert;
import org.junit.Test;

public class TermScoreTest {

    @Test (expected = NullPointerException.class)
    public void create_Null_Exception() throws Exception {
        TermScore termScore = TermScore.create(null, null, null);
    }

    @Test
    public void create_Valid_OK() throws Exception {
        TermScore test = TermScore.create("test", 20l, 180l);

        Assert.assertEquals("test", test.getTerm());
        Assert.assertEquals(new Double(1), test.getScore());
    }

    @Test
    public void calculate_Max_OK() throws Exception {
        Double score = TermScore.calculateScore( 180l, 0l);

        Assert.assertEquals(new Double(10), score);
    }

    @Test
    public void calculate_Half_OK() throws Exception {
        Double score = TermScore.calculateScore( 180l, 180l);

        Assert.assertEquals(new Double(5), score);
    }


    @Test
    public void calculate_Min_OK() throws Exception {
        Double score = TermScore.calculateScore( 0l, 180l);

        Assert.assertEquals(new Double(0), score);
    }


    @Test
    public void calculate_AllZero_OK() throws Exception {
        Double score = TermScore.calculateScore( 0l, 0l);

        Assert.assertEquals(new Double(0), score);
    }

}