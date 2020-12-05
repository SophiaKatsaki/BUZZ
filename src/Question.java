import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a question of the game.It extends the abstract class 'QA',which produces the questions,
 * the answers and the categories of the questions.It has a String that represents the question itself that
 * the player sees,an integer that is the number of the String in the arraylist that holds the questions
 * made in 'QA' and an arraylist that keeps the questions that the player has answered as strings in order
 * not to appear in the same game twice.It returns the random categories that are chosen and gets and sets
 * random questions from the arraylist of questions in 'QA' and the number of their place in the arraylist.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */
public class Question extends QA {
    private static ArrayList<String> usedQuestions = new ArrayList<>();
    private String question;
    private int numberOfRandomQuestionInArray;


    /**
     * The constructor of the class Question just creates an object of the class Question.
    */

    public Question (){
    }


    /**
       This method gives the category of the question appeared on screen.

       @return String type of category
     */

    public String getCategory () {
        return categories.get(numberOfCategory);
    }


    /**
       This method returns the String of the question that the player sees.

       @return String the String of the question needed.
     */

    public String getRandomQuestion () {
        return this.question;
    }


    /**
     * This method returns the integer that represents the number of the random question chosen,in the
     * arraylist that holds the questions in the abstract class 'QA'
     *
     * @return int number of the question in the arraylist
     */

    public int getNumberOfRandomQuestionInArray () {
        return this.numberOfRandomQuestionInArray;
    }


    /**
     * This method chooses a random question from the arraylist in 'QA' and updates the arraylist
     * of the questions that are used, with the question that was chosen,in order not to use
     * the same question again in the same game.
     */

    public void setRandomQuestion () {
        makeQ(getNumberOfCategory());
        //setNumberOFCategory();

        Random rand = new Random();

        boolean isUsed;

        do {
            isUsed = false;
            this.question = questions.get(rand.nextInt(questions.size()));

            for (String searchingString : usedQuestions) {
                if (this.question.equals(searchingString)) {
                    isUsed = true;
                    break;
                }
            }
        } while (isUsed);

        usedQuestions.add(this.question);
    }


    /**
      This method
     */
    public void setNumberOfRandomQuestionInArray () {
        this.numberOfRandomQuestionInArray = questions.indexOf(this.question);
    }
}