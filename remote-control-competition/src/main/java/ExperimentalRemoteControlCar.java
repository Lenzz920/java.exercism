public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int distanceTravelled;
    private static final int DRIVE_DISTANCE = 20;

    @Override
    public void drive() {
        distanceTravelled += DRIVE_DISTANCE;
    }

    @Override
    public int getDistanceTravelled() {
        return distanceTravelled;
    }
}
