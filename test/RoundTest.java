import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RoundTest {

    public RoundTest() {}

    @Test
    public void currentQuestion() {
        Round round = new Round();
        assertEquals(1, round.getCurrentNumberOfQuestion());
        for (int i=0;i<7;i++){
            round.setCurrentNumberOfQuestion();
        }
        assertEquals(8, round.getCurrentNumberOfQuestion());
    }
}
