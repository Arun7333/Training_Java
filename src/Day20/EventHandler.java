package Day20;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    private List<Event> events;

    public EventHandler(){
        events = new ArrayList<>();
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public Event getEvent(int index){
        if(index < events.size()){
            return events.get(index);
        }

        return null;
    }

    public void displayEvents(){
        if(!events.isEmpty()){
            System.out.println("Events :");

            for (Event event : events){
                System.out.println(event.getName() + " : " + event.getDateTime() + " : " + event.getDuration());
            }
        }
    }

    public void filterEvents(LocalDate targetDate){

        System.out.println("Events at " + targetDate + " are :");
        events.stream().filter(event -> event.getDateTime().toLocalDate().equals(targetDate))
                .map(Event::getName)
                .forEach(System.out::println);
    }

    public void durationBetween(Event start, Event end){
        Duration duration = Duration.between(start.getDateTime(), end.getDateTime());

        System.out.println("Duration between " + start.getName() + " and " + end.getName() + " is " + duration.toMinutes());
    }
}
