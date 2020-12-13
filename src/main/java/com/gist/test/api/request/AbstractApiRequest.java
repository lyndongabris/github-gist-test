package com.gist.test.api.request;

import com.gist.test.api.endpoint.ApiEndpoint;
import com.gist.test.api.payload.ApiPayload;

public abstract class AbstractApiRequest implements ApiRequest {
    private ApiEndpoint endpoint;
    private ApiPayload payload;

    protected AbstractApiRequest(ApiEndpoint endpoint) {
        this.endpoint = endpoint;
        this.payload = endpoint.getPayload();
    }

    protected abstract void setBodyFromPayload();

    protected ApiEndpoint getEndpoint() {
        return endpoint;
    }

    @Override
    public ApiPayload getPayload() {
        return payload;
    }
}
