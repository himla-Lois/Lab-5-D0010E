package lab5.events;

import lab5.state.FIFO;
import lab5.state.CustomerFactory;
import lab5.events.PickEvent;
import lab5.state.State;

/**
 * Represents the event; arrival, of a customer.
 */
public class ArriveEvent extends Event{

    private FIFO f;
    private CustomerFactory cf;

    ArriveEvent(State state, EventQueue queue, double time){
        super(state, queue, time);
    }

    /**
     * Carries out the effect of a customer arrival at the supermarket.
     */
    public void effect() throws IllegalArgumentException {



        if (f.isFull()) { // TODO: should also check if store id open
            throw new IllegalArgumentException("The supermarket is full.");
            // TODO: should add a missed customer if the store was open but full.
        }
        // TODO: should check if store is full, and closed. If closed, return false or
        //  throw exception.
        cf.createCustomer();

        // TODO:
        //  (1) a pickEvent should be created here when customer is done picking groceries.
        //  (2) lastly, this effect should create a new future arrive event for the next customer.


    }
}
