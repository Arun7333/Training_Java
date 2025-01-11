package Day12;

import java.io.*;

public class Exercise3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student stu1 = new Student("Arun");

        byte[] serializedObject = serialize(stu1);      //serialize and return the stored byte array
        Student stu2 = (Student) deserialize(serializedObject);     //deserialize and return the object

        if(stu1.getName().equals(stu2.getName())){
            System.out.println("The object was successfully deserialized!");
        }
    }

    public static byte[] serialize(Object object) throws IOException {
        byte[] serializedObject = null;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        serializedObject = baos.toByteArray();

        return serializedObject;
    }

    public static Object deserialize(byte[] objectArray) throws IOException, ClassNotFoundException {
        Object object = null;

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(objectArray));
        object = ois.readObject();
        ois.close();

        return object;
    }
}

class Student implements Externalizable{
    private String name;

    public Student(){
        //Necessary to create empty parameterized constructor when implementing Externalizable
    }

    Student(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Writing the object to the file");
        out.writeUTF(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Reading the object from the file");
        name = in.readUTF();
    }
}
