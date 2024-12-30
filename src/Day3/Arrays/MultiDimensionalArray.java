package Day3.Arrays;

public class MultiDimensionalArray {

    public static int[][] add2DArray(int[][] arr1, int[][] arr2){
        if(arr1 == null || arr2 == null || arr1.length != arr2.length || arr1[0].length != arr2[0].length){
            throw new IllegalArgumentException("Illegal parameters!");
        }

        int m = arr1.length;
        int n = arr1[0].length;
        int[][] result = new int[m][n];

        for(int row = 0; row< m; row++){

            for(int col = 0; col < n; col++){
                result[row][col] = arr1[row][col] + arr2[row][col];
            }
        }

        return result;
    }

    public static int[][] transpose(int[][] arr){
        if(arr == null){
            throw new IllegalArgumentException("Array is null!");
        }

        int m = arr.length;
        int n = arr[0].length;

        int[][] transposedArray = new int[n][m];

        for(int col = 0; col < n; col++){

            for(int row = 0; row < m; row++){
                transposedArray[col][row] = arr[row][col];
            }
        }

        return transposedArray;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 1, 2, 3}, {3, 2, 1, 0}};
        int[][] transposedArray = transpose(arr);

        for(int i = 0; i < transposedArray.length; i++){

            for(int j = 0; j < transposedArray[0].length; j++){
                System.out.print(transposedArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
