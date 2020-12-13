package com.gist.test.api.data.requestdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gist.test.api.data.GistData;
import com.gist.test.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GistWriteData implements GistData {
    private static final Logger LOG = LoggerFactory.getLogger(GistWriteData.class);
    private String description;
    private boolean isPublic;
    private Map<String, GistFileContent> files;

    public GistWriteData(String description, boolean isPublic, Map<String, GistFileContent> files) {
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

        public Builder withFile(File file) {
            String fileContents = FileUtil.fileToString(file);
            String fileName = file.getName();
            files.put(fileName, new GistFileContent(fileContents));
            return this;
        }

        public Builder withFile(String fileName, String content) {
            if (content == null) {
                files.put(fileName, null);
            } else {
                files.put(fileName, new GistFileContent(content));
            }
            return this;
        }

        public GistWriteData build() {
            return new GistWriteData(description, isPublic, files);
        }
    }
}
