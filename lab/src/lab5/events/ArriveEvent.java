package events;

import lab5.events.Event;
import state.ShoppingState;
import state.State;

/**
 * Represents the event; arrival, of a customer.
 */

public class ArriveEvent extends Event {
    private double time;
    private EventQueue eQueue;

    ArriveEvent(State state, EventQueue eQueue, double time) {
        super(state, eQueue, time);

    }

    @Override
    public void effect(State state) {
        ShoppingState shoppingState = (ShoppingState) state; // Turn shoppingstate to state.

        if (shoppingState.getCurrentTime() < shoppingState.S) { // see if the store is still before closingtime.
            shoppingState.updateQAndRLogTime(time);
        }

        effect(state);

        shoppingState.makeCustomer();

        double arrivalTime = shoppingState.getCurrentTime() + shoppingState.nextArrivalRandom(); // Time where customer
                                                                                                 // arrived
        ArriveEvent arrivalEvent = new ArriveEvent(state, eQueue, arrivalTime); // create arriveEvent here
        eQueue.addFirst(arrivalEvent); // Added it to EventQueue

        if (shoppingState.getNrOfCustomers() < shoppingState.M) { // looks if it's full with customers in the shop
            shoppingState.increaseCustomers();

        } else { // om det är fullt i "butiken" så räknas kunden som förlorad
            shoppingState.increaseLostCustomer();
        }
    }

    protected String EventName() {
        return "ArrivalEvent";
    }
}

