/**
 * Similar to Environment implementation in Artificial Intelligence: A Modern Approach, 4th US ed.
 * Environment interface that allows adding and removing of agents.
 * Adds simulation of time
 * Contains a performance measure, additional measures must be implemented by the implementer.
 */

public interface Environment {

    boolean isFinished();
    //Steps taken so far.
    int steps();
    long startTime();
    long stopTime();
    //Add an agent
    void addAgent();
    //Remove an agent
    void removeAgent();
    void step();
    //Step a number of steps forward.
    default void step(int n) {
    for (int i = 0; i < n; i++) {step();
        }
    }
    default void stepUntilFinish(){
        while (!isFinished()) {step();
            }
    }
    //Leaving the performance measure to the implementer.

}


