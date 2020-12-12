package api.response.post;

import api.data.response.GistResponseData;
import api.endpoint.ApiEndpoint;
import api.response.AbstractApiResponse;
import api.response.ApiResponse;
import api.response.raw.RawApiResponse;

public class PostGistApiResponse extends AbstractApiResponse {
    protected PostGistApiResponse(ApiEndpoint endpoint, RawApiResponse response) {
        super(endpoint, response);
    }

    protected PostGistApiResponse(ApiResponse response) {
        super(response);
    }

    @Override
    public int getSuccessCode() {
        return 201;
    }


    @Override
    public Class<GistResponseData> getDataObjectClass() {
        return GistResponseData.class;
    }
}
