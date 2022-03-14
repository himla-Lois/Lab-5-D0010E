package lab5.events;

import lab5.state.Customer;
import lab5.state.State;
import lab5.state.ShoppingState;


public class PayEvent extends Event{

    public final int customerNumber;

    public PayEvent(ShoppingState state, EventQueue queue, double time, int customerNumber) {
        super(state, queue, time);
        this.customerNumber = customerNumber;
    }

    public void effect(){

        state.decreaseCustomers();
        state.increaseUnoccupiedRegisters();
        state.increaseFinishedCustomers();
        if (state.getQlength() != 0){
            state.removeFromQue();
            state.decUnoccupiedRegisters();
            new PayEvent(state,queue,state.getQueueTime()+state.getLastPayTime(), state.getFirstNumber());
        }


    }
}
