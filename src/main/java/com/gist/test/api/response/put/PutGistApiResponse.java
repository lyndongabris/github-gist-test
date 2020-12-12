package com.gist.test.api.response.put;

import com.gist.test.api.data.responsedata.GistResponseData;
import com.gist.test.api.endpoint.ApiEndpoint;
import com.gist.test.api.response.AbstractApiResponse;
import com.gist.test.api.response.ApiResponse;
import com.gist.test.api.response.raw.RawApiResponse;

public class PutGistApiResponse extends AbstractApiResponse<GistResponseData> {
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
