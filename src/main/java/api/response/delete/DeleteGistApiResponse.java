package api.response.delete;

import api.data.response.GistResponseData;
import api.endpoint.ApiEndpoint;
import api.response.AbstractApiResponse;
import api.response.ApiResponse;
import api.response.raw.RawApiResponse;

public class DeleteGistApiResponse extends AbstractApiResponse {
    protected DeleteGistApiResponse(ApiEndpoint endpoint, RawApiResponse response) {
        super(endpoint, response);
    }

    protected DeleteGistApiResponse(ApiResponse response) {
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
