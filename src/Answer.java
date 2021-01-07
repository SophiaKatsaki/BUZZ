import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents an answer to a question of the game.It extends the abstract class 'QA'.It stores
 * a String that is the correct possible answer,a boolean that is true if the answer the player gave is
 * correct and false if it is wrong and an arraylist that holds the four possible answers of each question.
 * The answer class is responsible for setting and for showing the possible answers of the question to the
 * player and set the answer the player gave as correct or wrong in order to calculate the points that they
 * deserve.
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
     * The constructor creates an arraylist of the four possible answers to a question.
    */

    public Answer () {
        this.fourPossibleAnswers = new ArrayList<>();
    }


    /**
     * @return if the answer is correct
     */

    public boolean getCorrectAnswer () {
        return this.correctAnswer;
    }


    /**
     * This method checks if the answer that the player gave is equal to the correct answer
     * of the question that is held in an arraylist with all the possible answers.
     *
     * @param answerOfPlayer Answer from 1 to 4 (or 6 to 9) that the player pressed.
     *
     * @param numberOfRandomQuestionInArray the number of the question chosen randomly,in the arraylist
     *                                     that holds all the questions
     */

    public void setCorrectAnswer (int answerOfPlayer, int numberOfRandomQuestionInArray) {
        this.answer = this.possibleAnswers.get(numberOfRandomQuestionInArray*4);

        if (answerOfPlayer >= 6) {
            answerOfPlayer -= 5;
        }

        if(this.fourPossibleAnswers.get(answerOfPlayer-1).equals(this.answer))
        {
            this.correctAnswer=true;
        }
        else
        {
            this.correctAnswer=false;
        }
    }

    /**
     * This method sets the four possible answers in the arraylist and then it puts them in a random
     * position.
     *
     * @param numberOfQuestionInArray the number of the question chosen in the arraylist in 'QA'
     *                                that holds the questions of the game.
     * @param randomNumberOfCategory the number that corresponds to the number of the category
     *                               of the random question that is chosen.
     */

    public void setFourPossibleAnswers (int numberOfQuestionInArray, int randomNumberOfCategory) {
        makeA(randomNumberOfCategory);

        for (int i=numberOfQuestionInArray*4;i<numberOfQuestionInArray*4+4;i++) {
            this.fourPossibleAnswers.add(possibleAnswers.get(i));
        }

        Collections.shuffle(this.fourPossibleAnswers);
    }

    /**
     * This method shows the answers to a question that is chosen randomly in random order everytime
     * on screen.
     *
     * @param number is the number of each player that been used in order to show the keys that they
     *               can use.
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
}