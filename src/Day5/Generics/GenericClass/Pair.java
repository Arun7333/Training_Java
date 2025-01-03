package Day5.Generics.GenericClass;

/*
    Create a generic class Pair<K, V> to hold a key-value pair. Write a program to store and
    display pairs of different data types, like <String, Integer> or <Integer, String>.
*/

public class Pair <S, T>{
    private S key;
    private T value;

    Pair(S key, T value){
        this.key = key;
        this.value = value;
    }

    public S getKey(){
        return key;
    }

    public void setValue(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public void display(){
        System.out.println("Key: " + key);
        System.out.println("Value: " + value);
    }
}
