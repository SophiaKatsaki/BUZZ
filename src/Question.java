import java.util.ArrayList;
import java.util.Random;

public class Question extends QA {
    private static ArrayList<String> usedQuestions = new ArrayList<>();
    private String question;
    private int numberOfRandomQuestionInArray;

    public Question (){
    }

    public String getCategory () {
        return categories.get(numberOfCategory);
    }

    public String getRandomQuestion () {
        return this.question;
    }

    public int getNumberOfRandomQuestionInArray () {
        return this.numberOfRandomQuestionInArray;
    }

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

    public void setNumberOfRandomQuestionInArray () {
        this.numberOfRandomQuestionInArray = questions.indexOf(this.question);
    }
}