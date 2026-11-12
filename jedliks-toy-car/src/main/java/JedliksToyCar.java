public class JedliksToyCar {

  private int distanceInMeters;
  private int batteryPercentage = 100;
  private static final int METERS_PER_DRIVE = 20;
  private static final int BATTERY_DRAIN_PER_DRIVE = 1;

  public static JedliksToyCar buy() {
    return new JedliksToyCar();
  }

  public String distanceDisplay() {
    return String.format("Driven %d meters", distanceInMeters);
  }

  public String batteryDisplay() {
    return batteryIsNotEmpty() ? "Battery at " + batteryPercentage + "%" : "Battery empty";
  }

  public void drive() {
    if (batteryIsNotEmpty()) {
      distanceInMeters += METERS_PER_DRIVE;
      batteryPercentage -= BATTERY_DRAIN_PER_DRIVE;
    }
  }

  public boolean batteryIsNotEmpty() {
    return batteryPercentage >= BATTERY_DRAIN_PER_DRIVE;
  }
}
