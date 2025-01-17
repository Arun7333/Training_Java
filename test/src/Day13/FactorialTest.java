package Day13;

import Junit.Factorial;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class FactorialTest {
    public static Factorial obj = null;

    @BeforeClass
    public static void setupClass(){
        obj = new Factorial();
        System.out.println("Factorial testing : ");
    }

    @Test
    public void factorialTest(){
        try(
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Arun P\\OneDrive\\Documents\\Testcases\\FactorialCases.txt"))
        ){
            String Line = null;

            while((Line = reader.readLine()) != null){
                String[] testcase = Line.split("->");
                Assert.assertEquals(Integer.parseInt(testcase[1]), obj.getFactorial(Integer.parseInt(testcase[0])));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass(){
        System.out.println();
    }
}
