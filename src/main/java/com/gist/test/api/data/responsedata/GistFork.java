package com.gist.test.api.data.responsedata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Objects;

public class GistFork {
    private GistOwner user;
    private String url;
    private String id;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public GistFork(@JsonProperty("user") GistOwner user,
                    @JsonProperty("url") String url,
                    @JsonProperty("id") String id,
                    @JsonProperty("created_at") OffsetDateTime createdAt,
                    @JsonProperty("updated_at") OffsetDateTime updatedAt) {
        this.user = user;
        this.url = url;
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public GistOwner getUser() {
        return user;
    }

    public String getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GistFork gistFork = (GistFork) o;
        return Objects.equals(user, gistFork.user) &&
                Objects.equals(url, gistFork.url) &&
                Objects.equals(id, gistFork.id) &&
                Objects.equals(createdAt, gistFork.createdAt) &&
                Objects.equals(updatedAt, gistFork.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, url, id, createdAt, updatedAt);
    }
}
