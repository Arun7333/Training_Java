package Day10;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor textEditor = new TextEditor();
        String operation;

        while(true) {
            operation = scanner.next();

            if(operation.equals("Type")){
                String value = scanner.next();
                textEditor.type(value);
            }
            else if(operation.equals("Undo")){
                textEditor.undo();
            }
            else break;
        }

        textEditor.display();
    }
}

class TextEditor{
    private Stack<String> inputSpace;

    TextEditor(){
        inputSpace = new Stack<>();
    }

    public void type(String value){
        inputSpace.push(value);
    }

    public void undo(){
        if(!inputSpace.isEmpty()) {
            inputSpace.pop();
        }
        else System.out.println("There is empty space!");
    }

    public void display(){
        Iterator<String> iterator = inputSpace.iterator();

        StringBuilder wholeString = new StringBuilder();
        while(iterator.hasNext()){
            wholeString.append(iterator.next());

            if(iterator.hasNext()){
                wholeString.append(" ");
            }
        }

        System.out.println("Current Text: " + wholeString.toString());
    }
}
