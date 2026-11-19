public class Rebuilds {

    private double successRate(int speed) {
        return switch (speed) {
            case 1, 2, 3, 4 -> 1.0;
            case 5, 6, 7, 8 -> 0.9;
            case 9 -> 0.8;
            case 10 -> 0.77;
            default -> throw new IllegalArgumentException("Please enter a valid speed level between 1-10");
        };
    }

    private static String message(String log) {
        return log.substring(log.indexOf(":") + 1).trim();
    }


}
