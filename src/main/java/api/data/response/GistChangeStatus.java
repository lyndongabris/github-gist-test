package api.data.response;

import api.data.GistData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GistChangeStatus implements GistData {
    private int deletions;
    private int additions;
    private int total;

    public GistChangeStatus(@JsonProperty("deletions") int deletions,
                            @JsonProperty("additions") int additions,
                            @JsonProperty("total") int total) {
        this.deletions = deletions;
        this.additions = additions;
        this.total = total;
    }

    public int getDeletions() {
        return deletions;
    }

    public int getAdditions() {
        return additions;
    }

    public int getTotal() {
        return total;
    }
}
