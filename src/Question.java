import java.util.ArrayList;
import java.util.Random;

public class Question extends QA {
    private static ArrayList<String> usedQuestions = new ArrayList<>();
    private String question;
    private int numberOfRandomQuestionInArray;

    public Question (){
        makeQA();
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
       /* Random rand = new Random();
        this.question = questions.get(rand.nextInt(questions.size()));
        for (String searchingString: usedQuestions) {
            if (this.question.equals(searchingString)){
                this.question = questions.get(rand.nextInt(questions.size()));
            }
        }
        usedQuestions.add(this.question);
        */
        Random rand = new Random();
        int counter;
        do{
            counter=0;
            this.question = questions.get(rand.nextInt(questions.size()));
            for (String searchingString: usedQuestions) {
                if (this.question.equals(searchingString)) {
                    counter++;
                }
            }
        }while (counter>0);
        usedQuestions.add(this.question);
    }

    public void setNumberOfRandomQuestionInArray () {
        this.numberOfRandomQuestionInArray = questions.indexOf(this.question);
    }
}