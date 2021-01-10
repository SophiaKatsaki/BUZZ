import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This abstract class represents a place that stores every important information for the questions and answers.
 * It has three ArrayLists for questions, possible answers and categories and the number of a category.
 * It has a constructor, useful for the creation of the collections.
 * It has two methods for handling the categories of the questions/ answers.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */

public abstract class QA {
    protected ArrayList<String> questions;
    protected ArrayList<String> possibleAnswers;
    protected ArrayList<String> categories;
    protected int numberOfCategory;


    /**
     * The constructor creates the ArrayLists of the categories, the questions and the possible answers.
     * Neither of them get initialized nor have elements.
     */

    public QA () {
        this.categories = new ArrayList<>();
        this.questions = new ArrayList<>();
        this.possibleAnswers = new ArrayList<>();
    }

    /**
     * This method will fill the ArrayList of the questions with some elements from the file "Questions.txt"
     * depending on the number of the category in Arraylist of categories.
     *
     * @param randomNumberOfCategory is the number of the category in its ArrayList.
     */

    public void makeQ (int randomNumberOfCategory) {
        this.numberOfCategory = randomNumberOfCategory;

        String currentCategory = categories.get(this.numberOfCategory);

        try (BufferedReader reader = new BufferedReader(new FileReader("src/Questions.txt"))) {
            String line;
            String category = categories.get(0);

            while ((line = reader.readLine()) != null) {
                if (!(line.contains("\""))) {
                    category = line;
                }

                if (category.equals(currentCategory) && !(line.equals(category))) {
                    this.questions.add(line);
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * This method will fill the ArrayList of the possible answers with some elements from the file "Answers.txt"
     * depending on the number of the category in ArrayList of categories.
     *
     * @param randomNumberOfCategory is the number of the category in its ArrayList.
     */

    public void makeA (int randomNumberOfCategory) {
        this.numberOfCategory = randomNumberOfCategory;

        String currentCategory = categories.get(this.numberOfCategory);

        try (BufferedReader reader = new BufferedReader(new FileReader("src/Answers.txt"))){
            String line;
            String category = categories.get(0);

            while ((line = reader.readLine()) != null) {
                if (!(line.contains("\""))) {
                    category = line;
                }

                if (category.equals(currentCategory) && !(line.equals(category))) {
                    this.possibleAnswers.add(line);
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}