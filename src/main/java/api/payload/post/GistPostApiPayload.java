package api.payload.post;

import api.data.request.GistWriteData;
import api.payload.JsonApiPayload;

public class GistPostApiPayload extends JsonApiPayload {
    protected GistPostApiPayload(GistWriteData data) {
        super(data);
    }
}