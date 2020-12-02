import java.util.ArrayList;
import java.util.Random;

public class Question extends Game {
    private String question;
    private int numberOfQuestion;
    private String category;
    protected ArrayList<String> usedQuestions;

    public Question (int answer) {
        super(answer);

        usedQuestions = new ArrayList<>();
    }

    public String getQuestion () {
        return question;
    }

    public String getCategory () {
        return category;
    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setQuestion() {
        //int size;
        //int randInt;
        Random rand = new Random();

        /*categories.indexOf(category);
        size = questions.size()/categories.size();
        randInt = rand.nextInt(size);

        for (int i=size*categories.indexOf(category);i<1+size;i++) {
            if (randInt == i) {
                question = questions.get(randInt);

                for (String searchingString: usedQuestions) {
                    if (question.equals(searchingString)){
                        question = questions.get(rand.nextInt(questions.size()));
                    }
                }
            }
        }*/

        question = questions.get(rand.nextInt(questions.size()));

        for (String searchingString: usedQuestions) {
            if (question.equals(searchingString)){
                question = questions.get(rand.nextInt(questions.size()));
            }
        }

        usedQuestions.add(question);
    }

    public void setCategory() {
        Random rand = new Random();
        category = categories.get(rand.nextInt(categories.size()));
    }

    public void setNumberOfQuestion(){
        numberOfQuestion = questions.indexOf(question);
    }
}