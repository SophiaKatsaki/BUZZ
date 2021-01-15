import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents an answer to a question of the game. It extends the abstract
 * class 'QA. It stores a String that is the correct possible answer, a boolean that is
 * true if the answer that the player gave is correct and false if it is wrong and an
 * arraylist that holds the four possible answers of each question. The answer class is
 * responsible for setting and for showing the possible answers of the question to the
 * player and set the answer that the player gave as correct or wrong in order to calculate
 * the points that they deserve.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */

public class Answer extends QA {
    private String answer;
    private boolean correctAnswer;
    private ArrayList<String> fourPossibleAnswers;

    /**
     * Constructor
     *
     * The constructor of the class Answer adds the categories of the answers of the
     * game to an arraylist by using the method makeCategories of the abstract class QA
     * that this class extends. It also creates an arraylist of the four possible
     * answers to a question.
     */

    public Answer () {
        makeCategories();
        this.fourPossibleAnswers = new ArrayList<>();
    }

    /**
     * @return true if the answer is correct and false if it is not.
     */

    public boolean getCorrectAnswer () {
        return this.correctAnswer;
    }

    /**
     * This method checks if the answer that the player gave is equal to the correct
     * answer of the question that is held in an arraylist with all the possible
     * answers to this question. It sets the boolean to true or false whether if the
     * previous state was right or it was not.
     *
     * @param answerOfPlayer Answer from 1 to 4 (keys that the first player uses to
     *                       answer) or 6 to 9 (the keys of the second one) that the
     *                       player pressed.
     * @param numberOfRandomQuestionInArray the number of the question chosen randomly,
     *                                      in the arraylist that holds all the
     *                                      questions.
     */

    public void setCorrectAnswer (int answerOfPlayer, int numberOfRandomQuestionInArray) {
        this.answer = this.possibleAnswers.get(numberOfRandomQuestionInArray*4);

        if (answerOfPlayer >= 6) {
            answerOfPlayer -= 5;
        }

        this.correctAnswer = this.fourPossibleAnswers.get(answerOfPlayer - 1).equals(this.answer);
    }

    /**
     * This method sets the four possible answers to a question in the arraylist and
     * then it shuffles them in order to appear in a random order everytime the
     * question is used.
     *
     * @param numberOfQuestionInArray the number of the question chosen in the arraylist
     *                                in 'QA' that holds the questions of the game.
     * @param randomNumberOfCategory the number that corresponds to the number of the
     *                               category of the random question that is chosen.
     */

    public void setFourPossibleAnswers (int numberOfQuestionInArray, int randomNumberOfCategory) {
        makeA(randomNumberOfCategory);

        for (int i=numberOfQuestionInArray*4;i<numberOfQuestionInArray*4+4;i++) {
            this.fourPossibleAnswers.add(possibleAnswers.get(i));
        }

        Collections.shuffle(this.fourPossibleAnswers);
    }

    /**
     * This method shows the answers to a question that is chosen randomly in random
     * order everytime on screen. It is used when the game is played without graphical
     * interface.
     *
     * @param number is the number of each player that been used in order to show the
     *               keys that they can use.
     */

    public void showAnswers (int number) {
        number = (number-1)*5;

        for (int i=0;i<4;i++) {

            this.answer=this.fourPossibleAnswers.get(i);

            System.out.printf("%d)", number+1);
            System.out.print(" ");
            System.out.printf("%s", this.answer);
            System.out.println();

            number++;
        }
    }

    /**
     * @return the shuffled four possible answers to a question.
     */

    public ArrayList<String> getFourPossibleAnswers()
    {
        return this.fourPossibleAnswers;
    }
}