package com.gist.test.api;

import com.gist.test.api.response.ApiResponse;

public interface GistApi {
    ApiResponse create();
    ApiResponse update();
    ApiResponse read();
    ApiResponse delete();
}
