import java.util.ArrayList;
import java.util.Random;

public class Question extends Game {
    private int numberOfQuestions;

    public Question (String categories, String kinds, String questions, String answers, String correctAnswers) {
        super(categories, questions, answers, correctAnswers);
    }

    public void showQuestion () {
        Random rand = new Random();

        System.out.println(questions.get(rand.nextInt(questions.size())));
    }

    public int getQuestion () {
        return numberOfQuestions;
    }

    public void showNumberOfQuestion () {
        System.out.println("Question");
    }
}