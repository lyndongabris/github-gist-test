package exception;

import org.slf4j.helpers.MessageFormatter;

public class GistTestRuntimeException extends RuntimeException {
    public GistTestRuntimeException(String message) {
        super(message);
    }

    public GistTestRuntimeException(Throwable e) {
        super(e);
    }

    public GistTestRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public GistTestRuntimeException(String message, Object... replacements) {
        super(MessageFormatter.arrayFormat(message, replacements).getMessage());
    }
}
