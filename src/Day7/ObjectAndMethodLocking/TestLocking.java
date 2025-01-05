package Day7.ObjectAndMethodLocking;

public class TestLocking {
    public static void main(String[] args) {
        SharedPrinter sharedPrinter = new SharedPrinter(10);
        int start = (int)System.currentTimeMillis();

        //Thread for calling printString method
        //Then it will acquire the object before the thread2
        //So, thread2 cannot access the countDown method until thread1 releases the lock
        Thread thread1 = new Thread(() ->{
            sharedPrinter.printString("String");
        });
        thread1.start();

        //Thread for calling countDown method
        //After the thread1 releases the object lock
        //It wiil acquire the lock and start processing
        Thread thread2 = new Thread(() ->{
            sharedPrinter.countDown();
        });
        thread2.start();

        //Making main thread to wait for threads to finish execution
        try{
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println();
        }

        //calculating the time of execution
        int end = (int)System.currentTimeMillis();
        System.out.println("Time Taken in Object Locking: " + (end - start) + " ms");

        //Example for Method locking
        Printer printer = new Printer(10);
        start = (int)System.currentTimeMillis();

        //Thread for calling printString method
        //Then it will acquire the lock1
        thread1 = new Thread(() ->{
            printer.printString("String", 20);
        });
        thread1.start();

        //Thread for calling countDown method
        //Then it will acquire the lock2
        thread2 = new Thread(() ->{
            printer.countDown();
        });
        thread2.start();

        //Making main thread to wait for threads to finish execution
        try{
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println();
        }

        //calculating the time of execution
        end = (int)System.currentTimeMillis();
        System.out.println("Time Taken in Method locking: " + (end - start) + " ms");


        System.out.println(Thread.currentThread() + "completed its execution");
    }
}

class SharedPrinter{
    private int limit;

    SharedPrinter(int limit){
        this.limit = limit;
    }

    public synchronized void printString(String str){

        for(int i = 0; i < limit; i++){
            System.out.println(str);
        }
    }

    synchronized public void countDown(){

        for(int i = 0; i < limit; i++){
            System.out.println(i);
        }
    }
}

class Printer{
    private int limit;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    Printer(int limit){
        this.limit = limit;
    }

    public void printString(String str, int limit){
        synchronized (lock1) {
            for (int i = 0; i < limit; i++) {
                System.out.println(str);
            }
        }
    }

    public void countDown(){
        synchronized (lock2) {
            for (int i = 0; i < limit; i++) {
                System.out.println(i);
            }
        }
    }
}


