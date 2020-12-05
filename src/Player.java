import java.util.Scanner;

/**
 * This class represents a player,playing the game.
 * It stores the name of the player, their points and their answers.It changes and returns the points the player has,
 * when needed.
 * It also stores the number of the answer that the player gives when they are asked a question.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */


public class Player {
    private String name;
    private int points;
    private int numberOfAnswer;


    /**
     * Constructor
     *
     * The constructor initializes the points of the player in the value 0 by default.
     * It also initializes the name of the player with the name they give when they are asked.
     *
     * @param name Contains the name of the player.
     */

    public Player(String name)
    {
        this.name = name;
        this.points = 0;
    }


    /**
     * This method set the answer of the player by questioning them what that answer is.
     *
     * @param answer A number from 1 to 4 of the answer the player chooses.
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
     *
     * @return The name of the player when is needed in the game.
     */

    public String getName()
    {
        return this.name;
    }


    /**
     *
     * @return The information of the points that the player has at a certain moment whenever it is asked.
     */

    public int getPoints()
    {
        return this.points;
    }


    /**
     *
     * @return The number of the answer the player gives.
    */

    public int getNumberOfAnswer()
    {
        return this.numberOfAnswer;
    }


    /**
     * This method changes the points of the player positively by the points the parameter says when they answer
     * correctly in a question.
     *
     * @param points Are the points that the player wins.
     */

    public void winPoints(int points)
    {
        this.points += points;
    }


    /**
     *  This method changes the points of the player negatively by the points the parameter says when
     *  the answer that they give is wrong.
     *
     *  @param points Are the points that the player loses.
     */

    public void losePoints(int points) {
        this.points -= points;
        if (this.points < 0){
            this.points = 0;
        }
    }
}