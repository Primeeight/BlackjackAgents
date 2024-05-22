import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AgentProgramTests {
    BlackjackEnvironment bj = new BlackjackEnvironment();
    @Test
    public void Get_Actions(){
         bj.init();
         String[]results = {"NATURAL"};
         assertArrayEquals(bj.getActions(), results);
    }
}
