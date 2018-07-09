package hr.dreamfactory.playground.issueanalyzer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class TermScore {

    public static final int MAX_SCORE = 10;
    public static final int MIN_SCORE = 0;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column(unique=true)
    private String term;

    private Double score;

    public static TermScore create(String keyword, Long positive, Long negative){
        TermScore wordScore =  new TermScore();
        wordScore.setTerm(keyword);
        wordScore.setScore(calculateScore(positive, negative));
        return wordScore;
    }

    public static double calculateScore(Long positive, Long negative){
        if(positive == 0){
            return MIN_SCORE;
        }

        return MAX_SCORE * positive / (double) (negative + positive);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
