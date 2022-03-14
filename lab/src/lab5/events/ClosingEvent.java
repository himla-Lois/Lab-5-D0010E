package events;

import state.State;

import lab5.events.Event;
import state.ShoppingState;

/** 
 * event simulating shop closing
 */
public class ClosingEvent extends Event {

    private Object time;


    /**
     *
     * constructor
     * @param time The time at which the event occurs
     * @param eventQueue The eventqueue is needed as a parameter to add the event to the eventqueue
     */
    public ClosingEvent(State state, EventQueue queue, double time) {
        super(state, queue, time);
    }

    @Override
    public void effect(State state) {
        ShoppingState.updateQAndLogTime(time);

        // does nothing, exists to be printed in view.
        
    }
    
    protected String getEventName() {
        return "CloseEvent";
    }

}
