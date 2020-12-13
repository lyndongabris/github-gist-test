package com.gist.test.api.response.get;

import com.gist.test.api.data.responsedata.GistResponseData;
import com.gist.test.api.endpoint.ApiEndpoint;
import com.gist.test.api.response.AbstractApiResponse;
import com.gist.test.api.response.ApiResponse;
import com.gist.test.api.response.raw.RawApiResponse;

public class GetGistApiResponse extends AbstractApiResponse<GistResponseData> {
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
