package lab5.state;
import java.util.Observable;

public class State extends Observable {
    private int currentState = 0;
    public boolean eBrake = false;
    protected double currentTime;

    public State() {
      this.eBrake = false;
      this.currentTime = 0.0d;
  }


    public double getCurrentTime() {        //Keeps track of runtime.
      return currentTime;
  }

    
    
    public int addTime(int time) {
    	currentState += time;
		return currentState;
    }
    
    
    public void stopSim(){
    	eBrake = true;
    }
	public void callObservers(){     //Call the observer every time an EVENT has been triggered.
		setChanged();
		notifyObservers();
	}
}

