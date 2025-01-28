package Day19.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ExecutorsExample {
    public static int count = 0;

    public static void main(String[] args) {

        try(ExecutorService executor = Executors.newFixedThreadPool(5)){

            Stream.iterate(0, n -> n < 10, n -> n+1).forEach(
                    i -> {
                        executor.submit(() ->{
                            System.out.println("New Task Invoked : " + ++count);
                            Stream.iterate(1, n -> n <= 10, n -> n + 1)
                                    .map(j -> count * j)
                                    .forEach(System.out::println);
                        });
                    }
            );

            executor.shutdown();
            while(!executor.awaitTermination(4, TimeUnit.SECONDS)){
                Thread.sleep(2000);
                System.out.println("waiting______________");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("terminated!");
    }
}

