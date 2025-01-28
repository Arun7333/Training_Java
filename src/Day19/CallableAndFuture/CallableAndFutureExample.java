package Day19.CallableAndFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutureExample {
    public static int count = 5;

    public static void main(String[] args) {

        try(ExecutorService executor = Executors.newFixedThreadPool(3)){
            List<Future<Long>> answers = new ArrayList<>();

            for(int i = 0; i < 5; i++){
                Future<Long> answer = executor.submit(() ->{
                    long fact = 1;

                    for(int j = 1; j <= 10; j++){
                        fact *= j;
                    }

                    return fact;
                });

                answers.add(answer);
            }

            executor.shutdown();
            while(!executor.isTerminated()){
                Thread.sleep(2000);
                System.out.println("waiting_________");
            }

            System.out.println("Answers :");
            for(Future<Long> answer : answers){
                System.out.println(answer.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
