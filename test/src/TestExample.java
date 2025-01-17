import Day1.ArithmeticOperations;
import Day6.String.Test1;
import org.junit.Assert;
import org.junit.Test;

public class TestExample {
    @Test
    public void testReverseString(){
        int result = ArithmeticOperations.Operate(12, 8, '+');
        Assert.assertEquals(20, result);
        String str = Test1.reverseString("Arun");
        Assert.assertEquals("nurA", str);
    }
}
