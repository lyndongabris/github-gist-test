package com.gist.test.exception;

import com.gist.test.util.StringUtil;

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
        super(StringUtil.format(message, replacements));
    }
}
