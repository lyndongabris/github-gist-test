package api.response.put;

import api.data.response.GistResponseData;
import api.endpoint.ApiEndpoint;
import api.response.AbstractApiResponse;
import api.response.ApiResponse;
import api.response.raw.RawApiResponse;

public class PutGistApiResponse extends AbstractApiResponse {
    protected PutGistApiResponse(ApiEndpoint endpoint, RawApiResponse response) {
        super(endpoint, response);
    }

    protected PutGistApiResponse(ApiResponse response) {
        super(response);
    }

    @Override
    public int getSuccessCode() {
        return 204;
    }


    @Override
    public Class<GistResponseData> getDataObjectClass() {
        return GistResponseData.class;
    }
}
