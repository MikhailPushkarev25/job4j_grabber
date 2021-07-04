package srp.parking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CargoCarTest {

    @Test
    public void whenTestLightCar() {
        CargoCar car = new CargoCar(3, 3);
        ParkingCar car1 = new Car();
        assertThat(car.park(car1), is(true));
    }

    @Test
    public void whenTestTrackCar() {
        CargoCar car = new CargoCar(1, 1);
        ParkingCar car1 = new Track(0);
        assertThat(car.park(car1), is(true));

    }
}