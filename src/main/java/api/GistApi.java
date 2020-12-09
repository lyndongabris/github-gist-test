package api;

import api.response.ApiResponse;

public interface GistApi {
    ApiResponse create();
    ApiResponse update();
    ApiResponse read();
    ApiResponse delete();
}
