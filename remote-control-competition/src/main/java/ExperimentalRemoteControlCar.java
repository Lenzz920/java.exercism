public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int distanceTravelled;
    private static final int DRIVE_DISTANCE = 20;

    public void drive() {
        distanceTravelled += DRIVE_DISTANCE;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }
}
