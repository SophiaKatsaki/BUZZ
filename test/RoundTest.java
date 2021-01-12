import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void setRandomNumberOfQuestions() {
        List<Integer> howMany = List.of(2, 3, 4, 5, 6, 7, 8);
        Round round = new Round();
        assertTrue(howMany.contains(round.getRandomNumberOfQuestions()));
        System.out.println(round.getRandomNumberOfQuestions());

    }

    @Test
    public void setRandomKindOfRound() {
        ArrayList<String> kindOfRounds=new ArrayList<>();
        kindOfRounds.add("Correct Answer");
        kindOfRounds.add("Bet");
        kindOfRounds.add("Stop The Watcher");
        kindOfRounds.add("Quick Answer");
        kindOfRounds.add("Thermometer");
        Round round = new Round();
        round.makeMultiplayerRounds();
        assertTrue(kindOfRounds.contains(round.getKind()));
        System.out.println(round.getKind());

    }
}
