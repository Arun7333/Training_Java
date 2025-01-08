package Day10;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkedListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TaskManager taskManager = new TaskManager();

        //Adding tasks
        for(int i = 0; i < n; i++){
            String task = scanner.next();
            taskManager.add(task);
        }

        //Removing a task
        String taskToRemove = scanner.next();
        taskManager.remove(taskToRemove);

        //Display all the tasks
        taskManager.display();
    }
}

class TaskManager{
    private List<String> tasks;

    TaskManager(){
        tasks = new LinkedList<>();
    }

    public void add(String task){
        tasks.add(task);
    }

    public void remove(String task){
        tasks.remove(task);
    }

    public void display(){
        System.out.println("Tasks Assigned:");
        tasks.stream().forEach(System.out::println);
    }
}
