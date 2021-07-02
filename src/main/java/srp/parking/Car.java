package srp.parking;

public class Car implements ParkingCar {

    private final int size = 1;

    @Override
    public int size() {
        return size;
    }
}
