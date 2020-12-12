package com.gist.test.api.data.responsedata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class GistChangeStatus {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GistChangeStatus that = (GistChangeStatus) o;
        return deletions == that.deletions &&
                additions == that.additions &&
                total == that.total;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deletions, additions, total);
    }
}
