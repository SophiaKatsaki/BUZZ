import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a round and it contains all the data that are important for its. It has the
 * kind of the round, the total amount of the questions in a round and the number of the current question.
 * It has a constructor, useful for the creation of an object of this class. It has four methods for
 * handling the kind of the round and for handling the number of questions.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */
public class Round {
    protected ArrayList<String> kinds;
    protected String kind;
    protected int randomNumberOfQuestions;
    protected int currentNumberOfQuestion;

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
        this.kinds.add("Stop The Timer");
        this.kinds.add("Quick Answer");
        this.kinds.add("Thermometer");

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
}