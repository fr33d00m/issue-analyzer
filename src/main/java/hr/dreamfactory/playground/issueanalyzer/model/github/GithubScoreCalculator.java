package hr.dreamfactory.playground.issueanalyzer.model.github;

import hr.dreamfactory.playground.issueanalyzer.model.TermScore;
import hr.dreamfactory.playground.issueanalyzer.model.TermScoreCalculator;
import hr.dreamfactory.playground.issueanalyzer.repositories.SearchAPI;
import org.springframework.beans.factory.annotation.Autowired;

public class GithubScoreCalculator implements TermScoreCalculator {

    public static final String POSITIVE = "rocks";
    public static final String NEGATIVE = "sucks";

    @Autowired
    private SearchAPI repository;

    @Override
    public TermScore calculate(String keyword) {
        GithubSearchResponse positive = repository.searchIssues(keyword + " " + POSITIVE);
        GithubSearchResponse negative = repository.searchIssues(keyword + " " + NEGATIVE);

        return TermScore.create(
                keyword, extractCount(positive), extractCount(negative));
    }


    private static Long extractCount(GithubSearchResponse response){
        if(response == null || response.getTotalCount() == null){
            return 0l;
        }

        return response.getTotalCount();
    }
}
