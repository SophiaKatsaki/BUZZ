import java.util.ArrayList;

public class Answer extends Game {
    private String answer;

    public Answer (String categories, String kinds, String questions, String answers, String correctAnswers) {
        super(categories, questions, answers, correctAnswers);
    }

    public String getCorrectAnswer (int i) {
        answer = correctAnswers.get(i);

        return this.answer;
    }

    public void showAnswers (int i) {
        int j=1;
        for (;i<i+4;i++) {
            System.out.printf("%d)\n", j);
            j++;

            this.answer = answers.get (i);
        }
    }
}