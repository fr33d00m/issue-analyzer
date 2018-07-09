package hr.dreamfactory.playground.issueanalyzer.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TermScoreCacheTest {

    @Autowired
    TermScoreCache cache;

    @Test
    public void name_1_2() throws Exception {
        TermScore test = cache.calculate("test");

        Assert.assertNotNull(test);
        Assert.assertNotNull(test.getId());
        Assert.assertNotNull(test.getScore());

        Long previousId = new Long(test.getId());

        TermScore fromCache = cache.calculate("test");
        Assert.assertEquals(previousId, fromCache.getId());

    }
}