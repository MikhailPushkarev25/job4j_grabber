package lsp;

import java.util.ArrayList;
import java.util.List;

public class CargoCar implements CargoParking {

    private List<Auto> list = new ArrayList<>();
    private int size = 1;

    @Override
    public boolean numberSeats(int num) {
        boolean rsl = false;
        if (num > 0) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public void forCargo(Auto auto, int place) {
        if (place >= size) {
            list.add(auto);
        }
    }
}
