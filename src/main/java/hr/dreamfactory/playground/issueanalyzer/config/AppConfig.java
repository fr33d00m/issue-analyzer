package hr.dreamfactory.playground.issueanalyzer.config;

import hr.dreamfactory.playground.issueanalyzer.FeignBuilder;
import hr.dreamfactory.playground.issueanalyzer.model.github.GithubScoreCalculator;
import hr.dreamfactory.playground.issueanalyzer.model.TermScoreCache;
import hr.dreamfactory.playground.issueanalyzer.model.TermScoreCalculator;
import hr.dreamfactory.playground.issueanalyzer.model.github.SearchAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    private FeignBuilder builder;

    public AppConfig() {
        builder = new FeignBuilder();
    }

    @Bean
    public TermScoreCalculator constructCalculator(){
        return new GithubScoreCalculator();
    }

    @Bean
    public TermScoreCache constructWordScoreCache(){
        return new TermScoreCache();
    }

    @Bean
    public SearchAPI constructGithub(){
        return builder.buildSearchAPI();
    }

}
