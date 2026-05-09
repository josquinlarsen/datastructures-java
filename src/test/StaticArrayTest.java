package test;
import arrays.StaticArray;
import arrays.StaticArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    void getTest01() throws StaticArrayException {
        arr.set(0, 17);
        assertEquals(17, arr.get(0));
    }
}
