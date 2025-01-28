package Day19.CompletableAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableAndFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String message = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 100;
        }).thenCombine(
                CompletableFuture.supplyAsync(() ->{
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    return "Arun";
                }), (id, name) ->{
                    return "Hello " + "Mr." + name + " your id is : " + id;
                }
        ).get();

        System.out.println(message);
    }
}
