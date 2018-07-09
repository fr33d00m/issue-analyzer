package hr.dreamfactory.playground.issueanalyzer.model.github;

import feign.Param;
import feign.RequestLine;

public interface SearchAPI {

    @RequestLine("GET search/issues?q={query}")
    GithubSearchResponse searchIssues(@Param("query") String query);
}
