public class JedliksToyCar {

  private int distanceInMeters;
  private int battery = 100;

  public static JedliksToyCar buy() {
    return new JedliksToyCar();
  }

  public String distanceDisplay() {
    return String.format("Driven %d meters", distanceInMeters);
  }

  public String batteryDisplay() {
    return battery > 0 ? String.format("Battery at %d%%", battery) : "Battery empty";
  }

  public void drive() {
    if (battery != 0) {
      distanceInMeters += 20;
      battery--;
    }
  }
}
