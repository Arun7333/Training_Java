package Day13;

import Junit.Palindrome;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class PalindromeTest {
    public static Palindrome obj = null;

    @BeforeClass
    public static void setupClass(){
        obj = new Palindrome();
        System.out.println("Palindrome testing : ");
    }

    @Test
    public void palindromeTest(){
        try(
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Arun P\\OneDrive\\Documents\\Testcases\\PalindromeCases.txt"))
        ){
            String Line = null;

            while((Line = reader.readLine()) != null){
                String[] testcase = Line.split("->");

                if(testcase[1].equals("true")){
                    Assert.assertEquals(true, obj.check(testcase[0]));
                }
                else{
                    Assert.assertEquals(false, obj.check(testcase[0]));
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
