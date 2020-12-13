package com.gist.test.api.endpoint.patch;

import com.gist.test.api.endpoint.AbstractApiEndpoint;
import com.gist.test.api.endpoint.ApiMethod;
import com.gist.test.api.endpoint.AuthenticatedEndpoint;
import com.gist.test.api.response.patch.PatchGistApiResponse;

public abstract class AbstractPatchGistApiEndpoint extends AbstractApiEndpoint<PatchGistApiResponse> implements AuthenticatedEndpoint {
    @Override
    public ApiMethod getMethod() {
        return ApiMethod.PATCH;
    }

    @Override
    public Class<PatchGistApiResponse> getResponseClass() {
        return PatchGistApiResponse.class;
    }
}
