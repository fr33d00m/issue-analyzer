package hr.dreamfactory.playground.issueanalyzer.model.github;

/**
 * We only care about the @total_count from all the response fields.
 * Hence we only deserialize the count field.
 */
public class GithubSearchResponse {
    private Long totalCount;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
