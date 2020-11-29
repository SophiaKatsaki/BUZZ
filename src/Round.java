import java.util.Random;
import java.util.Scanner;

public class Round extends Game {
    private int numberOfQuestions;
    private String kind;
    private static int i;

    public Round (int numberOfRounds, String kind) {
        super(numberOfRounds, kind);

        this.numberOfQuestions = 8;
    }

    public String getKind () {
        Random rand = new Random();
        int randInt;

        do {
            randInt = rand.nextInt(3);
        } while (randInt == 0);

        this.kind = kinds.get(randInt);

        return this.kind;
    }

    public int hasNumberOfQuestions() {
        Random rand = new Random();

        do {
            this.numberOfQuestions = rand.nextInt(11);
        } while ((this.numberOfQuestions == 0) || (this.numberOfQuestions == 1) || (this.numberOfQuestions == 2));

        return this.numberOfQuestions;
    }

    public void showRound(int i, int numberOfRounds) {
        if (i == numberOfRounds) {
            System.out.printf("Round %d", i);
            System.out.println("Last Round");
        }
        else {
            System.out.println(this.i);
            i++;
        }
    }
}