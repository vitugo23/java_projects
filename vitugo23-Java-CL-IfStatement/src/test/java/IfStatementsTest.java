
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class IfStatementsTest {

    static IfStatements is;

    @BeforeClass
    public static void setUp() {
        is = new IfStatements();
    }

    
    /**
     * Tests the exercise1() method of the IfStatements class.
     * 
     * This test verifies that, if exercise1() receives a boolean value of `true`, it returns the value of the `x` parameter, which is 0.
     */
    @Test
    public void Exercise1Test1(){
        boolean bool = true;
        int x = 0;
        int y = 1;
        int expected = 0;
        int actual = is.exercise1(bool, x, y);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Tests the exercise1() method of the IfStatements class.
     * 
     * This test verifies that, if exercise1() receives a boolean value of `false`, it returns the value of the `y` parameter, which is 1.
     */
    @Test
    public void Exercise1Test2(){
        boolean bool = false;
        int x = 0;
        int y = 1;
        int expected = 1;
        int actual = is.exercise1(bool, x, y);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Tests the exercise2() method of the IfStatements class.
     * 
     * This test verifies that, if exercise2() receives an integer value of 5, it returns "Positive".
     */
    @Test
    public void Exercise2Test1(){
        int x = 5;
        String expected = "Positive";
        String actual = is.exercise2(x);
        Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase().trim());
    }

    /**
     * Tests the exercise2() method of the IfStatements class.
     * 
     * This test verifies that, if exercise2() receives an integer value of -10, it returns "Negative".
     */
    @Test
    public void Exercise2Test2(){
        int x = -10;
        String expected = "Negative";
        String actual = is.exercise2(x);
        Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase().trim());
    }

    /**
     * Tests the exercise2() method of the IfStatements class.
     * 
     * This test verifies that, if exercise2() receives an integer value of 0, it returns "Zero".
     */
    @Test
    public void Exercise2Test3(){
        int x = 0;
        String expected = "Zero";
        String actual = is.exercise2(x);
        Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase().trim());
    }

    /**
     * Tests the exercise3() method of the IfStatements class.
     * 
     * This test verifies that, if exercise3() receives an integer value of 2025, which is not divisible by 4, it returns "No".
     */
    @Test
    public void Exercise3Test1(){
        int year = 2025;
        String expected = "No";
        String actual = is.exercise3(year);
        Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase().trim());
    }

    /**
     * Tests the exercise3() method of the IfStatements class.
     * 
     * This test verifies that, if exercise3() receives an integer value of 2000, because it is divisible by both 100 and 400, it returns "Yes".
     */
    @Test
    public void Exercise3Test2(){
        int year = 2000;
        String expected = "Yes";
        String actual = is.exercise3(year);
        Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase().trim());
    }

    /**
     * Tests the exercise3() method of the IfStatements class.
     * 
     * This test verifies that, if exercise3() receives an integer value of 1900, because it is divisible by 100 but NOT 400, it returns "Not quite".
     */
    @Test
    public void Exercise3Test3(){
        int year = 1900;
        String expected = "Not quite";
        String actual = is.exercise3(year);
        Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase().trim());
    }

    /**
     * Tests the exercise3() method of the IfStatements class.
     * 
     * This test verifies that, if exercise3() receives an integer value of 2024, because it is divisible by 4, it returns "Yes".
     */
    @Test
    public void Exercise3Test4(){
        int year = 2024;
        String expected = "Yes";
        String actual = is.exercise3(year);
        Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase().trim());
    }
}
