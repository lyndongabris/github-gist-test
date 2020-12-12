package api.endpoint.get;

import api.endpoint.AbstractApiEndpoint;
import api.endpoint.ApiMethod;
import api.response.get.GetGistApiResponse;

import static api.endpoint.ApiMethod.GET;

public abstract class AbstractGistGetApiEndpoint extends AbstractApiEndpoint<GetGistApiResponse> {
    @Override
    public ApiMethod getMethod() {
        return GET;
    }

    @Override
    public Class<GetGistApiResponse> getResponseClass() {
        return GetGistApiResponse.class;
    }
}
