package Day13;

import Junit.PrimeChecker;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class PrimeCheckerTest {
    public static PrimeChecker obj = null;

    @BeforeClass
    public static void setupClass(){
        obj = new PrimeChecker();
        System.out.println("Prime checker testing : ");
    }

    @Test
    public void primeTest(){
        try(
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Arun P\\OneDrive\\Documents\\Testcases\\PrimeCases.txt"))
        ){
            String Line = null;

            while((Line = reader.readLine()) != null){
                String[] testcase = Line.split("->");

                if(testcase[1].equals("true")){
                    Assert.assertTrue(obj.isPrime(Long.parseLong(testcase[0])));
                }
                else{
                    Assert.assertFalse(obj.isPrime(Long.parseLong(testcase[0])));
                }
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
