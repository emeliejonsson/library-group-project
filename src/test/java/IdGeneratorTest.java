import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IdGeneratorTest {

    private static final int expected_Length = 10;
    private static final String num_Index = "\\d+";


    @Test
    public void  testGeneratedIdHasCorrectLength() {
        String id = IdGenerator.generateID();
        assertEquals(expected_Length, id.length(),"ID length must be" + expected_Length + ".");
    }

    @Test
    public void  testContainsNumbersOnly(){
        String id = IdGenerator.generateID();
        assertTrue(id.matches(num_Index),"ID must only contains digits ");
    }


    @Test
   public void testMultipleIdsAreUnique(){
        String id = IdGenerator.generateID();
        String id2 = IdGenerator.generateID();

        assertNotEquals(id, id2, "ID Generator Error");
    }


}
