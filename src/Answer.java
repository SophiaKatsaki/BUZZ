import java.util.ArrayList;
import java.util.Collections;

public class Answer extends QA {
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

        if(this.fourPossibleAnswers.get(answerOfPlayer-1).equals(this.possibleAnswers.get(numberOfRandomQuestionInArray*4)))
        {
            this.correctAnswer=true;
        }
        else
        {
            this.correctAnswer=false;
        }
    }


    public void showAnswers (int numberOfQuestionInArray) {
        makeA(getNumberOfCategory());

        for (int i=numberOfQuestionInArray*4;i<numberOfQuestionInArray*4
                +4;i++) {
            this.fourPossibleAnswers.add(possibleAnswers.get(i));
        }
        Collections.shuffle(this.fourPossibleAnswers);
        int counter=0;
        for (String s:this.fourPossibleAnswers) {

            this.answer=this.fourPossibleAnswers.get(counter);
            counter++;
            System.out.printf("%d)", counter);
            System.out.print(" ");
            System.out.printf("%s", this.answer);
            System.out.println();
        }
    }

}
