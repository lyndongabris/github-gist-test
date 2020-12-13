package com.gist.test.api.endpoint.delete;

import com.gist.test.api.response.delete.DeleteGistApiResponse;
import com.gist.test.util.StringUtil;

import java.net.URI;

import static com.google.common.base.Preconditions.checkNotNull;

public class DeleteGistApiEndpoint extends AbstractDeleteGistApiEndpoint {
    private URI endpointUrl;
    private String id;

    public static DeleteGistApiResponse delete(String token, String id) {
        checkNotNull("Token cannot be null", token);
        checkNotNull("Id cannot be null", id);
        DeleteGistApiEndpoint endpoint = new DeleteGistApiEndpoint(token, id);
        return endpoint.request();
    }

    private DeleteGistApiEndpoint(String token, String id) {
        this.id = id;
        addAuthentication(this, token);
    }

    @Override
    public URI getEndpointUrl() {
        if (endpointUrl == null) {
            String endpointString = "/gists/{}";
            endpointUrl = URI.create(StringUtil.format(endpointString, id));
        }
        return endpointUrl;
    }
}
