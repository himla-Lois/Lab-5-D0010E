package lab5.state;

/**
 * Represents the supermarket customers
 * Use: to create new customers
 */

public class Customer {

    public int customerNumber;
    private Object customerStage;

    /**
     * The Constructor
     *
     * @param customerNumber used to keep track of individual customers.
     * @param customerStage  used to keep track of which event individual customers are in.
     */

    public Customer(int customerNumber, Object customerStage) {
        this.customerNumber = customerNumber;
        this.customerStage = customerStage;

        // TODO: (1) could be more efficient to set the stag when defining it, and
        //  create a setStage() method to alter it when needed.
    }

    /**
     * @return The customers individual number.
     */
    public int getNumber() {
        return this.customerNumber;
    }

}
