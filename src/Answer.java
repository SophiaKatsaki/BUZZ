import java.util.ArrayList;

public class Answer extends Question {
    private String answer;
    private boolean correctAnswer;
    private ArrayList<String> fourPossibleAnswers;

    public Answer () {
        this.fourPossibleAnswers = new ArrayList<>();
    }

    public boolean getCorrectAnswer () {
        return this.correctAnswer;
    }

    public void setCorrectAnswer (int answerOfPlayer, int numberOfRandomQuestionInArray) {
        this.answer = possibleAnswers.get(numberOfRandomQuestionInArray*4);

        if (this.answer.equals(this.fourPossibleAnswers.get(answerOfPlayer-1))) {
            this.correctAnswer = true;
        }
        else {
            this.correctAnswer = false;
        }
    }

    public void showAnswers (int numberOfQuestionInArray) {
        for (int i=numberOfQuestionInArray*4;i<numberOfQuestionInArray*4
                +4;i++) {
            this.fourPossibleAnswers.add(possibleAnswers.get(i));
        }

        for (int i=0;i<4;i++) {

            this.answer = this.fourPossibleAnswers.get(i);

            System.out.printf("%d)", i+1);
            System.out.print(" ");
            System.out.printf("%s", this.answer);
            System.out.println();
        }
    }
}
