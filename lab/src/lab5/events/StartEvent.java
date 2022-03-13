package lab5.events;

import lab5.state.State;

/**
 * This class is a general class for the starting event of the simulation
 */
public abstract class StartEvent extends Event{

    /**
     *
     * @param state the state of the simulation (in our case: ShoppingState).
     * @param queue The queue at which events are added to.
     * @param time  the time at which this should be preformed
     */
    public StartEvent(State state, EventQueue queue, double time){
        super(state, queue, time);
    }
}

