package lab5.events;

public class EventQueue {

    Object specificEvent;
    EventQueue next;



    EventQueue(Object specificEvent){
        this.specificEvent = specificEvent;
    }

    public void add(Object event){
        if ( == null){

        }
        EventQueue current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new EventQueue(event);
    }




}



