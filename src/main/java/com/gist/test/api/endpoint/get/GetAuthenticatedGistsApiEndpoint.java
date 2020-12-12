package com.gist.test.api.endpoint.get;

import com.gist.test.api.endpoint.AuthenticatedEndpoint;
import com.gist.test.api.response.get.GetGistApiResponse;

import java.net.URI;
import java.time.OffsetDateTime;

public class GetAuthenticatedGistsApiEndpoint extends AbstractGistListApiEndpoint implements AuthenticatedEndpoint {
    private URI endpointUrl = URI.create("/gists");
    private static final String TOKEN_HEADER_KEY = "Authorization";

    public static GetGistApiResponse get(String token) {
        GetAuthenticatedGistsApiEndpoint endpoint = new GetAuthenticatedGistsApiEndpoint(token);
        return endpoint.request();
    }

    public static GetGistApiResponse getSince(String token, OffsetDateTime dateTime) {
        GetAuthenticatedGistsApiEndpoint endpoint = new GetAuthenticatedGistsApiEndpoint(token);
        endpoint.addSinceHeader(dateTime);
        return endpoint.request();
    }

    private GetAuthenticatedGistsApiEndpoint(String token) {
        addAuthentication(this, token);
    }

    @Override
    public URI getEndpointUrl() {
        return endpointUrl;
    }
}
