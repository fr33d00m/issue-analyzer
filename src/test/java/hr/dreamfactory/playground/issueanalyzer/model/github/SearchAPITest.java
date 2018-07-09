package hr.dreamfactory.playground.issueanalyzer.model.github;

import hr.dreamfactory.playground.issueanalyzer.FeignBuilder;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchAPITest {

    @Test
    public void search_something_nice() throws Exception {
        FeignBuilder feignBuilder = new FeignBuilder();

        SearchAPI remoteGithubRepository = feignBuilder.buildSearchAPI();
        GithubSearchResponse something = remoteGithubRepository.searchIssues("something");

        Assert.assertNotNull(something);
        Assert.assertNotEquals(new Long(0), something.getTotalCount());
    }

}