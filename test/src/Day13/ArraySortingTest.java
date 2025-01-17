package Day13;

import Junit.Sorting;
import Junit.StringReverse;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ArraySortingTest {
    public static Sorting obj = null;

    @BeforeClass
    public static void setupClass(){
        obj = new Sorting();
        System.out.println("Array sorting testing : ");
    }

    @Test
    public void arraySortTest(){
        try(
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Arun P\\OneDrive\\Documents\\Testcases\\SortingCases.txt"))
        ){
            String Line = null;

            while((Line = reader.readLine()) != null){
                Line = Line.trim();
                String testcase[] = Line.split(",");
                int[] arr = new int[testcase.length];

                for(int i = 0; i < testcase.length; i++){
                    arr[i] = Integer.parseInt(testcase[i]);
                }
                Arrays.sort(arr);

                Assert.assertEquals(arr, obj.sortArray(arr));
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
