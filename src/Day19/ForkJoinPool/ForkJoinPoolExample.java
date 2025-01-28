package Day19.ForkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ForkJoinPoolExample extends RecursiveTask<Long> {
    public static final int THRESHOLD = 100;
    public int start;
    public int end;

    public ForkJoinPoolExample(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int currSize = end - start;

        if(currSize <= THRESHOLD){
            long sum = 0;

            for (start = start; start <= end; start++){
                sum += start;
            }

            return sum;
        }

        int mid = (start + end) / 2;

        ForkJoinPoolExample leftSubTask = new ForkJoinPoolExample(start, mid);
        ForkJoinPoolExample rightSubTask = new ForkJoinPoolExample(mid + 1, end);

        //run parallely
        leftSubTask.fork();
        rightSubTask.fork();

        //combine tasks
        long leftSum = leftSubTask.join();
        long rightSum = rightSubTask.join();

        return leftSum + rightSum;
    }

    public static void main(String[] args) {

        try(ForkJoinPool pool = new ForkJoinPool()){
            ForkJoinPoolExample example = new ForkJoinPoolExample(1, 1000000);

            long sum = pool.invoke(example);
            System.out.println("Sum of 1 to 1,000,000 is : " + sum);
        }

    }
}


