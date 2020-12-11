package api.data.response;


import api.data.GistData;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

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
}
