import java.util.Scanner;

/**
 * This class represents a player, playing the game. It stores the number of the
 * player, their name,their points, their answers and the points they bet in the
 * proper round. It changes and returns the points the player has, when needed. It
 * also stores the number of the answer that the player gives when they are asked
 * a question.
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
    private int correctAnswers;

    /**
     * Constructor
     *
     * The constructor initializes the points of the player in the value 0 by default.
     * It also initializes the number of the player with the number they take in the
     * start of the game.
     *
     * @param playerNumber Contains the number of the player which will define the keys
     *                     that they can use to answer.
     */

    public Player(int playerNumber){
        this.playerNumber = playerNumber;
        this.points = 0;
    }

    /**
     * This method sets the name of each player, when they are asked. If the name contains
     * numbers or white characters this method deletes them before it sets the name.
     *
     * @param name is the name of the player.
     */

    public void setName (String name) {
        for (int i=0;i<10;i++)
            if (name.contains(String.valueOf(i)))
                name =name.replace(String.valueOf(i),"");
        if (name.contains(" "))
            name = name.replace(" ", "");

        this.name = name;
    }

    /**
     * This method sets the answer of the first player and the second one, depending
     * on the keys they use to answer (first player 1-4 and second player 6-9).
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

        this.numberOfAnswer=answer;
    }

    /**
     * This method set the number of the points that the player may bet in the "Bet" kind
     * of round and it checks if the parameter is between the correct bet points.
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
     * @return The information of the points that the player has at a certain moment
     * of the game whenever it is asked.
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
     * @return statement gives back the points that the player may bet
     * in the "Bet" kind of round whenever it is asked.
     */

    public int getBetPoints () {
        return this.betPoints;
    }

    /**
     * This method changes the points of the player positively by the points the parameter
     * says when they answer correctly in a question.
     *
     * @param points Are the points that the player wins.
     */

    public void winPoints(double points) {
        this.points += points;
    }

    /**
     *  This method changes the points of the player negatively by the points the parameter
     *  says when the answer that they give is wrong.
     *
     *  @param points Are the points that the player loses.
     */

    public void losePoints(double points) {
        this.points -= points;
        if (this.points < 0)
            this.points = 0;
    }

    /**
     *  This method sets the number of correct answers of the player in the Thermometer
     *  round as 0 and is called in the beginning of the round because everytime the
     *  round starts,the player has not given any (correct) answers for the current round.
     */

    public void initializeCorrectAnswersOfRound(){
        this.correctAnswers=0;
    }

    /**
     * This method increases the number of the correct answers that one of the players
     * has given in the Thermometer round.The int variable that represents the times
     * the player gave a right answer can have a maximum value of 5,because when they
     * reach 5 correct answers,they win (if they are also the fastest to do so).
     *
     * When the next Thermometer round begins,the initializeCorrectAnswersOfRound method
     * will be called, in order to set the correct answers of the new round as zero again.
     */

    public void increaseCorrectAnswers(){
        this.correctAnswers++;
    }

    /**
     *  @return the number of the correct answers that one of the players has given in
     *  a round, that will be used in the Thermometer round.
     */

    public int getCorrectAnswers(){
        return this.correctAnswers;
    }
}