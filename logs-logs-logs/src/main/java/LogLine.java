public class LogLine {

    final private  String LOG_LINE;

    public LogLine(String logLine) {
        this.LOG_LINE = logLine;
    }

    public LogLevel getLogLevel() {
        return switch (LogLine.getLevel(LOG_LINE)) {
            case "TRC" -> LogLevel.TRACE;
            case "DBG" -> LogLevel.DEBUG;
            case "INF" -> LogLevel.INFO;
            case "WRN" -> LogLevel.WARNING;
            case "ERR" -> LogLevel.ERROR;
            case "FTL" -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };
    }

    public String getOutputForShortLog() {
        return "not implemented";
    }

    private static String getLevel(String logLine) {
        int start = logLine.indexOf('[') + 1;
        int end = logLine.indexOf(']', start);
        return logLine.substring(start, end);
    }

    private String getMessage(String logLine) {
        char column = ':';
        return logLine.substring(logLine.indexOf(column) - 1).strip();
    }
}
