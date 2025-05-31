import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    public void createCar(){
        car = new Car("Skoda", "ABC-1234", 2019, "Pervushin Nikolay");
    }

    @Test
    void getManufacturer() {
        assertEquals("Skoda", car.getManufacturer());
    }

    @Test
    void getNumber() {
        assertEquals("ABC-1234", car.getNumber());
    }

    @Test
    void setNumber() {
        car.setNumber("AC-3214");
        assertEquals("AC-3214", car.getNumber());
    }

    @Test
    void getYear() {
        assertEquals(2019, car.getYear());
    }

    @Test
    void getOwner() {
        assertEquals("Pervushin Nikolay", car.getOwner());

    }

    @Test
    void setOwner() {
        car.setOwner("Peter Malashkin");
        assertEquals("Peter Malashkin", car.getOwner());
    }

    @Test
    void getListOfOwners(){
        assertArrayEquals(new String[]{"Pervushin Nikolay"}, car.getOwners().toArray());
    }

    @Test
    void getListOfTwoOwners(){
        car.setOwner("Peter Malashkin");
        assertArrayEquals(new String[]{"Pervushin Nikolay", "Peter Malashkin"}, car.getOwners().toArray());
    }
}