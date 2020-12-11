package util;

import exception.GistTestRuntimeException;

public class GistFileException extends GistTestRuntimeException {
    public GistFileException(String message) {
        super(message);
    }

    public GistFileException(Throwable e) {
        super(e);
    }

    public GistFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public GistFileException(String message, Object... replacements) {
        super(message, replacements);
    }
}
