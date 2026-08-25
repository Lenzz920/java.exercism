public class Lasagna {

    private static final int EXPECTED_MINUTES_IN_OVEN = 40;
    private static final int PREPARATION_MINUTES_PER_LAYER = 2;
    
    public int expectedMinutesInOven() {
        return EXPECTED_MINUTES_IN_OVEN;
    }

    public int remainingMinutesInOven(int timeInOven) {
        return expectedMinutesInOven() - timeInOven;
    }

    public int preparationTimeInMinutes(int numberOfLayers) {
        return numberOfLayers * PREPARATION_MINUTES_PER_LAYER;
    }

    public int totalTimeInMinutes (int numberOfLayers, int timeInOven) {
        return preparationTimeInMinutes(numberOfLayers) + timeInOven;
    }
}
