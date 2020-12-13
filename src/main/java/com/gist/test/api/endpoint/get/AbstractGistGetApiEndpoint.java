package com.gist.test.api.endpoint.get;

import com.gist.test.api.endpoint.AbstractApiEndpoint;
import com.gist.test.api.endpoint.ApiMethod;
import com.gist.test.api.response.get.GetGistApiResponse;

import static com.gist.test.api.endpoint.ApiMethod.GET;

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
