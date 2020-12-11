package api.data.response;

import api.data.GistData;
import api.data.response.deserializer.GistFileInfoDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = GistFileInfoDeserializer.class)
public class GistFileInfo implements GistData {
    private String filename;
    private String type;
    private String language;
    private String rawUrl;
    private int size;
    private Boolean truncated;
    private String content;

    public GistFileInfo(String filename,
                        @JsonProperty("type") String type,
                        @JsonProperty("language") String language,
                        @JsonProperty("raw_url") String rawUrl,
                        @JsonProperty("size") int size,
                        @JsonProperty("truncated") Boolean truncated,
                        @JsonProperty("content") String content) {
        this.filename = filename;
        this.type = type;
        this.language = language;
        this.rawUrl = rawUrl;
        this.size = size;
        this.truncated = truncated;
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    public String getType() {
        return type;
    }

    public String getLanguage() {
        return language;
    }

    public String getRawUrl() {
        return rawUrl;
    }

    public int getSize() {
        return size;
    }
}
