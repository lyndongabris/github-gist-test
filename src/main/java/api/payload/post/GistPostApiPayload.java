package api.payload.post;

import api.data.GistData;
import api.payload.JsonApiPayload;

public class GistPostApiPayload extends JsonApiPayload {
    protected GistPostApiPayload(GistData data) {
        super(data);
    }
}
