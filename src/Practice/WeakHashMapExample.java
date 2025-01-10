package Practice;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class WeakHashMapExample {
    public static void main(String[] args) throws InterruptedException {
        WeakHashMap<String, List<Integer>> map = new WeakHashMap<>();
        WeakReference<WeakHashMap<String, List<Integer>>> ref = new WeakReference<>(map);

        String key1 = new String("Arun");
        String key2 = "Karthi";

        map.put(key1, new ArrayList<>());
        map.put(key2, new ArrayList<>());
        map.put(null, null);

        key1 = null;
        key2 = null;

        System.gc();

        System.out.println(ref.get());
    }
}
