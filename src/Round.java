import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
public class Round {
    protected ArrayList<String> kinds;
    protected String kind;
    protected int randomNumberOfQuestions;
    protected int currentNumberOfQuestion;
    protected int betPoints;

    /**
     * The constructor initializes the number of questions to 8.
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
     * @return the information of the kind of the current round whenever it is asked.
     */
    public String getKind() {
        return this.kind;
    }

    public int getRandomNumberOfQuestions () {
        return this.randomNumberOfQuestions;
    }

    public int getCurrentNumberOfQuestion () {
        return this.currentNumberOfQuestion;
    }

    public int getBetPoints () {
        return this.betPoints;
    }

    public void setCurrentNumberOfQuestion () {
        this.currentNumberOfQuestion++;
    }

    public void setBetPoints (int answer) {
        Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();

        while (answer != 250 && answer != 500 && answer != 750 && answer != 1000) {
            answer = scanner.nextInt();
            scanner.nextLine();
        }

        this.betPoints = answer;
    }
}