package lab5.events;
import State.State;
public class StopEvent extends Event{ 
	private State state;
	private EventQueue queue;
	private double time;
<<<<<<< Updated upstream

	/**
	 * @param state State som användas av simolatorn
	 * @param time  Tid som Eventet inträffar
	 * @param queue EEventQueue som används
	 */

	public StopEvent(State state, EventQueue queue, double time) {
		super(state, queue, time);

	}
	

	public void effect() {
		state.stopSim();

	}

}

=======

	/**
	 * @param state State som användas av simolatorn
	 * @param time  Tid som Eventet inträffar
	 * @param queue EEventQueue som används
	 */

	public StopEvent(State state, EventQueue queue, double time) {
		super(state, queue, time);

	}
	

	public void effect() {
		state.stopSim();

	}

}
>>>>>>> Stashed changes
