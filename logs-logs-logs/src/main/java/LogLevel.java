public enum LogLevel {
    UNKNOWN(0),
    TRACE(1),
    DEBUG(2),
    INFO(4),
    WARNING(5),
    ERROR(6),
    FATAL(42);

    final private int shortMessage;

    LogLevel(int shortMessage) {
        this.shortMessage = shortMessage;
    }

    public int getShortMessage() {
        return this.shortMessage;
    }
}
