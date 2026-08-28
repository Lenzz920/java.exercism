
class BirdWatcher {
    private final int[] birdsPerDay;
    private final int BUSY_DAY_THRESHOLD = 5;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public static int[] getLastWeek() {
        return new int[] {0, 2, 5, 3, 7, 8, 4};
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length-1];
    }

    public void incrementTodaysCount() {
       birdsPerDay[birdsPerDay.length-1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int numberOfBirds : birdsPerDay) {
            if (numberOfBirds == 0) return true;
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int numberOfBirds = 0;

        for (int dayNumber = 0; dayNumber < numberOfDays; dayNumber++) {
            if (dayNumber > birdsPerDay.length-1) break;
            numberOfBirds += birdsPerDay[dayNumber];
        }

        return numberOfBirds;
    }

    public int getBusyDays() {
        int busyDays = 0;

        for (int numberOfBirds : birdsPerDay){
            if (numberOfBirds >= BUSY_DAY_THRESHOLD) busyDays++;
        }

        return busyDays;
    }
}
