package Day3.StaticVariablesAndMethods;

public class Counter {
    private static int count = 0;

    Counter(){
        count += 1;
    }

    public int getCount(){
        return count;
    }
}
