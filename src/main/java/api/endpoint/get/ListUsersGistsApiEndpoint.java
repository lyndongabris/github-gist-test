package api.endpoint.get;

import api.response.ApiResponse;
import api.response.get.GetGistApiResponse;
import util.StringUtil;

import java.net.URI;
import java.time.OffsetDateTime;

public class ListUsersGistsApiEndpoint extends AbstractGistGetApiEndpoint{
    private String endpointUrl = "/users/{}/gists";
    private static final String SINCE_HEADER = "since";
    private final String username;

    public static GetGistApiResponse get(String username) {
        return  new ListUsersGistsApiEndpoint(username).request();
    }

    public static GetGistApiResponse getSince(String username, OffsetDateTime dateTime) {
        String sinceDate = dateTime.toString();
        ListUsersGistsApiEndpoint endpoint = new ListUsersGistsApiEndpoint(username);
        endpoint.addHeader(SINCE_HEADER, sinceDate);
        return endpoint.request();
    }

    private ListUsersGistsApiEndpoint(String username) {
        this.username = username;
    }

    @Override
    public URI getEndpointUrl() {
        String formattedEndpointUrl = StringUtil.format(endpointUrl, username);
        return URI.create(formattedEndpointUrl);
    }
}
