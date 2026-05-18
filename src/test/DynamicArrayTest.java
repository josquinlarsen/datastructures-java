package src.test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import src.arrays.DynamicArray;
import src.arrays.DynamicArrayException;
import src.arrays.StaticArray;
import src.arrays.StaticArrayException;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {
    
    private DynamicArray<Integer> arr;

    @BeforeEach
    void setUp() {
        try {
            arr = new DynamicArray<>();
        } catch (StaticArrayException e) {
            System.out.println("error");
        }
    }

    @Test
    void appendTest01() throws DynamicArrayException{
        int cap = arr.capacity();
        for (int i = 0; i < cap; i++) {
            arr.append(i);
        }
        assertEquals(arr.capacity(), 4);
        assertEquals(arr.get(0), 0);
    }

    @Test
    void appendTest02() {
        int cap = arr.capacity();
        for (int i = 0; i < cap + 1; i++) {
            arr.append(i);
        }
        int newCap = arr.capacity();
        assertEquals(cap, 4);
        assertNotEquals(cap, newCap);
        assertEquals(newCap, 8);
    }

    @Test
    void removeTest01() {
        DynamicArrayException exception =
            assertThrows(DynamicArrayException.class, () -> { 
            arr.remove(4);
        });
        assertEquals("Array is empty", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 5, 15, 1009029})
    void removeTest02(int invalidIndex) {
        for (int i = 0; i < arr.capacity(); i++) {
            arr.append(i);
        }
        DynamicArrayException exception =
            assertThrows(DynamicArrayException.class, () -> { 
            arr.remove(invalidIndex);
        });
        assertEquals("Invalid index", exception.getMessage());
    }

    @Test
    void removeTest03() throws DynamicArrayException{
        for (int i = 0; i < 17; i++) {
            arr.append(i + i);
        }

        while (!arr.isEmpty()) {
            arr.remove(0);
        }

        assertTrue(arr.isEmpty());
        assertEquals(arr.capacity(), 10);
        
    }

}
