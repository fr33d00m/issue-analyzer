package hr.dreamfactory.playground.issueanalyzer.model;

import hr.dreamfactory.playground.issueanalyzer.repositories.TermScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TermScoreCache {
    @Autowired
    private TermScoreCalculator calculator;

    @Autowired
    private TermScoreRepository termScoreRepository;

    public TermScore calculate(String term){
        Optional<TermScore> byKeyword = termScoreRepository.findByTerm(term)
                .stream()
                .findFirst();

        if(byKeyword.isPresent()){
            return byKeyword.get();
        }

        TermScore score = calculator.calculate(term);
        termScoreRepository.save(score);

        return score;
    }
}
