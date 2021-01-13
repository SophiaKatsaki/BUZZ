import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoundTest {

    public RoundTest() {
    }

    @Test
    public void Round()
    {
        Round round=new Round();
        assertEquals(1,round.getCurrentNumberOfQuestion());
        System.out.println("By default in: "+round.getCurrentNumberOfQuestion()+" question");
    }

    @Test
    public void currentQuestion() {
        Round round = new Round();
        assertEquals(1, round.getCurrentNumberOfQuestion());
        for (int i = 0; i < 7; i++) {
            round.setCurrentNumberOfQuestion();
        }
        assertEquals(8, round.getCurrentNumberOfQuestion());
    }

    @Test
    public void RandomNumberOfQuestions() {
        List<Integer> howMany = List.of(2, 3, 4, 5, 6, 7, 8);
        Round round = new Round();
        assertTrue(howMany.contains(round.getRandomNumberOfQuestions()));
        System.out.println(round.getRandomNumberOfQuestions());

    }

    @Test
    public void SoloAndMultiplayerRounds() {
        ArrayList<String> kindOfRounds = new ArrayList<>();
        kindOfRounds.add("Correct Answer");
        kindOfRounds.add("Bet");
        kindOfRounds.add("Stop The Watcher");
        kindOfRounds.add("Quick Answer");
        kindOfRounds.add("Thermometer");
        Round round = new Round();
        assertEquals(3, round.kinds.size());
        round.makeMultiplayerRounds();
        assertEquals(5, round.kinds.size());


    }

   @Test
    public void LastRound()
   {
       Round round=new Round();
       round.makeMultiplayerRounds();
       round.makeLastRound();
       assertEquals("Thermometer",round.getKind());

   }

}
