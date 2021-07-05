package srp.parking;

public class CargoCar implements CargoParking {
    private int cars = 0;
    private int cargo = 0;
    private final ParkingCar[] carLight;
    private final ParkingCar[] cargoCar;

    public CargoCar(int cars, int cargo) {
        carLight = new ParkingCar[cars];
        cargoCar = new ParkingCar[cargo];
    }

    @Override
    public boolean park(ParkingCar car) {
        boolean rsl;
        if (car.size() == 1) {
          rsl = forLightCar(car);
        } else {
            rsl = forTrackCAr(car);
        }
        return rsl;
    }

    public boolean forLightCar(ParkingCar car) {
        boolean rsl = false;
        if (cars < carLight.length) {
            carLight[cars++] = car;
            rsl = true;
        }
        return rsl;
    }

    public boolean forTrackCAr(ParkingCar car) {
        boolean rsl = false;
        if (cargo < cargoCar.length) {
            cargoCar[cargo++] = car;
            rsl = true;
        } else {
            if (carLight.length - cars > car.size()) {
                while (cars <= car.size()) {
                    carLight[cars++] = car;
                }
                rsl = true;
            }
        }
        return rsl;
    }
}