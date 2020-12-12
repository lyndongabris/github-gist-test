package api.endpoint.get;

import api.response.get.GetGistApiResponse;

import java.net.URI;
import java.time.OffsetDateTime;

public class GetAuthenticatedGistsApiEndpoint extends AbstractGistListApiEndpoint {
    private URI endpointUrl = URI.create("/gists");
    private static final String TOKEN_HEADER_KEY = "Authorization";
    private static final String SINCE_HEADER = "since";

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
        addHeader(TOKEN_HEADER_KEY, token);
    }

    @Override
    public URI getEndpointUrl() {
        return endpointUrl;
    }
}
