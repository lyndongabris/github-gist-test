package api.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GistFileInfo {
    private String filename;
    private String type;
    private String language;
    private String rawUrl;
    private int size;

    public GistFileInfo(@JsonProperty("filename") String filename,
                        @JsonProperty("type") String type,
                        @JsonProperty("language") String language,
                        @JsonProperty("raw_url") String rawUrl,
                        @JsonProperty("size") int size) {
        this.filename = filename;
        this.type = type;
        this.language = language;
        this.rawUrl = rawUrl;
        this.size = size;
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
