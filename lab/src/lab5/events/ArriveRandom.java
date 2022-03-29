package lab5.events;
import lab5.random.ExponentialRandomStream;


public class ArriveRandom {

/**
 * gets random numbers for creation of ArrivalEvent
 * @author Wilma Eriksson
 * @author 
 * @author 
 * @author 
 */
class ArrivalRandom {
    private ExponentialRandomStream randomstream;
    /**
     * initializes a new ExponentialRandomStream using seed and lambda
     *
     * @param lambda
     * @param seed
     */
    ArrivalRandom(double lambda, long seed) {
        this.randomstream = new ExponentialRandomStream(lambda, seed);
    }
    /**
     * returns new random number
     */
    double getRandom() {
        return randomstream.next();
        
    }
}

    
}
