package srp.parking;

public class Track implements ParkingCar {
    private final int size;

    public Track(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }
}