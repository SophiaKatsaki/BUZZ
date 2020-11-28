import java.util.Scanner;

public class Player
{
    private String name;
    private int points;

    public Player(String name)
    {
        this.name = name;
        this.points = 0;
    }

    public String getName()
    {
        return this.name;
    }

    public int getPoints()
    {
        return this.points;
    }

    public void winPoints(int points)
    {
        this.points += points;
        System.out.printf("+ %d\n",points);
    }

    public void losePoints(int point)
    {
        this.points -= points;
        System.out.printf("- %d\n",points);
    }

    public void showPoints()
    {
        System.out.printf("You have: %d",this.points,"points \n");
    }

    //This might go to logic
    public int giveAnswer()
    {
        int answer;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Select an answer between 1 and 4\n");
        do
        {
            answer = scanner.nextInt();
            scanner.nextLine();
        }
        while ((answer!=1) && (answer!=2) && (answer!=3) && (answer!=4));
        return answer;

    }




}
