package StudentManagementSystem.ui;

public class Form {
    public String name;
    public String email;
    public char grade;
    public int age;

    public boolean[] validity;

    public Form(){
        validity = new boolean[4];
    }

    public boolean isAllValid(){
        for (boolean isValid : validity){
            if(!isValid) return false;
        }

        return true;
    }
}
