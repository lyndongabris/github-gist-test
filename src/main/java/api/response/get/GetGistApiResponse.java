package api.response.get;

import api.data.response.GistResponseData;
import api.endpoint.ApiEndpoint;
import api.response.AbstractApiResponse;
import api.response.ApiResponse;
import api.response.raw.RawApiResponse;

public class GetGistApiResponse extends AbstractApiResponse {
    public GetGistApiResponse(ApiEndpoint endpoint, RawApiResponse response) {
        super(endpoint, response);
    }

    public GetGistApiResponse(ApiResponse response) {
        super(response);
    }

    @Override
    public int getSuccessCode() {
        return 200;
    }


    @Override
    public Class<GistResponseData> getDataObjectClass() {
        return GistResponseData.class;
    }
}
