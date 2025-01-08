package Day10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerSupport support = new CustomerSupport();
        String operation;

        while(true) {
            operation = scanner.next();

            if(operation.equals("Add")){
                String value = scanner.next();
                support.add(value);
            }
            else if(operation.equals("Serve")){
                support.serve();
                support.currentServing();
            }
            else break;
        }

        support.display();
    }
}

class CustomerSupport{
    private Queue<String> queue;
    private String servingCustomer = null;

    CustomerSupport(){
        queue = new LinkedList<>();
    }

    public void add(String customer){
        queue.add(customer);
    }

    public void serve(){
        if(!queue.isEmpty()) {
            servingCustomer = queue.poll();
        }
        else System.out.println("There is no one in the queue!");
    }

    public void currentServing(){
        if(servingCustomer != null){
            System.out.println("Serving : " + servingCustomer);
        }
        else System.out.println("No customers serving currently!");
    }

    public void display(){
        System.out.println("Waiting : " + queue);
    }
}
