import java.util.Scanner;

/**
 * This class represents a player, playing the game. It stores the number of the player, their name,
 * their points, their answers and the points they bet in the proper round. It changes and returns
 * the points the player has, when needed. It also stores the number of the answer that the player
 * gives when they are asked a question.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */


public class Player {
    private int playerNumber;
    private String name;
    private int points;
    private int numberOfAnswer;
    private int betPoints;

    /**
     * Constructor
     *
     * The constructor initializes the points of the player in the value 0 by default.
     * It also initializes the number of the player with the number they take in the start of
     * the game.
     *
     * @param playerNumber Contains the number of the player which will represent the keys that
     *                     they can use.
     */

    public Player(int playerNumber){
        this.playerNumber = playerNumber;
        this.points = 0;
    }

    /**
     * This method sets the name of each player, when they asked.
     *
     * @param name is the name of the player.
     */
    public void setName (String name) {
        this.name = name;
    }

    /**
     * This method set the answer of the player by questioning them what that answer is.
     *
     * @param answer A number from 1 to 4 (or 6 to 9) of the answer the player chooses.
     */

    public void setNumberOfAnswer(int answer) {
        Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();

        if (this.playerNumber == 1) {
            while ((answer != 1) && (answer != 2) && (answer != 3) && (answer != 4)) {
                answer = scanner.nextInt();
                //scanner.nextLine();
            }
        }
        else {
            while ((answer != 6) && (answer != 7) && (answer != 8) && (answer != 9)) {
                answer = scanner.nextInt();
                //scanner.nextLine();
            }
        }

        this.numberOfAnswer = answer;
    }

    /**
     * This method set the number of the points that the user/ player may bet in the "Bet" kind of round and it checks
     * if the parameter is between the correct bet points.
     *
     * @param answer contains the points that the user/ player decided to bet in the "Bet" kind of round.
     */

    public void setBetPoints (int answer) {
        Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();

        while (answer != 250 && answer != 500 && answer != 750 && answer != 1000) {
            answer = scanner.nextInt();
            //scanner.nextLine();
        }

        this.betPoints = answer;
    }

    /**
     *
     * @return The number of the player when is needed in the game.
     */

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    /**
     *
     * @return The name of the player when is needed in the game.
     */

    public String getName() {
        return this.name;
    }

    /**
     *
     * @return The information of the points that the player has at a certain moment whenever it is asked.
     */

    public int getPoints() {
        return this.points;
    }

    /**
     *
     * @return The number of the answer the player gives.
    */

    public int getNumberOfAnswer() {
        return this.numberOfAnswer;
    }

    /**
     * @return statement gives back the points that the user/ player may bet in the "Bet" kind of round whenever it is
     * asked.
     */
    public int getBetPoints () {
        return this.betPoints;
    }

    /**
     * This method changes the points of the player positively by the points the parameter says when they answer
     * correctly in a question.
     *
     * @param points Are the points that the player wins.
     */

    public void winPoints(int points) {
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