package src.test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.arrays.StaticArray;
import src.arrays.StaticArrayException;

import static org.junit.jupiter.api.Assertions.*;

public class StaticArrayTest {
    
    private StaticArray<Integer> arr;

    @BeforeEach
    void setUp() {
        try {
            arr = new StaticArray<>(5); 
        } catch (StaticArrayException e) {
            System.out.println("error");
        }
    }

    @Test
    void setTest01() throws StaticArrayException {
        arr.set(0, 17);
        assertEquals(17, arr.get(0));
    }
    
    @Test
    void setTest02() throws StaticArrayException {
        arr.set(0, 17);
        int size = arr.length();
        assertEquals(size, 1);
    }

    @Test
    void setTest03() throws StaticArrayException {
        // size should not increase if space not null (i.e. replacement)
        arr.set(0, 17);
        int oldValue = arr.get(0);
        int oldSize = arr.length();

        arr.set(0, 24);
        int newValue = arr.get(0);
        int newSize = arr.length();
        assertEquals(newSize, 1);
        assertEquals(oldSize, newSize);
        assertNotEquals(oldValue, newValue);
    }
}
