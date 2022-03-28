package events;

import state.ShoppingState;
import state.State;

/**
 * This class is an event that is preformed at the start of the simulation, and greets the first customer.
 */
public class OpenEvent extends StartEvent{

    ShoppingState S; // the state at which this should be used in
    EventQueue Q; // the queue to which this should be added

    /**
     * The constructor
     * @param state the state of the simulation (in our case: ShoppingState).
     * @param queue The queue at which events are added to.
     */
    public OpenEvent(ShoppingState S, EventQueue queue){
        super(S, Q);
        this.Q = queue;
    }

    /**
     * The specific effect of this event
     */
    public void effect(){
        Q.addFirst(new ArriveEvent(S, Q, 0 )); // TODO: the time parameter is uncertain, and should not be taken as a definite.
    }
}
