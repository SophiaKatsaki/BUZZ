import java.util.Random;
import java.util.Scanner;

/**
 * This class is base for the game and it contains all the data that are important for
 * that. It stores the amount of the players, the total amount of rounds and the number
 * of the current round that is being played. It has a constructor, useful for the
 * creation of an object of this class. It contains methods for setting the total amount
 * of rounds and for handling the current round and the number of the players.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */

public class Game {
    private int answer;
    private static int numberOfPlayers = 1;
    private int numberOfRounds;
    private int currentRound;

    /**
     * Constructor
     *
     * The constructor initializes the current round to number one, that is, the first
     * round.
     */

    public Game () {
        this.currentRound=1;
    }

    /**
     * This method sets the answer to number 1 or 2.
     *
     * @param answer is a number which must be 1 or 2 that will be used either for the
     *               creation of the rounds or for the number of the players. The use
     *               of the answer vary and it depends to when it is asked.
     *               If the answer is 1 then the player will choose how many rounds
     *               they want to play.It also represents the solo game.
     *               If the answer is 2 then the total amount of rounds will be
     *               created randomly. It also represents the game with a friend.
     */

    public void setAnswer (int answer) {
        this.answer = answer;
        Scanner scanner=new Scanner(System.in);
        //scanner.nextLine();
        while (this.answer!=1 && this.answer!=2) {
            this.answer=scanner.nextInt();
            scanner.nextLine();
        }
    }

    /**
     * This method sets the amount of the players in the current game.
     *
     * @param answer is the amount of players.
     */

    public void setNumberOfPlayers (int answer) {
        numberOfPlayers = answer;
    }

    /**
     * This method sets the number of rounds that a game will have.
     * It will get the information from the user/player and will save it in
     * a variable after it is being checked that it is between the right
     * interval.
     *
     * @param answer contains the decision of the user/ player for the total amount
     *               of the rounds.
     */

    public void setNumberOfRounds (int answer) {
        this.numberOfRounds = answer;
        Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();

        while (this.numberOfRounds < 1 || this.numberOfRounds > 10) {
            this.numberOfRounds = scanner.nextInt();
            scanner.nextLine();
        }
    }

    /**
     * This method sets the number of rounds that a game will have randomly in the
     * interval one to ten.
     */

    public void setRandomRounds () {
        Random rand = new Random();

        do {
            this.numberOfRounds = rand.nextInt(11);
        } while (this.numberOfRounds == 0);
    }

    /**
     * This method increases number of the round by one,everytime the round ends.
     */

    public void setCurrentRound () {
        this.currentRound++;
    }

    /**
     *
     * @return statement gives back the information about the number of the rounds
     * whenever it gets asked.
     */

    public int getNumberOfRounds () {
        return this.numberOfRounds;
    }

    /**
     *
     * @return statement gives back the amount of the players in the game.
     */
    public int getNumberOfPlayers () {
        return this.numberOfPlayers;
    }

    /**
     *
     * @return statement gives back the answer that the user gave.
     */

    public int getAnswer () {
        return this.answer;
    }

    /**
     *
     * @return statement gives back the information about the number of the current
     * round whenever it is asked.
     */

    public int getCurrentRound() {
        return this.currentRound;
    }
}