import static org.junit.Assert.*;

import org.junit.Test;

public class TestFilk {

    @Test
    public void testFlik() {
        assertTrue(Flik.isSameNumber(2, 2));
        assertFalse(Flik.isSameNumber(2, 3));
        assertTrue(Flik.isSameNumber(127, 127));
        assertTrue(Flik.isSameNumber(128, 128));
        System.out.println(Flik.isSameNumber(128, 128));
        //assertTrue(Flik.isSameNumber(500,500));


    }
}
