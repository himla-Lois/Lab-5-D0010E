import events.ClosingEvent;
import events.EventQueue;
import events.OpenEvent;
import events.StopEvent;
import lab5.events.Event;
import events.StartEvent;
import state.State;
import view.View;
import state.ShoppingState;

public class RunSim {
    private static ShoppingState shoppingState;
    protected State state;
	protected EventQueue eventQueue;
	protected StartEvent startEvent;

	public RunSim(){

        public static void main(String[] args) {
            createAndRun(3, 7, 10.0d, 1.0d, 0.5d, 1.0d, 2.0d, 3.0d, 1234);
            
        }

        
    /**
     * runs the simulation.
     *
     * @param N The number of cash registers
     * @param M Max customers in the store
     * @param S Closing time
     * @param lambda Arrival speed (Is used to generate random arrival times)
     * @param pickMin Minimum time for a customer to pick their wares
     * @param pickMax Maximum time for a customer to pick their wares
     * @param payMin Minimum time for a customer to pay for their wares
     * @param payMax Maximum time for a customer to pay for their wares
     * @param F Seed used for random number generator (RNG)
     */

        private static void createAndRun(int N, int M, double S, double lambda, double pickMin, double pickMax, double payMin, double payMax, long F) {
            EventQueue eventQueue = new EventQueue();
            OpenEvent openEvent = new OpenEvent(shoppingState, eventQueue);
            ClosingEvent closingEvent = new ClosingEvent(shoppingState, eventQueue, S);
            StopEvent stopEvent = new StopEvent(shoppingState, eventQueue, time); //TODO: the time should be different argument.

            eventQueue.addFirst(openEvent);
            eventQueue.addLast(closingEvent);
            eventQueue.addLast(stopEvent);

            ShoppingState shoppingState = new ShoppingState(N, M, S, lambda, pickMin, pickMax, payMin, payMax, F);
            View view = new View();

            Simulator simulator = new Simulator(shoppingState, view);

            simulator.run();
        }
	}

