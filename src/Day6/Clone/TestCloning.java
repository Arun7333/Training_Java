package Day6.Clone;

public class TestCloning {
    public static void main(String[] args) {
        Student student = new Student("Arun", 21);
        Student clonedObject = null;

        try{
            clonedObject = (Student) student.clone();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //To assure the objects are cloned
        System.out.println(student.hashCode());
        System.out.println(clonedObject.hashCode());
    }
}
