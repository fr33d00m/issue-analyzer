package hr.dreamfactory.playground.issueanalyzer.repositories;

import hr.dreamfactory.playground.issueanalyzer.FeignBuilder;
import hr.dreamfactory.playground.issueanalyzer.model.github.GithubSearchResponse;
import hr.dreamfactory.playground.issueanalyzer.model.github.SearchAPI;
import org.junit.Assert;
import org.junit.Test;

public class RemoteGithubRepositoryTest {

    @Test
    public void search_something_nice() throws Exception {
        FeignBuilder feignBuilder = new FeignBuilder();

        SearchAPI remoteGithubRepository = feignBuilder.buildSearchAPI();
        GithubSearchResponse something = remoteGithubRepository.searchIssues("something");

        Assert.assertNotNull(something);
        Assert.assertNotEquals(new Long(0), something.getTotalCount());
    }
}