package Day7.ThreadIntro;

class Thread1 extends Thread{

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){

            System.out.println(i);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Thread2 implements Runnable{

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){

            System.out.println(Math.pow(i, 2));
            try{
                Thread.sleep(700);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        //creating and starting Thread1
        Thread1 thread1 = new Thread1();
        thread1.start();

        //creating and starting Thread2
        Thread thread2 = new Thread(new Thread2());
        thread2.start();
    }
}
