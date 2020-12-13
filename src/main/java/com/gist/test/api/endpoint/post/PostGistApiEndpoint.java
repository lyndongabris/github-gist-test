package com.gist.test.api.endpoint.post;

import com.gist.test.api.data.requestdata.GistWriteData;
import com.gist.test.api.payload.post.PostGistApiPayload;
import com.gist.test.api.response.post.PostGistApiResponse;

import java.net.URI;

public class PostGistApiEndpoint extends AbstractPostGistApiEndpoint {
    private final URI endpointUrl = URI.create("/gists");
    private GistWriteData data;

    public static PostGistApiResponse create(String token, GistWriteData data) {
        PostGistApiEndpoint endpoint = new PostGistApiEndpoint(token, data);
        return endpoint.request();
    }

    private PostGistApiEndpoint(String token, GistWriteData data) {
        this.setPayload(new PostGistApiPayload(data));
        addAuthentication(this, token);
    }

    @Override
    public URI getEndpointUrl() {
        return endpointUrl;
    }
}
