package lab5.view;

import lab5.events.ClosingEvent;
import lab5.events.StopEvent;
import lab5.state.ShoppingState;
import java.util.Observable;


/**
 * This class prints out the results from the simulator
 * 
 */
public class shoppingView extends View {
	private ShoppingState state;
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
		System.out.println("Antal kassor, N " + state.N );
		System.out.println("Max som ryms, M " + state.M);
		System.out.println("Ankomsthastigheten lamda ");
		System.out.println("Plocktider, [P_min..Pmax] ");
		System.out.println("Betaltider, [K_min..Kmax] ");
		System.out.println("Frö, f " + state.F);
		System.out.println("Tid  Händelse  Kund  ?  led  ledT  I  $  :-(  köat  köT  köar  [Kassakö..]");
	}
	/**
	 * prints results depending on event type
	 */
	public void printRow(Object arg1) {
		if (arg1 instanceof ClosingEvent) {
			System.out.println("0 " + " " + HÄNDELSENAMN);
		}
		
		if (arg1 instanceof StopEvent) {
			System.out.println(TID + " " + HÄNDELSENAMN);
		}
		else {
			System.out.println(TID + " " + arg1 + " " + customerid +" "+
			Event + " " + LEDIGA KASSOR + " " + LEDIGA KASSOR TID + " "  + KUNDER JUST NU +
			" " + state.payingCustomer + " " + state.lostCustomer + " " + ANTAL I KÖ + " " +
			state.queueTime + " " + LÄNGD PÅ KÖN + " " + KASSAKÖ);
		}
		

	}
	
	public void printResult() {
		System.out.println("1) Av " + (state.payingCustomer + state.lostCustomer) + 
				"kunder handlade " + state.payingCustomer + "medan " + state.lostCustomer +
				"missade.");
		
		System.out.println("2) Total tid " + ANTAL LEDIGA ASSOR +" kassor varit lediga:" +
				TID KASSA LEDIG);
		System.out.println("Genomsnittlig ledig kassatid: " + (TID KASSA LEDIG / ANTAL LEDIGA KASSOR) +
				"(dvs" + TID + "av tiden från öppning tills sista kunden betalat).");
				
		System.out.println("3) Total tid " + ANTAL I KÖ + "kunder tvingats köa: " +
				state.queueTime +);
		System.out.println("Genomsnittlig kötid: " + state.queueTime / ANTAL I KÖ );
	}
}
