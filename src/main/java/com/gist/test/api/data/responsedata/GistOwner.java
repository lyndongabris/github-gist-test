package com.gist.test.api.data.responsedata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class GistOwner {
    private String login;
    private int id;
    private String nodeId;
    private String avatarUrl;
    private String gravatarId;
    private String url;
    private String htmlUrl;
    private String followersUrl;
    private String followingUrl;
    private String gistsUrl;
    private String starredUrl;
    private String subscriptionsUrl;
    private String organizationsUrl;
    private String reposUrl;
    private String eventsUrl;
    private String receivedEventsUrl;
    private String type;
    private boolean siteAdmin;

    public GistOwner(@JsonProperty("login") String login,
                     @JsonProperty("id") int id,
                     @JsonProperty("node_id") String nodeId,
                     @JsonProperty("avatar_url") String avatarUrl,
                     @JsonProperty("gravatar_id") String gravatarId,
                     @JsonProperty("url") String url,
                     @JsonProperty("html_url") String htmlUrl,
                     @JsonProperty("followers_url") String followersUrl,
                     @JsonProperty("following_url") String followingUrl,
                     @JsonProperty("gists_url") String gistsUrl,
                     @JsonProperty("starred_url") String starredUrl,
                     @JsonProperty("subscriptions_url") String subscriptionsUrl,
                     @JsonProperty("organizations_url") String organizationsUrl,
                     @JsonProperty("repos_url") String reposUrl,
                     @JsonProperty("events_url") String eventsUrl,
                     @JsonProperty("received_events_url") String receivedEventsUrl,
                     @JsonProperty("type") String type,
                     @JsonProperty("site_admin") boolean siteAdmin) {
        this.login = login;
        this.id = id;
        this.nodeId = nodeId;
        this.avatarUrl = avatarUrl;
        this.gravatarId = gravatarId;
        this.url = url;
        this.htmlUrl = htmlUrl;
        this.followersUrl = followersUrl;
        this.followingUrl = followingUrl;
        this.gistsUrl = gistsUrl;
        this.starredUrl = starredUrl;
        this.subscriptionsUrl = subscriptionsUrl;
        this.organizationsUrl = organizationsUrl;
        this.reposUrl = reposUrl;
        this.eventsUrl = eventsUrl;
        this.receivedEventsUrl = receivedEventsUrl;
        this.type = type;
        this.siteAdmin = siteAdmin;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public boolean isSiteAdmin() {
        return siteAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GistOwner gistOwner = (GistOwner) o;
        return id == gistOwner.id &&
                siteAdmin == gistOwner.siteAdmin &&
                Objects.equals(login, gistOwner.login) &&
                Objects.equals(nodeId, gistOwner.nodeId) &&
                Objects.equals(avatarUrl, gistOwner.avatarUrl) &&
                Objects.equals(gravatarId, gistOwner.gravatarId) &&
                Objects.equals(url, gistOwner.url) &&
                Objects.equals(htmlUrl, gistOwner.htmlUrl) &&
                Objects.equals(followersUrl, gistOwner.followersUrl) &&
                Objects.equals(followingUrl, gistOwner.followingUrl) &&
                Objects.equals(gistsUrl, gistOwner.gistsUrl) &&
                Objects.equals(starredUrl, gistOwner.starredUrl) &&
                Objects.equals(subscriptionsUrl, gistOwner.subscriptionsUrl) &&
                Objects.equals(organizationsUrl, gistOwner.organizationsUrl) &&
                Objects.equals(reposUrl, gistOwner.reposUrl) &&
                Objects.equals(eventsUrl, gistOwner.eventsUrl) &&
                Objects.equals(receivedEventsUrl, gistOwner.receivedEventsUrl) &&
                Objects.equals(type, gistOwner.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, id, nodeId, avatarUrl, gravatarId, url, htmlUrl, followersUrl, followingUrl, gistsUrl, starredUrl, subscriptionsUrl, organizationsUrl, reposUrl, eventsUrl, receivedEventsUrl, type, siteAdmin);
    }
}
