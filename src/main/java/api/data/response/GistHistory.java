package api.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

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
}
