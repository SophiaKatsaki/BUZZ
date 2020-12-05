import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class contains all the data that are important for a round.
 * It has the kind of the round, the total amount of the questions in a round, the number of the current question and
 * the points that may be used as a bet.
 *
 * It has a constructor, useful for the creation of an object of this class.
 * That constructor randomizes the number of the questions when the object gets created.
 * At the same time, it initializes the current question to number 1 (as the first question).
 * It also creates an ArrayList with the possible kinds of rounds.
 *
 * It has six methods.
 * One for handling the kind of the round.
 * Two for handling the number of questions.
 */
public class Round {
    protected ArrayList<String> kinds;
    protected String kind;
    protected int randomNumberOfQuestions;
    protected int currentNumberOfQuestion;
    protected int betPoints;

    /**
     * The constructor randomizes the number of questions.
     * It sets the total amount of questions randomly in the interval tow to eight.
     *
     * It is also calling the constructor of the mother class Game with the command super().
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