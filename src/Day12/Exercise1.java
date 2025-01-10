package Day12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String targetFolder = "C:\\Users\\Arun P\\OneDrive\\Desktop";  //target folder where to create new file
        Pattern filePattern = Pattern.compile("[a-zA-Z]+\\.txt");  //pattern for the new file name

        String newFile = scanner.next();
        String filePath;

        if(filePattern.matcher(newFile).matches()){  //check whether the file name matches the pattern
            filePath = targetFolder + "\\" + newFile;
        }
        else{
            filePath = targetFolder + "\\" + "default.txt"; //default value
        }

        //write in the file using buffered writer
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            String name = scanner.next();
            writer.write(name);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Finished!");
    }
}
