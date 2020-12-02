/**
 * This class is a subclass of the mother class Game.
 * It has all the important information of the mother class Game such as the answers (correct or possible).
 *
 * It has a constructor that calls the constructor of the mother class.
 *
 * It has three methods.
 * Two for handling the answers in general and one for handling the correct answers specifically.
 */
public class Answer extends Game {
    private String answer;

    /**
     * The The constructor calls the constructor of the mother class Game with the command super().
     */
    public Answer (int answer) {
        super(answer);
    }

    /**
     * @param i is the number of question that was chosen randomly.
     * @return the information of the correct answer to the question whenever it is asked.
     */
    public String getCorrectAnswer (int i) {
        answer = correctAnswers.get(i);

        return this.answer;
    }

    /**
     * @param i is the number of the question that was chosen randomly.
     * @param j is the number of the possible answer that the user/ player gave.
     * @return the answer that corresponds to the number of the answer that user/ player gave.
     */
    public String getAnswer (int i, int j) {
        int counter=0;
        int k;

        for (k=i*4;k<i*4+4;k++){
            if (counter == j){
                answer = answers.get(j);
                break;
            }
            counter++;
        }

        return this.answer;
    }

    /**
     * This method shows the four possible answers to one random question as indicated by the parameter.
     * @param i is the number of the question that was chosen randomly.
     */
    public void showAnswers (int i) {
        int j=1;
        int k;

        for (k=i*4;k<i*4+4;k++) {
            this.answer = answers.get (k);
            System.out.printf("%d)", j);
            System.out.print(" ");
            System.out.printf("%s", this.answer);
            System.out.println();
            j++;
        }
    }
}