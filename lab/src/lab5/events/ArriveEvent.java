package lab5.events;

import lab5.state.FIFO;
import lab5.state.CustomerFactory;
import lab5.events.PickEvent;

/**
 * Represents the event; arrival, of a customer.
 */
public class ArriveEvent extends Event{

    FIFO f;
    CustomerFactory cf;

    /**
     * Carries out the effect of a customer arrival at the supermarket.
     */
    private void Effect() throws IllegalArgumentException {

        // TODO: 
        //  (1) should add a missed customer if the store id open but full.

        if (f.isFull()) {
            throw new IllegalArgumentException("The supermarket is full.");
        }
        cf.createCustomer();

    }
}
