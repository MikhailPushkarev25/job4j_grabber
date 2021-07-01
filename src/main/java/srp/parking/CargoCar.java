package srp.parking;

import java.util.ArrayList;
import java.util.List;

public class CargoCar implements CargoParking {
    private int cars = 0;
    private int cargo = 0;
    private final List<ParkingCar> list = new ArrayList<>();
    private final List<ParkingCar> list1 = new ArrayList<>();

    @Override
    public boolean park(ParkingCar car) {
        if (car.size() == 1) {
            if (cars > 0) {
                cars--;
                return list.add(car);
            }
        } else {
            if (cargo > 0) {
                cargo--;
                return list1.add(car);
            }
        }
        return false;
    }
}