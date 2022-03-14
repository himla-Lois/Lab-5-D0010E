package events;

import State.Customer;
import State.ShoppingState;

public class PickEvent extends Event {
	
	private Customer customer;
	private ShoppingState state;
	private EventQueue queue;
	private double time;
<<<<<<< Updated upstream

	/**
	 * @param state State som användas av simolatorn
	 * @param time  Tid som Eventet inträffar
	 * @param queue EEventQueue som används
	 */

	public PickEvent(ShoppingState state, EventQueue queue, double time, Customer customer) {
		super(state, queue, time, customer);

	}

	public void effect() {
		// om lediga kassor betala,annars ställ i kön
		if(state.getUnoccupiedRegisters()>0) {
			state.decUnoccupiedRegisters();
			queue.add(new PayEvent(state,queue,state.getQueueTime()+state.getLastPayTime()) ;
		}
		state.customerqueue.add(customer);
	}

}
=======
>>>>>>> Stashed changes

	/**
	 * @param state State som användas av simolatorn
	 * @param time  Tid som Eventet inträffar
	 * @param queue EEventQueue som används
	 */

	public PickEvent(ShoppingState state, EventQueue queue, double time, Customer customer) {
		super(state, queue, time, customer);

	}

	public void effect() {
		// om lediga kassor betala,annars ställ i kön
		if(state.getUnoccupiedRegisters()>0) {
			state.decUnoccupiedRegisters();
			queue.add(new PayEvent(state,queue,state.getQueueTime()+state.getLastPayTime()) ;
		}
		state.customerqueue.add(customer);
	}

}

}
}
