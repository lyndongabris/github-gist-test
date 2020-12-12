package com.gist.test.api.endpoint.get;

import com.gist.test.api.response.get.GetGistApiResponse;
import com.gist.test.util.StringUtil;

import java.net.URI;

public class GetSpecificGistApiEndpoint extends  AbstractGistGetApiEndpoint{
    private URI endpointUrl;
    private final String endpointString = "/gists/{}";
    private String id;

    public static GetGistApiResponse get(String id) {
        GetSpecificGistApiEndpoint endpoint = new GetSpecificGistApiEndpoint(id);
        return endpoint.request();
    }

    private GetSpecificGistApiEndpoint(String id) {
        this.id = id;
    }

    @Override
    public URI getEndpointUrl() {
        if (endpointUrl == null) {
            endpointUrl = URI.create(StringUtil.format(endpointString, id));
        }
        return endpointUrl;
    }
}
