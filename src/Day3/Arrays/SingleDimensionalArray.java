package Day3.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleDimensionalArray {

    public static int Largest(int[] arr){
        int largerValue = arr[0];
        return Arrays.stream(arr).reduce((a, b) -> a > b ? a : b).orElseThrow(() -> new IllegalArgumentException("Array is empty"));
    }

    public static int Smallest(int[] arr){
        return Arrays.stream(arr).min().orElseThrow(() -> new IllegalArgumentException("Array is Empty"));
    }

    public static int Sum(int[] arr){
        return Arrays.stream(arr).sum();
    }
}
