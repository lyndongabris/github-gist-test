package com.gist.test.api.endpoint.get;

import java.time.OffsetDateTime;

public abstract class AbstractGistListApiEndpoint extends AbstractGistGetApiEndpoint {
    private static final String SINCE_HEADER = "since";

    protected void addSinceHeader(OffsetDateTime since) {
        addQueryParam(SINCE_HEADER, since.toString());
    }
}
