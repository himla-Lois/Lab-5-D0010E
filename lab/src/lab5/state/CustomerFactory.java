package lab5.state;

import lab5.state.ShoppingState;

/**
 * Represents the creation source of customers entering the supermarket.
 * Use: creating customers.
 */

public class CustomerFactory {

    ShoppingState sst;
    int number = 0;

    /**
     * Assigns the lowest available number
     */
    public void createCustomer() {

        // TODO:
        //  (1) give a starting stage(event) to new customer.

            sst.customers.add(new Customer(number, null));
            number++;

    }

}
