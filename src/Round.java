import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class represents a round and it contains all the data that are important for its.
 * It has the kind of the round, the total amount of the questions in a round, the number of the current question and
 * the points that may be used as a bet.
 * It has a constructor, useful for the creation of an object of this class.
 * It has six methods for handling the kind of the round and for handling the number of questions.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */
public class Round {
    protected ArrayList<String> kinds;
    protected String kind;
    protected int randomNumberOfQuestions;
    protected int currentNumberOfQuestion;
    protected int betPoints;

    /**
     * Constructor
     *
     * The constructor randomizes the number of questions.
     * It sets the total amount of questions randomly in the interval two to eight.
     */
    public Round () {
        this.kinds = new ArrayList<>();
        this.kinds.add("Correct Answer");
        this.kinds.add("Bet");

        Random rand = new Random();
        int randInt;
        randInt = rand.nextInt(this.kinds.size());
        this.kind = kinds.get(randInt);

        do {
            this.randomNumberOfQuestions = rand.nextInt(9);
        } while ((this.randomNumberOfQuestions == 0) || (this.randomNumberOfQuestions == 1));

        this.currentNumberOfQuestion = 1;
    }

    /**
     * This method set the current question to the next one when the question ends.
     */
    public void setCurrentNumberOfQuestion () {
        this.currentNumberOfQuestion++;
    }

    /**
     * This method set the number of the points that the user/ player may bet in the "Bet" kind of round and it checks
     * if the parameter is between the correct bet points.
     *
     * @param answer contains the points that the user/ player decided to bet in the "Bet" kind of round.
     */
    public void setBetPoints (int answer) {
        Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();

        while (answer != 250 && answer != 500 && answer != 750 && answer != 1000) {
            answer = scanner.nextInt();
            //scanner.nextLine();
        }

        this.betPoints = answer;
    }

    /**
     * @return statement gives back the information of the kind of the current round whenever it is asked.
     */
    public String getKind() {
        return this.kind;
    }

    /**
     * @return statement gives back the total amount of questions in a round whenever it is asked.
     */
    public int getRandomNumberOfQuestions () {
        return this.randomNumberOfQuestions;
    }

    /**
     * @return statement gives back the number of the current question whenever it is asked.
     */
    public int getCurrentNumberOfQuestion () {
        return this.currentNumberOfQuestion;
    }

    /**
     * @return statement gives back the points that the user/ player may bet in the "Bet" kind of round whenever it is
     * asked.
     */
    public int getBetPoints () {
        return this.betPoints;
    }
}