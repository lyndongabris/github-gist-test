package api.data;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Map;

public class GistData {
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

    public GistData(@JsonProperty("url") String url,
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
                    @JsonProperty("truncated") String truncated) {
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
    }
}
