package lab5.events;
import lab5.random.UniformRandomStream;

/**
 * gets random numbers for creation of PickRandom
 */

public class PickRandom {
    
    private UniformRandomStream uniformRandomStream;

    // Creates a new UniformRandomStream to generate a random number using the given parameters
    PickRandom(double pMin, double pMax, long seed) { 
        
        this.uniformRandomStream = new UniformRandomStream(pMin, pMax, seed);
    }


    double getRandom() {
        return uniformRandomStream.next();
    }
}
