package Day12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Integer> list = new ArrayList<>();  //List and Integer are already implementing Serializable
        for(int i = 1; i <= 5; i++){
            list.add(i);
        }
        System.out.println(list);

        serialize(list);  //method for serializing the list object

        List<? extends Number> list1 = (List<? extends Number>) deserialize();   //method deserialize and return the object
        System.out.println(list1);
    }


    //Serializing the list object
    public static void serialize(Object list) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Arun P\\OneDrive\\Desktop\\SerObj.txt"));
        oos.writeObject(list);
        oos.close();
    }


    //Deserialize the object and return
    public static Object deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Arun P\\OneDrive\\Desktop\\SerObj.txt"));
        Object list1 = (Object) ois.readObject();
        ois.close();

        return list1;
    }
}
