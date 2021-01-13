import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PlayerTest {

    public PlayerTest(){}

    @Test public void Player()
    {
        Player player=new Player(1);
        assertEquals(0,player.getPoints());
        System.out.println("By default: "+player.getPoints()+" points");

    }
    @Test
    public void name () {
        Player player = new Player(1);
        player.setName("Player");
        assertEquals("Player", player.getName());
        player = new Player(2);
        player.setName("1Player2");
        assertEquals("Player", player.getName());
        player = new Player(2);
        player.setName("!? /&");
        assertEquals("!?/&", player.getName());
    }

    @Test
    public void answer() {
        Player player = new Player(1);
        player.setNumberOfAnswer(1);
        assertEquals(1, player.getNumberOfAnswer());
        player = new Player(2);
        player.setNumberOfAnswer(9);
        assertEquals(9, player.getNumberOfAnswer());
    }

    @Test
    public void points() {
        Player player = new Player(1);
        player.setBetPoints(500);
        player.winPoints(player.getBetPoints());
        player.setBetPoints(750);
        player.winPoints(player.getBetPoints());
        player.setBetPoints(250);
        player.losePoints(player.getBetPoints());
        assertEquals(1000, player.getPoints());
        player = new Player(2);
        player.setBetPoints(250);
        player.winPoints(player.getBetPoints());
        player.setBetPoints(1000);
        player.losePoints(player.getBetPoints());
        assertEquals(0, player.getPoints());
    }

    @Test
    public void zeroCorrectAnswers()
    {
        Player player=new Player(1);
        player.initializeCorrectAnswersOfRound();
        assertEquals(0,player.getCorrectAnswers());
    }

    @Test
    public void CorrectAnswers()
    {
        Player player=new Player(1);
        player.initializeCorrectAnswersOfRound();
        player.increaseCorrectAnswers();
        assertEquals(1,player.getCorrectAnswers());
    }

    @Test
    public void CorrectAnswersBackAtZero()
    {
        Player player=new Player(1);
        player.initializeCorrectAnswersOfRound();
        player.increaseCorrectAnswers();
        player.increaseCorrectAnswers();
        player.increaseCorrectAnswers();
        player.increaseCorrectAnswers();
        player.increaseCorrectAnswers();
        player.initializeCorrectAnswersOfRound();
        assertEquals(0,player.getCorrectAnswers());
    }


    @Test
    public void uniqueNumberOfPlayerOne()
    {
        Player player=new Player(1);
        assertEquals(1, player.getPlayerNumber());
    }

    @Test
    public void uniqueNumberOfTheTwoPlayers()
    {
        Player player1=new Player(1);
        Player player2=new Player(2);
        assertEquals(1,player1.getPlayerNumber());
        assertEquals(2,player2.getPlayerNumber());
    }
}
