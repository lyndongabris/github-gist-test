package com.gist.test.api.data.responsedata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Objects;

public class GistHistory {
    private String url;
    private String version;
    private GistOwner user;
    private GistChangeStatus changeStatus;
    private OffsetDateTime committedAt;

    public GistHistory(@JsonProperty("url") String url,
                       @JsonProperty("version") String version,
                       @JsonProperty("user") GistOwner user,
                       @JsonProperty("change_status") GistChangeStatus changeStatus,
                       @JsonProperty("committed_at") OffsetDateTime committedAt) {
        this.url = url;
        this.version = version;
        this.user = user;
        this.changeStatus = changeStatus;
        this.committedAt = committedAt;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public GistOwner getUser() {
        return user;
    }

    public GistChangeStatus getChangeStatus() {
        return changeStatus;
    }

    public OffsetDateTime getCommittedAt() {
        return committedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GistHistory that = (GistHistory) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(version, that.version) &&
                Objects.equals(user, that.user) &&
                Objects.equals(changeStatus, that.changeStatus) &&
                Objects.equals(committedAt, that.committedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, version, user, changeStatus, committedAt);
    }
}
