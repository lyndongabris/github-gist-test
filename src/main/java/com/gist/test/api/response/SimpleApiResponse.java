package com.gist.test.api.response;

import com.gist.test.api.data.responsedata.GistResponseData;
import com.gist.test.api.endpoint.ApiEndpoint;
import com.gist.test.api.response.raw.RawApiResponse;

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
