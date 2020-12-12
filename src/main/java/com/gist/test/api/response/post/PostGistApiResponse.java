package com.gist.test.api.response.post;

import com.gist.test.api.data.responsedata.GistResponseData;
import com.gist.test.api.endpoint.ApiEndpoint;
import com.gist.test.api.response.AbstractApiResponse;
import com.gist.test.api.response.ApiResponse;
import com.gist.test.api.response.raw.RawApiResponse;

public class PostGistApiResponse extends AbstractApiResponse<GistResponseData> {
    public PostGistApiResponse(ApiEndpoint endpoint, RawApiResponse response) {
        super(endpoint, response);
    }

    public PostGistApiResponse(ApiResponse response) {
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
