import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class contains all the data that are important for the game.
 * For that reason, it is mother class for some other classes.
 *
 * It has the number of rounds that will be played, all the different kinds of rounds, all the questions and the answers
 * (correct or possible) and all their categories.
 *
 * It has a constructor, useful for the creation of an object of this class.
 *
 * It contains two methods for the number of rounds.
 */

public class Game {
    private int numberOfRounds;
    private int currentRound;

    /**
     * The constructor defines which are the questions, the answers (correct or possible), the categories of the
     * questions and the kinds of the rounds.
     *
     * The constructor also initializes the number of the rounds as 1.
     *
     * In general, the constructor creates the the key element of the game.
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
     * This method set the number of rounds that a game will have.
     * It has two possible ways to do this that varies from the parameter.
     * It will get the information from the user/player.
     * Or it will set this randomly.
     *
     * @param answer contains the decision of the user/ player to choose the number of rounds or to be set randomly.
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

    public void setRandomRounds () {
        Random rand = new Random();
        do {
            this.numberOfRounds = rand.nextInt(11);
        } while (this.numberOfRounds == 0);
    }

    public void setCurrentRound () {
        this.currentRound++;
    }

    /**
     * @return statement gives back the information about the number of the rounds whenever it gets asked.
     */
    public int getNumberOfRounds () {
        return this.numberOfRounds;
    }

    public int getCurrentRound()
    {
        return this.currentRound;
    }
}