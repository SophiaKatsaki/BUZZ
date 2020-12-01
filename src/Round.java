import java.util.Random;

/**
 * This class is subclass of the class Game.
 * It has all the important information of the mother class Game such as the questions and their categories.
 *
 * This class has also the number of the questions and the kind of the round.
 *
 * It contains a constructor that calls the constructor of the mother class Game and at the same time it initializes the
 * number of the questions to 8 by default when the object gets created.
 *
 * It has four methods.
 * Two for handling the kind of the round.
 * Two for handling the number of questions.
 */
public class Round extends Game {
    private int numberOfQuestions;
    private String kind;

    /**
     * The constructor initializes the number of questions to 8.
     *
     * It is also calling the constructor of the mother class Game with the command super().
     */
    public Round () {
        super();
        this.numberOfQuestions = 8;
    }

    /**
     * This method set the kind of the current round randomly.
     */
    public void setKind () {
        Random rand = new Random();
        int randInt;

        randInt = rand.nextInt(2);

        this.kind = kinds.get(randInt);
    }

    /**
     * @return the information of the kind of the current round whenever it is asked.
     */
    public String getKind() {
        return this.kind;
    }

    /**
     * @return the information of the number of the questions of the current round whenever it is asked.
     */
    public int getNumberOfQuestions () {
        return this.numberOfQuestions;
    }

    /**
     * This method changes the number of questions that the current round contains randomly.
     */
    public void hasNumberOfQuestions() {
        Random rand = new Random();

        do {
            this.numberOfQuestions = rand.nextInt(11);
        } while ((this.numberOfQuestions == 0) || (this.numberOfQuestions == 1) || (this.numberOfQuestions == 2));
    }
}