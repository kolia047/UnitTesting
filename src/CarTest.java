import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    public void createCar() {
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

    @ParameterizedTest
    @ValueSource(strings = {"ABC-123", "DEF-456", "DFG-434"})
    @NullSource
    @EmptySource
    void testSetNumberMultipleValues(String number) {
        car.setNumber(number);
        assertEquals(number, car.getNumber());
    }

    @ParameterizedTest
    @CsvSource({"1, 5", "8, 12", "32, 36"})
    void testInt(int input, int output) {
        assertEquals(car.testInt(input), output);
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
    void getListOfOwners() {
        assertArrayEquals(new String[]{"Pervushin Nikolay"}, car.getOwners().toArray());
    }

    @Test
    void getListOfTwoOwners() {
        car.setOwner("Peter Malashkin");
        assertArrayEquals(new String[]{"Pervushin Nikolay", "Peter Malashkin"}, car.getOwners().toArray());
    }
}