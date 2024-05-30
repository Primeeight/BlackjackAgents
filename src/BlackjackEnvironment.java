import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BlackjackEnvironment implements Environment {
    public class AgentProgram{
        //May cause problems with the fact that simple reflex agents are not supposed to maintain an internal state.
        ArrayList<String>actSeq = new ArrayList<>();
        int steps;
        long time;
        public void simpleReflexAgent() {
            //Is this internal memory?
            int sum = 0;
            for (int i = 0; i < playerHand.size(); i++) {
                sum += playerHand.get(i);
            }
            System.out.println("My hand is " + sum);

            //Rules and actions
            String[] actions = {"HIT", "STAY", "NATURAL", "BUST"};
            //Bust
            if (sum > 21) {
                System.out.println(actions[3]);
                actSeq.add(actions[3]);
            }
            //Natural
            else if (sum == 21) {
                System.out.println(actions[2]);
                actSeq.add(actions[2]);
            }
            else if (sum > 16) {
                System.out.println(actions[1]);
                actSeq.add(actions[1]);
            }
            else {
                System.out.println(actions[0]);
                actSeq.add(actions[0]);
                playerHand.add(getCard());
                simpleReflexAgent();
            }
        }
        public void tableDriven(){
            int sum = 0;
            for (int i = 0; i < playerHand.size(); i++) {
                sum += playerHand.get(i);
            }
            System.out.println("My hand is " + sum);
            //Rules and actions
            String[][] actions ={
                    {"HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT"},
                    {"HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT"},
                    {"HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT"},
                    {"HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT"},
                    {"HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT","HIT"}
            };

        }
        public void  startTime() {
            time = System.currentTimeMillis();
        }

        public void stopTime(long startTime) {
            time = System.currentTimeMillis() - startTime;
        }

        public String[] getActions() {
            return actSeq.toArray(new String[actSeq.size()]);
        }
    }
    //Initialize an array to hold the agents in the environment.
    public String []agents = new String[2];
    public AgentProgram[] activeAgents = new AgentProgram[2];
    public ArrayList<Integer> dealerHand;
    public ArrayList<Integer> playerHand;
    public boolean isFinished = false;
    public int steps;
    public long time;
    //Move dealer and player initiation to own method.
    @Override
    public void setupENV() {
        dealerHand = new ArrayList<>(List.of(4, 10));
        playerHand = new ArrayList<>(List.of(10, 11));
        addAgents();
    }
    void init(){
        setupENV();
        startTime();
        activeAgents[0].simpleReflexAgent();
        stopTime(time);
        step(2);
        activeAgents[0].time = time;
    }
    public String determineWinner() {
        int dealer = 0;
        int player = 0;
        for (int i = 0; i < playerHand.size(); i++) {
            player += playerHand.get(i);
        }
        for (int i = 0; i < dealerHand.size(); i++) {
            dealer += dealerHand.get(i);
        }
        //case 1 the player and dealer tie.
        if (player == dealer) {
            return "Tie";
        }
        //case 2 the dealer has a natural and a player does not
        //case 3 a player busts
        //case 4 the dealer has a higher hand than a player and is under 21
        if (player > 21 || dealer == 21 || (dealer > player && dealer < 21)) {
            return "Dealer";
        }
        //case 1 Player has a natural and dealer does not.
        //case 5 a player has a higher hand than the dealer and is under 21
        //case 4 the dealer busts
        return "Player";
    }
    public int getCard(){
        return (int)  (Math.random() * 10 +1);
    }
    public long getTime(){
        return time;
    }
    public int getSteps(){
        return steps;
    }

    @Override
    public void  startTime() {
        time = System.currentTimeMillis();
    }

    @Override
    public void stopTime(long startTime) {
        time = System.currentTimeMillis() - startTime;
    }

    @Override
    public void addAgents() {
        agents[0] = "SimpleReflex";
       activeAgents[0] = new AgentProgram();
        agents[1] = "TableDriven";
        activeAgents[1] = new AgentProgram();
    }
    @Override
    public void removeAgent(String agentName) {
    for(int i = 0; i < agents.length; i++){
        if(Objects.equals(agents[i], agentName)){
            agents[i] = "";
            break;
            }
        }
    }
    public String[] getActions(){
        return activeAgents[0].getActions();
    }
    @Override
    public String[] getAgents() {
    return agents;
    }

    @Override
    public void step() {
        steps++;
    }

    @Override
    public void step(int n) {
        Environment.super.step(n);
    }

    @Override
    public void stepUntilFinish() {
        Environment.super.stepUntilFinish();
    }



    @Override
    public boolean isFinished() {
        return isFinished;
    }
}


