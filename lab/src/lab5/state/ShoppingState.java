package lab5.state;

/**
 *  Special simulation representing a supermarket
 */

public class ShoppingState extends State{

    // TODO

    FIFO customers = new FIFO();

    private int N; // open cash-registers.
    private int M; // maximum allowed customers in store.
    private int S; // store closing-time(opens at 0).
    private long F; // seed(start value for random-generators)
    private int payingCustomer;
    private int lostCustomer;
    private float wastedCashierTime = 0;
    private float queueTime;

    // TODO

}
