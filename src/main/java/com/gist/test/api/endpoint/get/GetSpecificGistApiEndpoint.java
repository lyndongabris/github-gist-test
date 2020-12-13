package com.gist.test.api.endpoint.get;

import com.gist.test.api.endpoint.AuthenticatedEndpoint;
import com.gist.test.api.response.get.GetGistApiResponse;
import com.gist.test.util.PropertiesUtil;
import com.gist.test.util.StringUtil;

import java.net.URI;

public class GetSpecificGistApiEndpoint extends AbstractGistGetApiEndpoint implements AuthenticatedEndpoint {
    private URI endpointUrl;
    private final String endpointString = "/gists/{}";
    private String id;

    public static GetGistApiResponse get(String id) {
        GetSpecificGistApiEndpoint endpoint = new GetSpecificGistApiEndpoint(id);
        return endpoint.request();
    }

    private GetSpecificGistApiEndpoint(String id) {
        this.id = id;
        addAuthentication(this, PropertiesUtil.getSystem("gist.token"));
    }

    @Override
    public URI getEndpointUrl() {
        if (endpointUrl == null) {
            endpointUrl = URI.create(StringUtil.format(endpointString, id));
        }
        return endpointUrl;
    }
}
