package lab5.view;

import lab5.events.ClosingEvent;
import lab5.events.StopEvent;
import lab5.state.ShoppingState;
import lab5.state.State;
import java.util.Observable;


/**
 * This class prints out the results from the simulator
 * 
 */
public class shoppingView extends View {
	private ShoppingState state;
	private State stat;

	/**
	 * @param state 
	 *  The state is used to accessed the variables from shoppingState
	 */
	public shoppingView(ShoppingState state) {
		this.state = state;
	}
	public void startParameters(){
		System.out.println("PARAMETRAR");
		System.out.println("==========");
		System.out.println("Antal kassor, N..........: " + state.getN());
		System.out.println("Max som ryms, M..........: " + state.getM());
		System.out.println("Ankomsthastigheten, lamda: " + state.getLambda());
		System.out.println("Plocktider, [P_min..Pmax]: " + "[" + state.getPickMin() + ".."+ state.getPickMax() );
		System.out.println("Betaltider, [K_min..Kmax]: " + "[" + state.getPayMin() + ".."+ state.getPayMax());
		System.out.println("Frö, f...................: " + state.getF());
		System.out.println("Tid  Händelse  Kund  ?  led  ledT  I  $  :-(  köat  köT  köar  [Kassakö..]");
	}
	/**
	 * prints results depending on event type
	 */
	public void printRow(Object arg1) {
		if (arg1 instanceof ClosingEvent) {
			System.out.println("0 " + " " + "closing");
		}
		
		if (arg1 instanceof StopEvent) {
			System.out.println(state.getS() + " " + "stop");
		}
		else {
			System.out.println(stat.getTime() + " " + arg1 + " " + state.getCustomerID() +" "+
			state.getStatus() + " " + state.getUnoccupiedRegisters() + " " + state.wastedCashierTime() + " "  + state.getQueuedCustomers() +
			" " + state.getPayingCustomers() + " " + state.getLostCustomers() + " " + state.getNrOfCustomers() + " " +
			state.getQueueTime() + " " + state.getNrOfCustomers() + " " + state.getQueueString());
		}
		

	}
	
	public void printResult() {
		System.out.println("1) Av " + (state.getPayingCustomers ()+ state.getLostCustomers()) + 
				"kunder handlade " + state.getPayingCustomers() + "medan " + state.getLostCustomers() +
				"missade.");
		
		System.out.println("2) Total tid " + state.getUnoccupiedRegisters() +" kassor varit lediga:" +
				state.wastedCashierTime());
		System.out.println("Genomsnittlig ledig kassatid: " + (state.wastedCashierTime()  / state.getUnoccupiedRegisters()) +
				"(dvs" + state.getLastPayTime() + "av tiden från öppning tills sista kunden betalat).");
				
		System.out.println("3) Total tid " + state.getQueuedCustomers() + "kunder tvingats köa: " +
				state.getQueueTime() + "te");
		System.out.println("Genomsnittlig kötid: " + state.getQueueTime() / state.getQueuedCustomers());
	}
}

