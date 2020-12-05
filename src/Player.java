import java.util.Scanner;

/**
 * This class contains the data that the player will need.
 *
 * It has the name of the player, their points and their answers.
 *
 * It has a constructor that will create an object of this class and by default will have it named and with 0 points.
 *
 * It has six methods.
 * One for the handling of the name.
 * Two for the handling of the answers of the player.
 * Three for the handling of the points of the player.
 */
public class Player {
    private String name;
    private int points;
    private int numberOfAnswer;

    /**
     * The constructor initializes the points of the player in the value 0.
     *
     * The constructor also initializes the name of the player with the name that get from the parameter.
     *
     * @param name contains the name of the player and it is given when the object gets created.
     */
    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    /**
     * @return the information of the name of the player whenever it is asked.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return the information of the points that the player has whenever it is asked.
     */
    public int getPoints()
    {
        return this.points;
    }

    public int getNumberOfAnswer()
    {
        return this.numberOfAnswer;
    }

    /**
     * This method set the answer of the player by questioning them what that answer is.
     */
    public void setNumberOfAnswer(int answer) {
        Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();

        while ((answer != 1) && (answer != 2) && (answer != 3) && (answer != 4))
        {
            answer=scanner.nextInt();
            //scanner.nextLine();
        }

        this.numberOfAnswer=answer;
    }

    /**
     * This method change the points of the player positively by the points the parameter says.
     *
     * @param points are the points that the player deserves.
     */
    public void winPoints(int points) {
        this.points += points;
    }

    /**
     *  This method change the points of the player negatively by the points the parameter says.
     *
     *  @param points are the points that the player deserves.
     */
    public void losePoints(int points) {
        this.points -= points;
        if (this.points < 0){
            this.points = 0;
        }
    }
}