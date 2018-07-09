package hr.dreamfactory.playground.issueanalyzer.repositories;

import hr.dreamfactory.playground.issueanalyzer.model.TermScore;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TermScoreRepository extends CrudRepository<TermScore, Long> {

    List<TermScore> findByTerm(String term);
}