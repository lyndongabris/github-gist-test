package api.response;

import api.data.response.GistResponseData;
import api.endpoint.ApiEndpoint;
import api.response.raw.RawApiResponse;

public class SimpleApiResponse extends AbstractApiResponse<GistResponseData> {
    public SimpleApiResponse(ApiEndpoint endpoint, RawApiResponse response) {
        super(endpoint, response);
    }

    public SimpleApiResponse(ApiResponse response) {
        super(response);
    }

    @Override
    public Class<GistResponseData> getDataObjectClass() {
        return GistResponseData.class;
    }

    @Override
    public int getSuccessCode() {
        return 200;
    }
}
