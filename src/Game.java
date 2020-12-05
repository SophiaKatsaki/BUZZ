import java.util.Random;
import java.util.Scanner;

/**
 * This class is base for the game and it contains all the data that are important for that.
 * It stores the total amount of rounds and the number of the current round that is being played.
 * It has a constructor, useful for the creation of an object of this class.
 * It contains five methods for handling the total amount of rounds and for handling the current round.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */


public class Game {
    private int numberOfRounds;
    private int currentRound;


    /**
     * Constructor
     *
     * The constructor initializes the current round to number one, that is, the first round.
     *
     * @param answer is a number which must be 1 or 2 that will be used for the creation of the rounds.
     *               If it is 1 then the player will choose how many rounds they will play.
     *               If it is 2 then the total amount of rounds will be created randomly.
     */

    public Game (int answer) {
        this.numberOfRounds = answer;
        Scanner scanner=new Scanner(System.in);
        //scanner.nextLine();
        while (this.numberOfRounds!=1 && this.numberOfRounds!=2) {
            this.numberOfRounds=scanner.nextInt();
            scanner.nextLine();
        }

        this.currentRound=1;
    }


    /**
     * This method sets the number of rounds that a game will have.
     * It will get the information from the user/player and will saves it in a variable after it is being checked that
     * it is between the right interval.
     *
     * @param answer contains the decision of the user/ player for the total amount of the rounds.
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
     * This method sets the number of rounds that a game will have randomly in the interval one to ten.
     */
    public void setRandomRounds () {
        Random rand = new Random();

        do {
            this.numberOfRounds = rand.nextInt(11);
        } while (this.numberOfRounds == 0);
    }


    /**
     * This method set the current round to the next one when the round ends.
     */

    public void setCurrentRound () { this.currentRound++; }


    /**
     * @return statement gives back the information about the number of the rounds whenever it gets asked.
     */

    public int getNumberOfRounds () {
        return this.numberOfRounds;
    }


    /**
     * @return statement gives back the information about the number of the current round whenever it gets asked.
     */

    public int getCurrentRound() { return this.currentRound; }
}