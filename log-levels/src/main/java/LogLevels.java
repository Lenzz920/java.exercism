import java.util.Locale;

public class LogLevels {

  public static String message(String logLine) {
    return logLine.substring(logLine.indexOf(':') + 1).strip();
  }

  public static String logLevel(String logLine) {
    int start = logLine.indexOf('[') + 1;
    int end = logLine.indexOf(']', start);

    return logLine
        .substring(start, end)
        .toLowerCase(Locale.ROOT);
  }

  public static String reformat(String logLine) {
    return message(logLine) + " (" + logLevel(logLine) + ")";
  }
}
