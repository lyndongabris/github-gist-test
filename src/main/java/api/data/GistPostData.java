package api.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class GistPostData {
    private static final Logger LOG = LoggerFactory.getLogger(GistPostData.class);
    private String description;
    private boolean isPublic;
    private Map<String, GistFileContent> files;

    public GistPostData(String description, boolean isPublic, Map<String, GistFileContent> files) {
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
}
