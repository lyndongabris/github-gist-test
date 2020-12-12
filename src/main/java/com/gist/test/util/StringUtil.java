package com.gist.test.util;

import org.slf4j.helpers.MessageFormatter;

public class StringUtil {
    public static String format(String string, Object... replacements) {
        return MessageFormatter.arrayFormat(string, replacements).getMessage();
    }
}
