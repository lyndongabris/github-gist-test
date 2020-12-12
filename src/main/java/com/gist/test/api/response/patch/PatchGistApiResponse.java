package com.gist.test.api.response.patch;

import com.gist.test.api.data.responsedata.GistResponseData;
import com.gist.test.api.endpoint.ApiEndpoint;
import com.gist.test.api.response.AbstractApiResponse;
import com.gist.test.api.response.ApiResponse;
import com.gist.test.api.response.raw.RawApiResponse;

public class PatchGistApiResponse extends AbstractApiResponse<GistResponseData> {
    public PatchGistApiResponse(ApiEndpoint endpoint, RawApiResponse response) {
        super(endpoint, response);
    }

    public PatchGistApiResponse(ApiResponse response) {
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
