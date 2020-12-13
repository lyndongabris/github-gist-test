package com.gist.test.api.data.responsedata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gist.test.api.data.GistData;
import com.gist.test.api.data.responsedata.deserializer.GistFileInfoDeserializer;

import java.util.Objects;

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

    public Boolean getTruncated() {
        return truncated;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GistFileInfo that = (GistFileInfo) o;
        return size == that.size &&
                Objects.equals(filename, that.filename) &&
                Objects.equals(type, that.type) &&
                Objects.equals(language, that.language) &&
                Objects.equals(rawUrl, that.rawUrl) &&
                Objects.equals(truncated, that.truncated) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, type, language, rawUrl, size, truncated, content);
    }
}
