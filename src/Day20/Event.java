package Day20;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private String name;
    private LocalDateTime dateTime;
    private Duration duration;

    public Event(String name, LocalDateTime dateTime, Duration duration){
        this.name = name;
        this.dateTime = dateTime;
        this.duration = duration;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public Duration getDuration(){
        return duration;
    }

    public String getName(){
        return name;
    }
}
