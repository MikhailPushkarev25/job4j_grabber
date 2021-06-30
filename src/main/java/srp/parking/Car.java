package srp.parking;

import lsp.ParkingCar;

public class Car implements ParkingCar {
    private final int size;

    public Car(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }
}