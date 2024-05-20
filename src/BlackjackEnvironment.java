import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackjackEnvironment implements Environment {
    public ArrayList<String>agents = new ArrayList<>();
    public ArrayList<Integer> dealerHand;
    public ArrayList<Integer> playerHand = new ArrayList<Integer>(2);

    void init(){
        dealerHand = new ArrayList(List.of(4, 10));
        playerHand = new ArrayList(List.of(6, 11));
        addAgent();

    }
    public int getCard(){
        return (int)  (Math.random() * 10 +1);
    }
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public int steps() {
        return 0;
    }

    @Override
    public long startTime() {
        return 0;
    }

    @Override
    public long stopTime() {
        return 0;
    }

    @Override
    public void addAgent() {
        agents.add("simpleReflex");
       simpleReflexAgent(dealerHand, playerHand);
    }

    @Override
    public void removeAgent() {

    }

    @Override
    public void step() {

    }

    @Override
    public void step(int n) {
        Environment.super.step(n);
    }

    @Override
    public void stepUntilFinish() {
        Environment.super.stepUntilFinish();
    }

    public String simpleReflexAgent(ArrayList<Integer> dealerHand, ArrayList<Integer> playerHand) {
        String[] actions = {"HIT", "STAY", "BUST", "NATURAL"};
        int sum = 0;
        for (int i = 0; i < playerHand.size(); i++) {
            sum += playerHand.get(i);
        }
        //Bust
        if (sum > 21) {
            System.out.println(actions[2]);
            return actions[2];
        }
        //Natural
        if (sum == 21) {
            System.out.println(actions[3]);
            return actions[3];
        }
        if (sum > 16) {
            System.out.println(actions[1]);
            return actions[1];
        }
        System.out.println(actions[0]);
        playerHand.add(getCard());
        return simpleReflexAgent(dealerHand, playerHand);
    }
}

