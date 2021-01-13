import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    public GameTest(){}

    @Test
    public void Game()
    {
        Game game=new Game();
        assertEquals(1,game.getCurrentRound());
        System.out.println("By default we are in the: "+game.getCurrentRound()+" round");

    }

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

    @Test
    public void RandomNumberOfRounds() {
        List<Integer> howMany = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Game game = new Game();
        game.setRandomRounds();
        assertTrue(howMany.contains(game.getNumberOfRounds()));
        System.out.println(game.getNumberOfRounds());
    }

    @Test
    public void Answer()
    {
        Game game=new Game();
        Game game2=new Game();
        game.setAnswer(1);
        game2.setAnswer(2);
        assertEquals(1,game.getAnswer());
        assertEquals(2,game2.getAnswer());
    }
}