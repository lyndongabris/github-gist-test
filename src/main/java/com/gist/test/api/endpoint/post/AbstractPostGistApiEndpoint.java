package com.gist.test.api.endpoint.post;

import com.gist.test.api.endpoint.AbstractApiEndpoint;
import com.gist.test.api.endpoint.ApiMethod;
import com.gist.test.api.endpoint.AuthenticatedEndpoint;
import com.gist.test.api.response.post.PostGistApiResponse;


public abstract class AbstractPostGistApiEndpoint extends AbstractApiEndpoint<PostGistApiResponse> implements AuthenticatedEndpoint {
    @Override
    public ApiMethod getMethod() {
        return ApiMethod.POST;
    }

    @Override
    public Class<PostGistApiResponse> getResponseClass() {
        return PostGistApiResponse.class;
    }
}
