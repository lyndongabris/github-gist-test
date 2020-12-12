package api.endpoint.get;

import java.time.OffsetDateTime;

public abstract class AbstractGistListApiEndpoint extends AbstractGistGetApiEndpoint {
    private static final String SINCE_HEADER = "since";

    protected void addSinceHeader(OffsetDateTime since) {
        addHeader(SINCE_HEADER, since.toString());
    }
}
