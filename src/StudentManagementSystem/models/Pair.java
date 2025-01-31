package StudentManagementSystem.models;

public class Pair <S, T>{
    private S key;
    private T value;

    public Pair(S key, T value){
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
