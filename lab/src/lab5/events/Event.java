package lab5.events;
import State.State;

public abstract class Event {
   	private State state;
	private EventQueue queue;
	private double time;
	public Event(State state,EventQueue queue,double time) {
		this.state=state;
		this.time=time;
		this.queue=queue;
	}
	public abstract void effect();
}



