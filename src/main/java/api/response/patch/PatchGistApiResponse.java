package api.response.patch;

import api.data.response.GistResponseData;
import api.endpoint.ApiEndpoint;
import api.response.AbstractApiResponse;
import api.response.ApiResponse;
import api.response.raw.RawApiResponse;

public class PatchGistApiResponse extends AbstractApiResponse {
    protected PatchGistApiResponse(ApiEndpoint endpoint, RawApiResponse response) {
        super(endpoint, response);
    }

    protected PatchGistApiResponse(ApiResponse response) {
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
