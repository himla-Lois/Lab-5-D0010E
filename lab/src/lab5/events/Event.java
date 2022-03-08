package lab5.events;

public abstract class Event {
    Event next;
    Object SpecificEvent;

    public Event(Object SpecificEvent){
        this.SpecificEvent = SpecificEvent;
    }

}

