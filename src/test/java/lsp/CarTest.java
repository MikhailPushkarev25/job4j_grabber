package lsp;

import org.junit.Test;
import srp.parking.CargoCar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CarTest {

    @Test
    public void whenTestCarPassenger() {
        Auto auto = new Auto("Volvo", 353);
        CargoCar cargoCar = new CargoCar();
        cargoCar.forCargo(auto, 0);
        assertThat(cargoCar.numberSeats(0), is(false));
    }
    @Test
    public void whenTestCargoCar() {
        Auto auto = new Auto("Kamaz", 353);
        CargoCar car = new CargoCar();
        car.forCargo(auto, 0);
        assertThat(car.numberSeats(0), is(false));
    }

    @Test
    public void whenTestCargoCarTrue() {
        Auto auto = new Auto("Maz", 465);
        CargoCar car = new CargoCar();
        car.forCargo(auto, 1);
        assertThat(car.numberSeats(1), is(true));
    }

    @Test
    public void whenTestCargoCar2True() {
        Auto auto = new Auto("Kraz", 269);
        CargoCar car = new CargoCar();
        car.forCargo(auto, 2);
        assertThat(car.numberSeats(2), is(true));
    }
}