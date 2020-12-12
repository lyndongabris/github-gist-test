package com.gist.test.api.response.delete;

import com.gist.test.api.data.responsedata.GistResponseData;
import com.gist.test.api.endpoint.ApiEndpoint;
import com.gist.test.api.response.AbstractApiResponse;
import com.gist.test.api.response.ApiResponse;
import com.gist.test.api.response.raw.RawApiResponse;

public class DeleteGistApiResponse extends AbstractApiResponse<GistResponseData> {
    public DeleteGistApiResponse(ApiEndpoint endpoint, RawApiResponse response) {
        super(endpoint, response);
    }

    public DeleteGistApiResponse(ApiResponse response) {
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
