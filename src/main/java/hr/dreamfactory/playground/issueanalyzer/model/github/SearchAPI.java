package hr.dreamfactory.playground.issueanalyzer.model.github;

import feign.Param;
import feign.RequestLine;
import hr.dreamfactory.playground.issueanalyzer.model.github.GithubSearchResponse;

public interface SearchAPI {

    @RequestLine("GET search/issues?q={query}")
    GithubSearchResponse searchIssues(@Param("query") String query);
}
