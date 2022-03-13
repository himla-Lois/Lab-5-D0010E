package lab5.state;
import java.util.Observable;

public class State extends Observable {
    private int currentState = 0;
    private boolean eBrake = false;

    // TODO: should be able to keep track of runtime.
    //  And should call the observer every time an EVENT has been triggered.
    
    public int addTime(int time) {
    	currentState += time;
		return currentState;
    }
    
    
    public void stopSim(){
    	eBrake = true;
    }
    public void callObservers(){
	setChanged();
	notifyObservers();
    }
    public boolean getEBrake(){
        return eBrake;
    }
}

