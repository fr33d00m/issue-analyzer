package hr.dreamfactory.playground.issueanalyzer.controllers;

import hr.dreamfactory.playground.issueanalyzer.model.TermScore;
import hr.dreamfactory.playground.issueanalyzer.model.TermScoreCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {

    @Autowired
    private TermScoreCache scoreCache;

    @RequestMapping(path = "/score", produces = "application/json")
    public TermScore score(@RequestParam("term") String term) {
        if(term == null || "".equals(term)){
            return null;
        }

        return scoreCache.calculate(term);
    }

}
