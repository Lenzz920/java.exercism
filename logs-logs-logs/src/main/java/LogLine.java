public class LogLine {

  private final String logLine;

  public LogLine(String logLine) {
    this.logLine = logLine;
  }

  public LogLevel getLogLevel() {
    return switch (LogLine.getLevel(logLine)) {
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
    return getLogLevel().getShortMessage() + ":" + getMessage(logLine);
  }

  private static String getLevel(String logLine) {
    int start = logLine.indexOf('[');
    int end = logLine.indexOf(']', start);
    if (start == -1 || end == -1) {
      return "";
    }
    return logLine.substring(start + 1, end);
  }

  private static String getMessage(String logLine) {
    char colon = ':';
    return logLine.substring(logLine.indexOf(colon) + 1).strip();
  }
}
