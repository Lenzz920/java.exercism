public class CarsAssemble {

  private static final int CARS_PRODUCED_PER_HOUR = 221;

  public double productionRatePerHour(int speed) {
    return CARS_PRODUCED_PER_HOUR * speed * successRate(speed);
  }

  public int workingItemsPerMinute(int speed) {
    return (int) productionRatePerHour(speed) / 60;
  }

  private double successRate(int speed) {
    if (speed < 0 || speed > 10) {
      throw new IllegalArgumentException("invalid speed: " + speed);
    }
    return (speed <= 4) ? 1.0
            : (speed <= 8) ? 0.9
            : (speed <= 9) ? 0.8
            : 0.77;
  }
}
