import java.util.Scanner;

public class Game
{
    private int numberOfRounds;

    public Game (int numberOfRounds)
    {
        this.numberOfRounds = numberOfRounds;
    }

    public int hasRounds (int numberOfRounds)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("How many rounds do you want to play?\n");
        this.numberOfRounds = scanner.nextInt();
        //scanner.nextLine();

        return this.numberOfRounds;
    }
}