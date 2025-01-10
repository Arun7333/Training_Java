package Day11;

public class GenericExample {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.setItem(10);

        if(box.getItem() instanceof Integer){
            System.out.println("Yes, it is the instance of Integer.");
        }
        else System.out.println("No, it is not the instance of Integer!");
    }
}

class Box <T> {
    private T value;

    public T getItem(){
        return value;
    }

    public void setItem(T value){
        this.value = value;
    }

    public void printItem(){
        System.out.println(value);
    }
}
