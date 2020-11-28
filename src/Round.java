import java.util.Random;
import java.util.Scanner;

public class Round extends Game
{
    private int numberOfQuestions;
    private String kind;

    public Round (int numberOfRounds)
    {
        super(numberOfRounds);
        this.numberOfQuestions = 8;
    }

    public int hasNumberOfQuestions()
    {
        Random rand=new Random();
        //3-10
        do {
            this.numberOfQuestions=rand.nextInt(11);
        }
        while ((this.numberOfQuestions!=0) && (this.numberOfQuestions!=1) && (this.numberOfQuestions!=2));
        System.out.printf("Number of Questions of this rounds are: %d\n", this.numberOfQuestions);
        return this.numberOfQuestions;
    }

    public void showKind ()
    {
        System.out.printf("%s\n", this.kind);
    }

    public void showRound()
    {

    }


}