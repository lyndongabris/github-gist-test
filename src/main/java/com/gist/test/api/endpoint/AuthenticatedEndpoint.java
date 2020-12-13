package com.gist.test.api.endpoint;

public interface AuthenticatedEndpoint {

    default void addAuthentication(ApiEndpoint endpoint, String token) {
        endpoint.addHeader("Authorization", "Bearer " + token);
    }
}
