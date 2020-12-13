appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{dd/MM HH:mm:ss.SSS, UTC} %-5level [%thread] %logger{6}: %message%n"
    }
}

appender("TESTLOG", FileAppender) {
    file = "build/testlog.txt"
    append = true
    encoder(PatternLayoutEncoder) {
        pattern = "%d{dd/MM HH:mm:ss.SSS, UTC} %-5level [%thread] %logger{6}: %message%n"
    }
}

logger("com.gist.test", INFO)

root(INFO, ["STDOUT", "FILE"])