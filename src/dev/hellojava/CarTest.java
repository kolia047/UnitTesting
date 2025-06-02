package dev.hellojava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.lang.reflect.Method;

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

    @Test
    public void testPrivateMethod() {
        try {
            Method method = Car.class.getDeclaredMethod("testMethod", null);
            method.setAccessible(true);
            assertEquals("abd", method.invoke(car).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPrivateMethodWithArgument() {
        try {
            Method method = Car.class.getDeclaredMethod("testMethod", String.class);
            method.setAccessible(true);
            assertEquals("abd", method.invoke(car, "abd").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @DisplayName("Test demonstrates how test data could be loaded from file")
    @CsvFileSource(resources = "/dev/hellojava/test-data.csv", delimiter = '|', numLinesToSkip = 1)
    public void testNumbers(String input, String expected) {
        car.setNumber(input);
        assertEquals(expected, car.getNumber());
    }

    @Test
    void getTestData() {
       Exception exception = assertThrows(Exception.class, () -> {
            car.getDataFromRemoteServer();
        });
        assertEquals("error!!!", exception.getMessage());
    }

}