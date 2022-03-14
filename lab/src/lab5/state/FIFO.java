package lab5.state;

import java.util.LinkedList;

/**
 * Represents a FIFO queue.
 * Use: to store customers that currently are in the supermarket(using a LinkedList).
 */

public class FIFO {

    LinkedList<Customer> Q = new LinkedList<Customer>();

    private final int max = 50; // supermarket maximum size.

    /**
     * @return The maximum amount of customers to be in the supermarket at once.
     */
    public int maxSize() {
        return max;
    }

    /**
     * @return true if queue is empty, false if it isn't.
     */
    private boolean isEmpty() {
        return Q.size() == 0;
    }

    /**
     *
     * @return true if queue is full, false if it isn't.
     */
    public boolean isFull(){
        return Q.size() == max;
    }

    /**
     * @param number is the individual customer number.
     * @return object at position of number. Unless queue is empty.
     */
    public Object get(int number) throws IllegalArgumentException{
        if(isEmpty()){
            throw new IllegalArgumentException("Can't access this item in queue.");
        }
        return Q.get(number);
    }
    /**
     *
     * @return First item in the queue.
     */
    public Object getFirst() throws IllegalArgumentException{
        if(isEmpty()) {
            throw new IllegalArgumentException("Can't access this item in queue");
        }
        return Q.get(0);
    }

    /**
     * @param o a customer that has entered the supermarket.
     * @throws IllegalArgumentException when the maximum amount of customers in
     * the supermarket has been reached.
     */
    public void add(Customer o) throws IllegalArgumentException {
        if (Q.size() > maxSize()) {
            throw new IllegalArgumentException("Queue has already reached max size.");
        }
        Q.add(o);
    }

    /**
     * @throws IllegalArgumentException when the queue is empty.
     */
    public void remove() throws IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        Q.poll();
    }
    
    /**
    * @return the queue compiled in a string
    */
    public String toString() {
        String compile = "Customer queue: ";
        for (int customer = 0; customer < Q.size(); customer++) {
            compile += "(" + String.valueOf(get(customer)) + ") ";
        }
        return compile;
    }


}
