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
    protected ArrayList<String> categories;
    protected ArrayList<String> kinds;
    protected ArrayList<String> questions;
    protected ArrayList<String> answers;
    protected ArrayList<String> correctAnswers;

    /**
     * The constructor defines which are the questions, the answers (correct or possible), the categories of the
     * questions and the kinds of the rounds.
     *
     * The constructor also initializes the number of the rounds as 1.
     *
     * In general, the constructor creates the the key element of the game.
     */
    public Game () {
        this.numberOfRounds = 1;

        this.kinds = new ArrayList<>();
        this.kinds.add("Correct Answer");
        this.kinds.add("Bet");

        this.categories = new ArrayList<>();
        this.categories.add("Music");
        this.categories.add("Books");
        this.categories.add("TV Series/ Movies");
        this.categories.add("Travelling");

        this.questions = new ArrayList<>();
        this.questions.add("What is the mainstream genre of music?");
        this.questions.add("Which was the first book of John Verdon?");
        this.questions.add("How many season had the TV series \"LOST\"?");
        this.questions.add("Which country does not belong to europe?");

        this.answers = new ArrayList<>();
        this.answers.add("pop");
        this.answers.add("rock");
        this.answers.add("r&b");
        this.answers.add("soul");
        this.answers.add("Think of A Number");
        this.answers.add("Shut Your Eyes Tight");
        this.answers.add("Peter Pan Must Die");
        this.answers.add("Wolf Lake");
        this.answers.add("6");
        this.answers.add("5");
        this.answers.add("4");
        this.answers.add("7");
        this.answers.add("Australia");
        this.answers.add("Greece");
        this.answers.add("United Kingdom");
        this.answers.add("Sweden");

        this.correctAnswers = new ArrayList<>();
        this.correctAnswers.add("pop");
        this.correctAnswers.add("Think Of A Number");
        this.correctAnswers.add("6");
        this.correctAnswers.add("Australia");
    }

    /**
     * This method set the number of rounds that a game will have.
     * It has two possible ways to do this that varies from the parameter.
     * It will get the information from the user/player.
     * Or it will set this randomly.
     *
     * @param answer contains the decision of the user/ player to choose the number of rounds or to be set randomly.
     */
    public void setRounds (int answer) {
        if (answer == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("From 1 to 10.");
            System.out.println("How many rounds do you want to play?");
            do {
                this.numberOfRounds = scanner.nextInt();
                scanner.nextLine();
            } while (this.numberOfRounds < 1 || this.numberOfRounds > 10);
        }
        else {
            if (answer == 2) {
                Random rand = new Random();
                do {
                    this.numberOfRounds = rand.nextInt(11);
                } while (this.numberOfRounds == 0);
            }
        }
    }

    /**
     * @return statement gives back the information about the number of the rounds whenever it gets asked.
     */
    public int getRounds () {
        return this.numberOfRounds;
    }
}