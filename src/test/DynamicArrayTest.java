package src.test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import src.arrays.DynamicArray;
import src.arrays.DynamicArrayException;
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
    void removeTest03() throws DynamicArrayException {
        for (int i = 0; i < 17; i++) {
            arr.append(i + i);
        }

        while (!arr.isEmpty()) {
            arr.remove(0);
        }

        assertTrue(arr.isEmpty());
        assertEquals(arr.capacity(), 10);
        
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 5, 15, 1009029})
    void insertTest01(int invalidIndex) throws DynamicArrayException {
        for (int i = 0; i < arr.capacity(); i++) {
            arr.append(i);
        }
        DynamicArrayException exception =
            assertThrows(DynamicArrayException.class, () -> { 
            arr.insert(17, invalidIndex);
        });
        assertEquals("Invalid index", exception.getMessage());
    }

    @Test
    void insertTest02() throws DynamicArrayException {
        for (int i = 0; i < arr.capacity(); i++) {
            arr.insert(17 - i, i);
        }

        assertEquals(arr.get(0), 17);
        assertEquals(arr.get(arr.capacity() - 1), 14);
        assertEquals(arr.capacity(), 4);
    }

    @Test
    void insertTest03() throws DynamicArrayException {
        int cap = arr.capacity();
        for (int i = 0; i < (cap * 2) + 1; i++) {
            arr.insert(17 - i, 0);
        }

        assertEquals(arr.capacity(), 16);
        assertEquals(arr.get(arr.length() - 1), 17);
        assertEquals(arr.get(0), 9);
    }

    @Test
    void insertTest4() throws DynamicArrayException {
        int cap = arr.capacity();
        for (int i = 0; i < (cap * 2) + 1; i++) {
            arr.insert(17 - i, 0);
        }

        int newSize = arr.length();
        for (int i = 0; i < newSize; i++) {
            assertEquals(arr.get(i), 9 + i);
            // assertEquals(arr.get(newSize - 1 - i, 17 - i))
        }
    }

    @Test
    void popTest01() throws DynamicArrayException {
        DynamicArrayException exception =
            assertThrows(DynamicArrayException.class, () -> { 
            arr.pop();
        });
        assertEquals("Array is empty", exception.getMessage());
    }

    @Test
    void popTest02() throws DynamicArrayException {
        for (int i = 0; i < 17; i++) {
            arr.append(i + i);
        }

        while (!arr.isEmpty()) {
            arr.pop();
        }

        assertTrue(arr.isEmpty());
        assertEquals(arr.capacity(), 10);
    }

}
