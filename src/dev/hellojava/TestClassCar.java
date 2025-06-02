package dev.hellojava;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClassCar {

    @Test
    //@EnabledOnOs(OS.WINDOWS)
    //@DisabledOnOs(OS.LINUX)
    //@EnabledOnJre(JRE.JAVA_11)
    //@DisabledOnJre(JRE.JAVA_10)
    public void getCarYear(){
        Car car = new Car("FJFJJF", "DBC-548", 2020, "I am");
        assertEquals(2020, car.getYear());
    }

}
