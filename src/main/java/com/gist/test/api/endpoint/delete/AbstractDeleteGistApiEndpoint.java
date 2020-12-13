package com.gist.test.api.endpoint.delete;

import com.gist.test.api.endpoint.AbstractApiEndpoint;
import com.gist.test.api.endpoint.ApiMethod;
import com.gist.test.api.endpoint.AuthenticatedEndpoint;
import com.gist.test.api.response.delete.DeleteGistApiResponse;

public abstract class AbstractDeleteGistApiEndpoint extends AbstractApiEndpoint<DeleteGistApiResponse> implements AuthenticatedEndpoint {
    @Override
    public ApiMethod getMethod() {
        return ApiMethod.DELETE;
    }

    @Override
    public Class<DeleteGistApiResponse> getResponseClass() {
        return DeleteGistApiResponse.class;
    }
}
