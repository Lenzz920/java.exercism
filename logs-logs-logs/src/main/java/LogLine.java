import java.nio.charset.StandardCharsets;

public class LogLine {

  private final String logLine;
  private final String level;
  private final String message;

  public LogLine(String logLine) {
    this.logLine = logLine;
    this.level = getLevel(logLine);
    this.message = getMessage(logLine);
  }

  public LogLevel getLogLevel() {
    return switch (level) {
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
    return getLogLevel().getEncodedLevel() + ":" + message;
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
    return logLine.substring(logLine.indexOf(':') + 1).strip();
  }
}
