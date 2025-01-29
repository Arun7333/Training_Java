package Day20;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeExample {
    public static void main(String[] args) {
        EventHandler handler = new EventHandler();
        handler.addEvent(new Event(
                "Brushing",
                LocalDateTime.of(LocalDate.of(2025, 01, 29), LocalTime.of(6, 0)),
                Duration.ofMinutes(10)  
        ));
        handler.addEvent(new Event(
                "Get Ready to College",
                LocalDateTime.of(2025, 01, 29, 6, 20),
                Duration.ofMinutes(20)
        ));
        handler.addEvent(new Event(
                "Going to College by bus",
                LocalDateTime.of(2025, 01, 29, 6, 30),
                Duration.ofMinutes(150)
        ));


        handler.displayEvents();
        System.out.println("___________________________");

        handler.filterEvents(LocalDate.of(2025, 01, 29));
        System.out.println("___________________________");

        Event start = handler.getEvent(0);
        Event end = handler.getEvent(2);
        if(start != null && end != null){
            handler.durationBetween(start, end);
        }
    }
}
