import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameTest {

    public GameTest(){}

    @Test
    public void numberOfPlayers () {
        Game game = new Game();
        game.setNumberOfPlayers(1);
        assertEquals(1, game.getNumberOfPlayers());
        game = new Game ();
        game.setNumberOfPlayers(2);
        assertEquals(2, game.getNumberOfPlayers());
        assertEquals(2, game.getNumberOfPlayers());
    }

    @Test
    public void numberOfRounds () {
        Game game = new Game();
        game.setNumberOfRounds(1);
        assertEquals(1, game.getNumberOfRounds());
        game = new Game();
        game.setNumberOfRounds(10);
        assertEquals(10, game.getNumberOfRounds());
    }

    @Test
    public void currentRound () {
        Game game = new Game();
        assertEquals(1, game.getCurrentRound());
        game.setCurrentRound();
        assertEquals(2, game.getCurrentRound());
        game = new Game();
        for (int i=0;i<9;i++){
            game.setCurrentRound();
        }
        assertEquals(10, game.getCurrentRound());
    }
}