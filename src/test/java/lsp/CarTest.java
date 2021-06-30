package lsp;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CarTest {

    @Test
    public void whenTestCarPassenger() {
        Auto auto = new Auto("Volvo", 353);
        Car car = new Car();
        car.forCars(auto, 0);
        assertThat(car.numberSeats(0), is(false));
    }

    @Test
    public void whenTestCarPassengerTrue() {
        Auto auto = new Auto("Mitsubishi", 890);
        Car car = new Car();
        car.forCars(auto, 1);
        assertThat(car.numberSeats(1), is(true));
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