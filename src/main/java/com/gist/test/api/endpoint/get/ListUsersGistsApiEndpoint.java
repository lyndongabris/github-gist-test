package com.gist.test.api.endpoint.get;

import com.gist.test.api.response.get.GetGistApiResponse;
import com.gist.test.util.StringUtil;

import java.net.URI;
import java.time.OffsetDateTime;

public class ListUsersGistsApiEndpoint extends AbstractGistListApiEndpoint {
    private URI endpointUri;
    private final String username;

    public static GetGistApiResponse get(String username) {
        return  new ListUsersGistsApiEndpoint(username).request();
    }

    public static GetGistApiResponse getSince(String username, OffsetDateTime dateTime) {
        ListUsersGistsApiEndpoint endpoint = new ListUsersGistsApiEndpoint(username);
        endpoint.addSinceHeader(dateTime);
        return endpoint.request();
    }

    private ListUsersGistsApiEndpoint(String username) {
        this.username = username;
    }

    @Override
    public URI getEndpointUrl() {
        if (endpointUri == null) {
            String endpointUrl = "/users/{}/gists";
            String formattedEndpointUrl = StringUtil.format(endpointUrl, username);
            endpointUri = URI.create(formattedEndpointUrl);
        }
        return endpointUri;
    }
}
