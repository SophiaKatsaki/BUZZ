import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a question of the game.It extends the abstract class 'QA',which produces the questions,
 * the answers and the categories of the questions.It has a String that represents the question itself that
 * the player sees,an integer that is the number of the String in the arraylist that holds the questions
 * made in 'QA',an arraylist that keeps the questions that the player has answered as strings and an array with
 * the number of used questions in order not to appear in the same game twice and an integer that represents
 * the category of the question.It returns the random categories that are chosen and gets and sets random
 * questions from the arraylist that holds all questions in 'QA' and the number of their place in the arraylist.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */


public class Question extends QA {
    private static ArrayList<String> usedQuestions = new ArrayList<>();
    private static int[] numberOfUsedQuestions = {0, 0, 0, 0};
    private String question;
    private int numberOfRandomQuestionInArray;
    private int randomNumberOfCategory;

    /**
     * Constructor
     *
     * The constructor of the class Question adds the categories of the questions of the
     * game to an arraylist and randomly selects a category for the question that is made
     * when the constructor is called,while a Question object is created.
     *
    */

    public Question (){
        this.categories.add("Music");
        this.categories.add("Books");
        this.categories.add("TV Series/ Movies");
        this.categories.add("Travelling");

        Random rand = new Random();
        this.randomNumberOfCategory = rand.nextInt(this.categories.size());
    }

    /**
     * @return number that corresponds to the category of the question that is chosen randomly.
     */

    public int getNumberOfCategory () {
        return this.randomNumberOfCategory;
    }

    /**
     * This method returns the category of the question appeared on screen,given the number
     * that corresponds to the category that is chosen.
     *
     * @return type of category.
     */

    public String getCategory () {
        return categories.get(this.randomNumberOfCategory);
    }

    /**
     *
     * @return the String of the question that the player sees.
     */

    public String getRandomQuestion () {
        return this.question;
    }

    /**
     * This method returns the integer that represents the number of the random question chosen in the
     * arraylist that holds the questions in the abstract class 'QA'.
     *
     * @return number of the question in the arraylist
     */

    public int getNumberOfRandomQuestionInArray () {
        return this.numberOfRandomQuestionInArray;
    }


    /**
     * This method chooses a random question from the arraylist in 'QA' and updates the arraylist
     * of the questions that are used, with the question that was chosen,in order not to use
     * the same question again in the same game,given the category that is chosen for the question.
     * It also changes the category if there are no other existing questions in the chosen category.
     */

    public void setRandomQuestion () {
        makeQ(this.randomNumberOfCategory);

        while (numberOfUsedQuestions[this.randomNumberOfCategory] > questions.size()) {
            Random rand = new Random();
            this.randomNumberOfCategory = rand.nextInt(this.categories.size());
        }
        numberOfUsedQuestions[this.randomNumberOfCategory]++;

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
     * This method sets the number of the question in the arraylist that holds all
     * the questions,chosen randomly.
     */

    public void setNumberOfRandomQuestionInArray () {
        this.numberOfRandomQuestionInArray = questions.indexOf(this.question);
    }
}