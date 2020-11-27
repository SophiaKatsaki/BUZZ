import java.util.Scanner;

public class Round
{
    private int numberOfQuestions;
    private int points;
    private String kind;

    public Round (int numberOfQuestions, String kind, int points)
    {
        this.numberOfQuestions = numberOfQuestions;
        this.kind = kind;
        this.points = points;
    }

    public int GetPoints()
    {
        return points;
    }

    public int hasQuestions (int numberOfQuestions)
    {
        this.numberOfQuestions = 8;
        System.out.printf("Number of Questions iof this rounds are: %d\n", this.numberOfQuestions);

        return this.numberOfQuestions;
    }

    public void isKind ()
    {
        System.out.printf("%s\n", this.kind);
    }

    public void showPoint ()
    {
        System.out.printf("%d\n", this.points);
    }
}