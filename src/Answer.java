public class Answer extends Game {
    private String answer;
    public Answer (String categories, String kinds, String questions, String answers, String correctAnswers) {
        super(categories, kinds, questions, answers, correctAnswers);
    }

    public void showAnswer () {
        int i;

        for (i=0;i<4;i++) {
            System.out.println(i);
            System.out.println(this.answer);
        }
    }

    public void showCorrectAnswer () {
        System.out.println(this.answer);
    }
}