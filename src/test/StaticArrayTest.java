package src.test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 5, 15, 1009029})
    void setTest04(int invalidIndex) throws StaticArrayException {
        StaticArrayException exception =
            assertThrows(StaticArrayException.class, () -> { 
            arr.set(invalidIndex, 17);
        });
        assertEquals("Index out of bounds", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 5, 15, 1009029})
    void getTest01(int invalidIndex) throws StaticArrayException {
        for (int i = 0; i < arr.capacity(); i++) {
            arr.set(0, 23);
        }

        StaticArrayException exception =
            assertThrows(StaticArrayException.class, () -> { 
            arr.get(invalidIndex);
        });
        assertEquals("Index out of bounds", exception.getMessage());
    }

    @Test
    void getTest02() throws StaticArrayException{
        int cap = arr.capacity();
        int i = 0;
        while (i < cap) {
            arr.set(i, 17 - i);
            i += 2;
        }

        assertEquals(arr.get(0), 17);
        assertEquals(arr.get(1), null);
        assertEquals(arr.get(cap - 2), null);
        assertEquals(arr.get(cap - 1), 13);
    }

    @Test
    void appendTest01() throws StaticArrayException {
        for (int i = 0; i < arr.capacity(); i++) {
            arr.append(17 - i);
        }
        
        assertEquals(arr.length(), arr.capacity());
        assertEquals(arr.get(0), 17);
        assertEquals(arr.get(arr.length() - 1), 13);
    }

    @Test
    void appendTest02() throws StaticArrayException {
        for (int i = 0; i < arr.capacity(); i++) {
            arr.append(17 - i);
        }
        
        StaticArrayException exception =
            assertThrows(StaticArrayException.class, () -> { 
            arr.append(1009029);
        });
        assertEquals("Array is at max capacity", exception.getMessage());
    }

    @Test
    
    void popTest01() throws StaticArrayException {
        int cap = arr.capacity();
        for (int i = 0; i < cap; i++) {
            arr.append(17 - i);
        }

        StaticArray<Integer> newArr = new StaticArray<>(cap);

        while (arr.length() > 0) {
            newArr.append(arr.pop());
        }

        assertTrue(arr.isEmpty());

        for (int i = 0; i < cap; i++) {
            assertEquals(newArr.get(i), 13 + i);
        }
    }

    void popTest02() throws StaticArrayException {
        StaticArrayException exception =
            assertThrows(StaticArrayException.class, () -> { 
            arr.pop();
        });
        assertEquals("Array is empty", exception.getMessage());
    }
}