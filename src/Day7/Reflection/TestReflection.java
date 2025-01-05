package Day7.Reflection;

import Day2.Library.Librarian;
import Day2.Library.Library;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflection {
    public static void main(String[] args) throws Exception {

        //Getting the Class object without loading the class
        Class cls = Day2.Library.Library.class;

        //getting arrays of methods, fields and Constructors
        Method[] methods = cls.getDeclaredMethods();
        Constructor[] constructors = cls.getDeclaredConstructors();
        Field[] fields = cls.getDeclaredFields();

        //creating object for the class
        Constructor constructor = cls.getConstructor();
        Library library = (Library)constructor.newInstance();

        //Conmstructors
        System.out.println("Constructors: ");
        for(Constructor cons : constructors){
            System.out.println(cons);
        }

        //Fields and their Types
        System.out.println("Fields and their Types: ");
        for(Field field : fields){
            System.out.println(field.getName() + " : " + field.getType());
        }

        //Methods and their Return Types
        System.out.println("Methods and their Return Types: ");
        for(Method method : methods){
            if(method.getName().equals("setLibrarian")){
                method.invoke(library, new Librarian(01, "Arun", library));
            }

            System.out.println(method.getName() + " : " + method.getReturnType());
        }

    }
}
