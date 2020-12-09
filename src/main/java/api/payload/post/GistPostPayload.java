package api.payload.post;

import api.payload.JsonApiPayload;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class GistPostPayload extends JsonApiPayload {
    private static final Logger LOG = LoggerFactory.getLogger(GistPostPayload.class);
    private String description;
    private boolean isPublic;
    private Map<String, GistFileContent> files;

    public GistPostPayload(String description, boolean isPublic, Map<String, GistFileContent> files) {
        this.description = description;
        this.isPublic = isPublic;
        this.files = files;
    }

    @JsonProperty("public")
    public boolean getPublic() {
        return isPublic;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, GistFileContent> getFiles() {
        return files;
    }

    public static Builder builder(String description) {
        return new Builder(description);
    }


    public static class Builder {
        private String description;
        private boolean isPublic = true;
        private Map<String, GistFileContent> files;

        public Builder(String description) {
            this.description = description;
            files = new HashMap<>();
        }

        public Builder isPublic(boolean isPublic) {
            this.isPublic = isPublic;
            return this;
        }

        public Builder withFile(String fileName, String content) {
            files.put(fileName, new GistFileContent(content));
            return this;
        }

        public GistPostPayload build() {
            return new GistPostPayload(description, isPublic, files);
        }
    }
}
