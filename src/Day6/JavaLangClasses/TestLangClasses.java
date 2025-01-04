package Day6.JavaLangClasses;

public class TestLangClasses {
    public static void main(String[] args) {
        //Math class methods
        System.out.println(Math.pow(2, 10));
        System.out.println(Math.sqrt(100));

        //String class methods
        String name = "Arun";
        name += "Karthi";
        System.out.println(name.toUpperCase());
        System.out.println(name.substring(4));
        name.concat("k");

        //System class methods
        Solution solution = new Solution();
        int start = (int)System.currentTimeMillis();

        solution.waysToSplitArray(new int[]{1, 4, 7, 2, 9, 5, 0, 3, 2});

        int end = (int)System.currentTimeMillis();

        System.out.println("Executed Time: " + (end - start) + "ms");
    }
}
