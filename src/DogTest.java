import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {
    Dog dog;

    @BeforeEach
    void prepareData() {
        dog = new Dog("Tom", 5);
    }

    @Test
    void getName() {

        assertEquals("Tom", dog.getName());

    }

    @Test
    void setName() {
        Dog dog = new Dog("Albert", 2);
        dog.setName("Roman");
        assertEquals("Albert", dog.getName());
    }

    @Test
    void setNameNull() {
        Dog dog = new Dog("", 2);
        dog.setName("Roman");
        assertEquals("Roman", dog.getName());
    }

    @Test
    void getAge() {
        Dog dog = new Dog("Tom", 2);
        assertEquals(2, dog.getAge());
    }

    @Test
    void setAge() {
        Dog dog = new Dog("Tom", 2);
        dog.setAge(5);
        assertEquals(5, dog.getAge());
    }
}