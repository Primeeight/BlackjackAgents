/**
 * Similar to Environment implementation in Artificial Intelligence: A Modern Approach, 4th US ed.
 * Environment interface that allows adding and removing of agents.
 * Adds simulation of time
 * Contains a performance measure, additional measures must be implemented by the implementer.
 */

public interface Environment {
    void setupENV();
    boolean isFinished();
    void startTime();
    void stopTime(long startTime);
    //Add an agent
    void addAgents();
    //Remove an agent
    void removeAgent(String agentName);
    String[] getAgents();
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


