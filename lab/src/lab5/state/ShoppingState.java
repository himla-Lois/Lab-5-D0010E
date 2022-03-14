package state;

import state.CustomerFactory;
import state.FIFO;

/**
 *  Special simulation representing a supermarket
 */

public class ShoppingState extends State{

    // TODO

    FIFO customers = new FIFO();

    final int N; // Number of registerd open cash
    final int M; // maximum allowed customers
    final double S; // closing-time (starts at 0)
    final double lambda; // ankomsthastigheten för kunder
    final double pickMin; // min picktime
    final double pickMax; // max picktime
    final double payMin; // min paytime
    final double payMax; // max paytime
    final long F; // seed/frö

     
    private int customer;
    private int payingCustomers;
    private int lostCustomers;
    private int queuedCustomers;

    private int unoccupiedRegisters;

    private double wastedCashierTime = 0;
    private double queueTime;

    private Customer eventCustomer;
    private double lastPayTime;

    private Object customerFactory;

    private Object FIFO;

    
/** 
     * The constructor for shoppingstate. Defines values based on arguments. 
     *
     * @param N The number of cash registers
     * @param M Max customers in the store
     * @param S Closing time
     * @param lambda Arrival speed (Is used to generate random arrival times)
     * @param pickMin Minimum time for a customer to pick their wares
     * @param pickMax Maximum time for a customer to pick their wares
     * @param payMin Minimum time for a customer to pay for their wares
     * @param payMax Maximum time for a customer to pay for their wares
     * @param F Seed used in random number generators
     */
    public ShoppingState(int N, int M, double S, double lambda, double pickMin, double pickMax, double payMin, double payMax, long F) {
        super();
        if(N <= 0 || M <= 0 || S <= 0 || lambda <= 0 || pickMin < 0 || pickMax <= 0 || payMin < 0 || payMax <= 0) {   // Checks parameters are invalid
            throw new IllegalArgumentException("Illegal arguments in constructor");
        }

        this.customerFactory = new CustomerFactory();
        this.FIFO   = new FIFO();
        this.RandomArrival   = new RandomArrival(lambda, F);
        this.shopRandom      = new ShopRandom(pickMin, pickMax, F);
        this.payRandom       = new PayRandom(payMin, payMax, F);

        this.N = N;
        this.M = M;
        this.S = S;
        
        this.lambda = lambda;
        this.pickMin = pickMin;
        this.pickMax = pickMax;
        this.payMin = payMin;
        this.payMax = payMax;

        this.F = F;

        this.customers       = 0;
        this.payingCustomers = 0;
        this.lostCustomers   = 0;
        this.queuedCustomers = 0;

        this.unoccupiedRegisters = N;

        this.wastedCashierTime = 0.0d;
        this.queueTime = 0.0d;

        this.eventCustomer = null;
        this.lastPayTime = 0.0d;
        

    Customer makeCustomer(){
        return this.customerFactory.createCustomer();
    }

    String getQueueString() {
            return this.FIFO.toString();
    }


    void addToQue(){
        this.FIFO.add(Customer c);
    }

    Customer removeFromQue(){
        this.FIFO.remove();
    }

    int getQlength(){
        return this.FIFO.getSize();
    }

    double nextArrivalRandom() {
        return this.arrivalRandom.getRandom();
    }


    double nextShopRandom() {
        return this.shopRandom.getRandom();
    }


    double nextPayRandom() {
        return this.payRandom.getRandom();
    }

    
    /**
     * Used by view to get the number of customers in the store
     * @return returns the numbers of customers in the store 
     */
    int getNrOfCustomers() {
        return this.customer;
    }


    void increaseCustomers() {
        ++this.customer;
    }


    void decreaseCustomers() {
        if(this.customer == 0) {
            throw new RuntimeException("customers cannot be lower than 0");
        }
        --this.customer;
    }

    
    int getPayingCustomers() {
        return this.payingCustomers;
    }


    void increasePayingCustomers() {
        ++this.payingCustomers;
    }


    /**
     * Used by view and Optimize to get the customers that didn't pay
     * @return returns the amount of lostCustomers 
     */
    public int getLostCustomers() {
        return this.lostCustomers;
    }


    void increaseLostCustomer() {
        ++this.lostCustomers;
    }


    double wastedCashierTime() {
        return wastedCashierTime;
    }


    private void addToWastedCashierTime(double wastedCashierTime) {
        if(wastedCashierTime < 0) {
            throw new IllegalArgumentException("no negative time");
        }
        this.wastedCashierTime += wastedCashierTime;
    }


    double getQueueTime() {
        return this.queueTime;
    }


    void addToQueueTime(double queueTime) {
        if(queueTime < 0) {
            throw new IllegalArgumentException("no negative time");
        }
        this.queueTime += queueTime;
    }


<<<<<<< Updated upstream
    int getUnoccupiedRegisters() { //IM HERE
=======
    int getUnoccupiedRegisters() {
>>>>>>> Stashed changes
        return unoccupiedRegisters;
    }


    void increaseUnoccupiedRegisters() {
        if(this.unoccupiedRegisters == this.N) {
            throw new RuntimeException("unoccupiedRegisters cannot be greater than N");
        }
        ++this.unoccupiedRegisters;
    }


    void decUnoccupiedRegisters() {
        if(this.unoccupiedRegisters == 0) {
            throw new RuntimeException("unoccupiedRegisters cannot be lower than 0");
        }
        --this.unoccupiedRegisters;
    }


    int getQueuedCustomers() {
        return queuedCustomers;
    }


    void incQueuedCustomers() {
        ++this.queuedCustomers;
    }


    Customer getEventCustomer() {
        return eventCustomer;
    }


    void setEventCustomer(Customer eventCustomer) {
        this.eventCustomer = eventCustomer;
    }

    
<<<<<<< Updated upstream
    void updateQAndRLogTime(double time) {
=======
    public void updateQAndRLogTime(double time) {
>>>>>>> Stashed changes
        //Adds time to the two variables using the current time
        this.addToUnusedCashloggedTime((time - this.getCurrentTime()) * this.getUnoccupiedRegisters());
        
        this.addToQueueTime((time - this.getCurrentTime()) * this.getQueueLength());
    }


    double getLastPayTime() {
        return lastPayTime;
    }


    void setLastPayTime(double lastPayTime) {
        if(lastPayTime < this.lastPayTime) {
            throw new IllegalArgumentException("lastPayTime cannot be less than the previous time");
        }
        this.lastPayTime = lastPayTime;
    }
<<<<<<< Updated upstream
=======
    public static void updateQAndLogTime(Object time) {
    }
>>>>>>> Stashed changes

}
