package lsp;

import java.util.ArrayList;
import java.util.List;

public class Car implements ParkingCar {

    private List<Auto> list = new ArrayList<>();
    private int size = 1;

    @Override
    public boolean numberSeats(int num) {
        boolean rsl = true;
        if (num == 0) {
            rsl = false;
        }
        return rsl;
    }

    @Override
    public void forCars(Auto auto, int place) {
        if (place == size) {
            list.add(auto);
        } else {
            System.out.println("Парковка занята");
        }
    }
}
