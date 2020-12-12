package com.gist.test.api.data.responsedata;


import com.gist.test.api.data.GistData;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GistResponseData implements GistData {
    private String url;
    private String forksUrl;
    private String commitsUrl;
    private String id;
    private String nodeId;
    private String gitPullUrl;
    private String gitPushUrl;
    private String htmlUrl;
    private Map<String, GistFileInfo> files;
    private boolean isPublic;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;
    private String description;
    private int comments;
    private String user;
    private String commentsUrl;
    private GistOwner owner;
    private String truncated;
    private List<GistFork> forks;
    private List<GistHistory> history;

    public GistResponseData(@JsonProperty("url") String url,
                            @JsonProperty("forks_url") String forksUrl,
                            @JsonProperty("commits_url") String commitsUrl,
                            @JsonProperty("id") String id,
                            @JsonProperty("node_id") String nodeId,
                            @JsonProperty("git_pull_url") String gitPullUrl,
                            @JsonProperty("git_push_url") String gitPushUrl,
                            @JsonProperty("html_url") String htmlUrl,
                            @JsonProperty("files") Map<String, GistFileInfo> files,
                            @JsonProperty("public") boolean isPublic,
                            @JsonProperty("created_at") OffsetDateTime created_at,
                            @JsonProperty("updated_at") OffsetDateTime updated_at,
                            @JsonProperty("description") String description,
                            @JsonProperty("comments") int comments,
                            @JsonProperty("user") String user,
                            @JsonProperty("comments_url") String commentsUrl,
                            @JsonProperty("owner") GistOwner owner,
                            @JsonProperty("truncated") String truncated,
                            @JsonProperty("forks") List<GistFork> forks,
                            @JsonProperty("history") List<GistHistory> history                  ){
        this.url = url;
        this.forksUrl = forksUrl;
        this.commitsUrl = commitsUrl;
        this.id = id;
        this.nodeId = nodeId;
        this.gitPullUrl = gitPullUrl;
        this.gitPushUrl = gitPushUrl;
        this.htmlUrl = htmlUrl;
        this.files = files;
        this.isPublic = isPublic;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.description = description;
        this.comments = comments;
        this.user = user;
        this.commentsUrl = commentsUrl;
        this.owner = owner;
        this.truncated = truncated;
        this.forks = forks;
        this.history = history;
    }

    public String getUrl() {
        return url;
    }

    public String getForksUrl() {
        return forksUrl;
    }

    public String getCommitsUrl() {
        return commitsUrl;
    }

    public String getId() {
        return id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getGitPullUrl() {
        return gitPullUrl;
    }

    public String getGitPushUrl() {
        return gitPushUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public Map<String, GistFileInfo> getFiles() {
        return files;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public OffsetDateTime getCreated_at() {
        return created_at;
    }

    public OffsetDateTime getUpdated_at() {
        return updated_at;
    }

    public String getDescription() {
        return description;
    }

    public int getComments() {
        return comments;
    }

    public String getUser() {
        return user;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public GistOwner getOwner() {
        return owner;
    }

    public String getTruncated() {
        return truncated;
    }

    public List<GistFork> getForks() {
        return forks;
    }

    public List<GistHistory> getHistory() {
        return history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GistResponseData that = (GistResponseData) o;
        return isPublic == that.isPublic &&
                comments == that.comments &&
                url.equals(that.url) &&
                forksUrl.equals(that.forksUrl) &&
                commitsUrl.equals(that.commitsUrl) &&
                id.equals(that.id) &&
                nodeId.equals(that.nodeId) &&
                gitPullUrl.equals(that.gitPullUrl) &&
                gitPushUrl.equals(that.gitPushUrl) &&
                htmlUrl.equals(that.htmlUrl) &&
                files.equals(that.files) &&
                created_at.equals(that.created_at) &&
                updated_at.equals(that.updated_at) &&
                description.equals(that.description) &&
                user.equals(that.user) &&
                commentsUrl.equals(that.commentsUrl) &&
                owner.equals(that.owner) &&
                truncated.equals(that.truncated) &&
                Objects.equals(forks, that.forks) &&
                Objects.equals(history, that.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, forksUrl, commitsUrl, id, nodeId, gitPullUrl, gitPushUrl, htmlUrl, files, isPublic, created_at, updated_at, description, comments, user, commentsUrl, owner, truncated, forks, history);
    }
}
