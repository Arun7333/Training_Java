package Day5.Generics.GenericMethod;

public class TestGenericMethod {

    public static void main(String[] args) {
        Integer[] intArr = new Integer[]{1, 2, 3, 4, 5};
        Double[] doubleArr = new Double[]{1.2, 3.4, 5.6, 7.8};

        printArray(intArr);
        printArray(doubleArr);
    }

    public static <T> void printArray(T[] arr){
        for(T value : arr){
            System.out.println(value);
        }
    }
}
