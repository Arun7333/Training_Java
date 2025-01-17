package Day13;

import Junit.StringReverse;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class StringReverseTest {
    public static StringReverse obj = null;

    @BeforeClass
    public static void setupClass(){
        obj = new StringReverse();
        System.out.println("String reverse testing : ");
    }

    @Test
    public void reverseTest(){
        try(
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Arun P\\OneDrive\\Documents\\Testcases\\StringReverseCases.txt"))
        ){
            String Line = null;

            while((Line = reader.readLine()) != null){
                String[] testcase = Line.split("->");

                Assert.assertEquals(testcase[1], obj.reverse(testcase[0]));
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
