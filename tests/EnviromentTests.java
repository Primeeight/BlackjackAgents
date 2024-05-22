import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnviromentTests {
    BlackjackEnvironment bj = new BlackjackEnvironment();
@Test
public void Get_Agents(){
    bj.init();
    String[]agents = bj.getAgents();
    assertEquals("SimpleReflex",agents[0]);
}
    @Test
public void Get_Results(){
    bj.init();
    assertEquals("Player", bj.determineWinner());
}
    @Test
public void Get_Time(){
    bj.init();
    long superlong = 5000000;
    assertTrue(bj.getTime() < superlong);
}
    @Test
public void Get_Steps(){
    bj.init();
    assertEquals(2, bj.getSteps());
}
}
