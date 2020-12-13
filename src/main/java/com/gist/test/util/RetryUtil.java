package com.gist.test.util;

import com.gist.test.exception.GistTestRuntimeException;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class RetryUtil {

    public static <O> O retryAction(Supplier<O> action, Predicate<O> validator, long timeout, ChronoUnit timeUnit, String failMessage, boolean throwException) {
        long expiration = System.currentTimeMillis() + Duration.of(timeout, timeUnit).toMillis();
        boolean isSuccessful;
        O output;
        do {
            output = action.get();
            isSuccessful = validator.test(output);
        } while (!isSuccessful && System.currentTimeMillis() < expiration);

        if (!isSuccessful && throwException) {
            throw new GistTestRuntimeException(failMessage);
        }

        return output;
    }
}
