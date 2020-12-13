package com.gist.test.api.endpoint.get;

import com.gist.test.api.endpoint.AuthenticatedEndpoint;
import com.gist.test.api.response.get.GetGistApiResponse;

import java.net.URI;
import java.time.OffsetDateTime;

public class ListAuthenticatedUsersGistsApiEndpoint extends AbstractGistListApiEndpoint implements AuthenticatedEndpoint {
    private final URI endpointUrl = URI.create("/gists");
    private static final String TOKEN_HEADER_KEY = "Authorization";

    public static GetGistApiResponse get(String token) {
        ListAuthenticatedUsersGistsApiEndpoint endpoint = new ListAuthenticatedUsersGistsApiEndpoint(token);
        return endpoint.request();
    }

    public static GetGistApiResponse getSince(String token, OffsetDateTime dateTime) {
        ListAuthenticatedUsersGistsApiEndpoint endpoint = new ListAuthenticatedUsersGistsApiEndpoint(token);
        endpoint.addSinceHeader(dateTime);
        return endpoint.request();
    }

    private ListAuthenticatedUsersGistsApiEndpoint(String token) {
        addAuthentication(this, token);
    }

    @Override
    public URI getEndpointUrl() {
        return endpointUrl;
    }
}
