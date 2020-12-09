package api.request;

import api.endpoint.ApiEndpoint;
import api.payload.ApiPayload;

public abstract class AbstractApiRequest implements ApiRequest {
    private ApiEndpoint endpoint;
    private ApiPayload payload;

    protected AbstractApiRequest(ApiEndpoint endpoint) {
        this.endpoint = endpoint;
        this.payload = endpoint.getPayload();
    }

    @Override
    public ApiPayload getPayload() {
        return payload;
    }
}
