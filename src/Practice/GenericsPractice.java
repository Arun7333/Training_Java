package Practice;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class GenericsPractice {
    public static void main(String[] args) {
        //Example for Covariance
        Box<? extends Number> box = new Box<>();
        Number num = box.getValue();
        //box.setValue(Integer.valueOf(10));     //can't set value, will show compile time error


        //Example for ContraVariance
        Box<? super Number> box2 = new Box<>();
        box2.setValue(Integer.valueOf(10));
        Object value = box2.getValue();   //get value by only referencing to Object
    }
}

class Box<T>{
    private T obj;

    public T getValue(){
        return obj;
    }

    public void setValue(T value){
        obj = value;
    }
}
