package com.gist.test.api.payload;

public abstract class AbstractApiPayload implements ApiPayload {
    @Override
    public String toString() {
        return getPayloadString();
    }
}
