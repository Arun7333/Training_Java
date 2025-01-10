package Day11;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VotingSystem system = new VotingSystem();

        try {
            runThreads(system);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        system.display();
    }

    public static void runThreads (VotingSystem system) throws InterruptedException {
        system.addCandidate("Arun");
        system.addCandidate("Karthi");

        Thread thread1 = new Thread(() ->{
            for(int i = 0; i < 10; i++){
                system.addVote("Arun");
            }
        });

        Thread thread2 = new Thread(() ->{
            for(int i = 0; i < 10; i++){
                system.addVote("Karthi");
            }
        });

        Thread thread3 = new Thread(() ->{
            for(int i = 0; i < 10; i++){
                system.addVote("Arun");
            }
        });

        Thread thread4 = new Thread(() ->{
            system.addCandidate("Charlie");
            for(int i = 0; i < 10; i++){
                system.addVote("Charlie");
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}

class VotingSystem{
    private ConcurrentMap<String, Integer> votes;

    VotingSystem(){
        votes = new ConcurrentHashMap<>();
    }

    public void addCandidate(String candidate){
        votes.put(candidate, 0);
    }

    public void addVote(String candidate){
        votes.computeIfPresent(candidate, (cand, vote) -> vote + 1);
    }

    public void display(){
        Iterator<Map.Entry<String, Integer>> iterator = votes.entrySet().iterator();

        System.out.println("Candidates and their votings:");
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();

            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
