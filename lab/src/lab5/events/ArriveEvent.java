package ShoppingSim;

import GeneralSim.Event;
import GeneralSim.EventQueue;
import GeneralSim.State;
import ShoppingSim.CustomerThings.Customer;
/** 
 * Event representing a customer arriving
 * @author Johan Sundin
 * @author William Poromaa
 * @author Hugo Lind
 * @author Isak Lockman
 * 
 */
public class ArrivalEvent extends Event {

    /** 
     *
     * constructor
     * @param time The time at which the event occurs
     * @param eventQueue The eventqueue is needed as a parameter to add the event to the eventqueue
     */
    ArrivalEvent(double time, EventQueue eventQueue) {
        super(time, eventQueue);
    }

    @Override
    protected void doEvent(State state) {
        ShoppingState shoppingState = (ShoppingState)state;

        if(shoppingState.getCurrentTime() < shoppingState.S) {
            shoppingState.updateQueueAndRegisterTime(super.time); // efter stängningstid ska inte tiderna uppdateras av arrival
        }



        super.doEvent(state);
        
        Customer customer = shoppingState.createCustomer();
        
        if(shoppingState.getCurrentTime() < shoppingState.S) { // kollar om före stängningstid

            // skapar arrivalEvent
            double arrivalTime = shoppingState.getCurrentTime() + shoppingState.nextArrivalRandom();
            ArrivalEvent arrivalEvent = new ArrivalEvent(arrivalTime, super.eventQueue);
            super.eventQueue.push(arrivalEvent);

            if(shoppingState.getCustomers() < shoppingState.M) { // kollar om det inte är fullt i butiken
                shoppingState.incCustomers();
                // skapar shopEvent
                double shopTime = shoppingState.getCurrentTime() + shoppingState.nextShopRandom();
                ShopEvent shopEvent = new ShopEvent(shopTime, super.eventQueue, customer);
                super.eventQueue.push(shopEvent);

            } else { // om det är fullt i "butiken" så räknas kunden som förlorad
                shoppingState.incLostCustomer();
            }
            
        }  
    }

    @Override
    protected String getEventName() {
        return "ArrivalEvent";
    }
    
}

