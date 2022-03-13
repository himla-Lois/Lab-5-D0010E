package lab5;

import lab5.events.Event;
import lab5.events.EventQueue;
import lab5.state.State;
import lab5.view.View;

/**
 * Representing the Simulator class used to run the whole program.
 * Use: is simulating and running the events from the list.
 */

public class Simulator {

  private EventQueue queue;
  private State state;
  private View view;

  public Simulator(State state, View view) {

    this.state = state;
    this.view = view;
    this.queue = new EventQueue();


  }

  /**
   * This method takes an event next in line and calls it's method to do it.
   * It will stop when there is no next in line of the list.
   */
  public void run() {

    while (!state.getEBrake() && !queue.isEmpty()) {
            try {
                Event currentEvent = queue.getFirst(); // Gets next event in linkedList, and then run it.
                currentEvent.effect();                 //Executes our first event in line.
                //TODO;Change the current state to what next in linkedList was.
            } catch (NullPointerException e) {
                System.out.print("The simulation is finished");
            }

        }
  }

}


