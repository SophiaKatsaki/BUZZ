import java.util.ArrayList;

/**
 * This class is the logic before the main interface with the user(s).
 *
 * This class represents the logic of the game. It is used in the classes that
 * implement the graphical user interface. It stores an object of the class Game,
 * a Statistics one, two objects of the class Player, one of the class Round, Question,
 * Answer and a boolean variable that holds the value of true when one of the players
 * in "Game With a Friend" / "Multiplayer" mode is the first one to answer to a
 * question.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */

public class GUILogic {
    private Game game;
    private Statistics statistics;
    private Player player1;
    private Player player2;
    private Round round;
    private Question question;
    private Answer answer;
    private boolean firstHere = true;

    /**
     * Constructor
     *
     * The constructor of the GUILogic class creates a new game,by creating the
     * object of the game it stores,as well as a new statistics object.Two players
     * are created,the first one with the number 1 and the second with the number 2.
     *
     */

    public GUILogic() {
        this.game = new Game();
        this.statistics = new Statistics() {};
        this.player1 = new Player(1);
        this.player2 = new Player(2);
    }

    /**
     * @return the statistics of the game mode that is chosen that the
     * makeStatistics method returns in the class Statistics.
     */

    public String getStatistics(int answer){
        return this.statistics.makeStatistics(answer);
    }

    /**
     *This method sets the number of the players in the object game that is held
     * to either 1 or 2,depending on the answer of the user.
     *
     * @param answer that will depend whether the game will be solo or not.
     */

    public void setMode(int answer) {
        this.game.setNumberOfPlayers(answer);
    }

    /**
     * @return the number of the players of the game object.
     */

    public int getNumberOfPlayers() {
        return this.game.getNumberOfPlayers();
    }

    /**
     *This method sets the name of the player either on the first object of
     * the class Player (player1) or the second(player2) depending on
     * the number that is given.
     *
     * @param playerNumber the number 1 or 2 that gives the information of
     *                     wether is the first player or the second one.
     * @param name the name that the player typed in order to play.
     */

    public void setName(int playerNumber, String name) {
        if (playerNumber == player1.getPlayerNumber())
            player1.setName(name);
        else
            player2.setName(name);
    }

    /**
     * @param playerNumber the number that represents the player.
     *
     * @return the name of the player taking into account the number that is given
     * as a parameter and defines if he is the player1 or player2.
     */

    public String getName(int playerNumber) {
        if (playerNumber == player1.getPlayerNumber())
            return player1.getName();
        else
            return player2.getName();
    }

    /**
     *This method sets the rounds in the game object of the class either randomly
     * or with the desired by the user rounds.
     *
     * @param answer if it is less than 0,the rounds are set randomly.Else,it sets
     *               the number of rounds that the user wanted.
     */

    public void setRounds(int answer) {
        if (answer < 0)
            this.game.setRandomRounds();
        else
            this.game.setNumberOfRounds(answer);
    }

    /**
     * @return the number of the rounds of the game object.
     */

    public int getRounds() {
        return this.game.getNumberOfRounds();
    }

    /**
     *This method checks if the current number of round became bigger than the
     * rounds that were selected for the game,in order to finish the game.If is is,
     * the method returns true.If it is not, a new round is created with either 1
     * or 2 players,depending on the game mode and the correct answers of the
     * players are initialized by 0.In this case,the method returns true.
     *
     * @return true if the game should be finished or false if the number of
     * played rounds are less than the chosen number of rounds.
     */

    public boolean endOfRounds(){
        if (this.game.getCurrentRound() > this.game.getNumberOfRounds())
            return true;
        else {
            this.player1.initializeCorrectAnswersOfRound();
            this.player2.initializeCorrectAnswersOfRound();

            this.round = new Round();
            if (this.game.getNumberOfPlayers() == 2)
                round.makeMultiplayerRounds();

            return false;
        }
    }

    /**
     *This method checks if the current round is the last one and if it is,it
     * returns true by comparing the number of the current round with the
     * number of the rounds that were chosen.Else,it returns false.If the game is
     * with two players, then the method of the round object in this class,
     * makeLastRound is called(in which the type of round is always set as the
     * Thermometer round).
     *
     * @return true if it is the last round and false if it is not.
     */

    public boolean isLastRound() {
        if (this.game.getNumberOfPlayers() == 2 && this.game.getCurrentRound() == this.game.getNumberOfRounds())
            this.round.makeLastRound();
        return this.game.getCurrentRound() == this.game.getNumberOfRounds();
    }

    /**
     *This method increases the number of the current round of the object game in
     * the GUILogic class.
     */

    public void setCurrentRound() {
        this.game.setCurrentRound();
    }

    /**
     * @return the number of the current round of the object of the class Game.
     */

    public int getCurrentRound() {
        return this.game.getCurrentRound();
    }

    /**
     * @return the kind of the current round of the object of the class Game.
     */

    public String getKind() {
        return this.round.getKind();
    }

    /**
     *This method checks whether the number of the current question is bigger than
     *the number of questions that were set for this round.If it is,the method
     * returns true and if it is not,it returns false.If it is not the end of
     * questions,then the question and answer objects are initialized properly
     * in order to make a new question for the player(s).If the mode is
     * "Game With a Friend" / "Multiplayer" and is is the last round and none
     * of the players have reached the limit of 5 correct answers,then another
     * question is created.
     *
     * @return true if the questions should end in this round and false otherwise.
     */

    public boolean endOfQuestions(){
        if (this.game.getNumberOfPlayers() == 2 && game.getCurrentRound() == game.getNumberOfRounds()){
            if ((this.player1.getCorrectAnswers() < 5  && this.player2.getCorrectAnswers() < 5)) {
                this.question = new Question();

                this.question.setRandomQuestion();
                this.question.setNumberOfRandomQuestionInArray();

                this.answer = new Answer();

                this.answer.setFourPossibleAnswers(this.question.getNumberOfRandomQuestionInArray(),
                        this.question.getNumberOfCategory());

                return false;
            }
            else
                return true;
        }
        else {
            if (this.round.getCurrentNumberOfQuestion() > this.round.getRandomNumberOfQuestions())
                return true;
            else {
                this.question = new Question();

                this.question.setRandomQuestion();
                this.question.setNumberOfRandomQuestionInArray();
                this.question.setLinkOfImage();

                this.answer = new Answer();

                this.answer.setFourPossibleAnswers(this.question.getNumberOfRandomQuestionInArray(),
                        this.question.getNumberOfCategory());

                return false;
            }
        }
    }

    /**
     * @return the number of the current question of the object round.
     */

    public int getCurrentQuestion() {
        return this.round.getCurrentNumberOfQuestion();
    }

    /**
     * @return the category of the current question.
     */

    public String getCategory(){
        return this.question.getCategory();
    }

    /**
     * This method sets the points that one player bet in the proper round.
     *
     * @param numberOfPlayer this number defines whether the points will be bet
     *                       for the first or the second player.
     * @param betPoints the number (250,500,750,1000) that the player bet.
     */

    public void setBets(int numberOfPlayer, int betPoints) {
        if (numberOfPlayer == this.player1.getPlayerNumber())
            this.player1.setBetPoints(betPoints);
        else
            this.player2.setBetPoints(betPoints);
    }

    /**
     * @return the String of the current question.
     */

    public String getQuestion() {
        return this.question.getRandomQuestion();
    }

    /**
     * @return statement gives back the Stings of the link to the image that the question
     * may has.
     */

    public String getImage() {
        return this.question.getLinkOfImage();
    }

    /**
     * This method sets the arraylist of the possible answers and returns the
     * desired answer.
     *
     * @param i the number of a possible answer.
     * @return the desired number of a possible answer in the four possible answers.
     */

    public String getAPossibleAnswer(int i) {
        ArrayList<String> possibleAnswers= this.answer.getFourPossibleAnswers();
        return possibleAnswers.get(i);
    }

    /**
     * This method sets the answer of one of the players and checks whether is
     * the correct one or not and then sets the points they either win or lose.
     *
     * @param numberOfPlayer the number that the player that gave the answer has
     * @param answer the number of the answer he chose.
     * @param time is the number of points that got from the round "Stop The Watch".
     *
     * @return whether is the correct one or not.
     */

    public boolean checkCorrectAnswer(int numberOfPlayer, int answer, double time) {
        if (numberOfPlayer == this.player1.getPlayerNumber()) {
            this.player1.setNumberOfAnswer(answer);
            this.answer.setCorrectAnswer(this.player1.getNumberOfAnswer(),
                    this.question.getNumberOfRandomQuestionInArray());
        }
        else {
            this.player2.setNumberOfAnswer(answer);
            this.answer.setCorrectAnswer(this.player2.getNumberOfAnswer(),
                    this.question.getNumberOfRandomQuestionInArray());
        }
        setPoints(numberOfPlayer, time);
        return this.answer.getCorrectAnswer();
    }

    /**
     * This method sets the points of the player deserves depending on the kind of
     * round and the answer that they gave.They can win points if the answer is
     * correct in almost every round(in Thermometer they need 5 correct answers to
     * win 5000 points),lose the points they bet in the Bet Round if their answer
     * was incorrect or keep their score the same.
     *
     * @param numberOfPlayer the number that the player has.
     * @param time is the points to the round "Stop The Watch".
     */

    public void setPoints(int numberOfPlayer, double time) {
        switch (this.round.getKind()) {
            case "Correct Answer" -> {
                if (this.answer.getCorrectAnswer()) {
                    if (numberOfPlayer == 1) {
                        player1.winPoints(1000);
                    } else {
                        this.player2.winPoints(1000);
                    }
                }
            }
            case "Stop The Watch" -> {
                if (this.answer.getCorrectAnswer()) {
                    if (numberOfPlayer == 1) {
                        player1.winPoints((int)time);
                    } else {
                        this.player2.winPoints((int)time);
                    }
                }
            }
            case "Bet" -> {
                if (this.answer.getCorrectAnswer()) {
                    if (numberOfPlayer == 1) {
                        this.player1.winPoints(this.player1.getBetPoints());
                    } else {
                        this.player2.winPoints(this.player2.getBetPoints());
                    }
                } else {
                    if (numberOfPlayer == 1) {
                        this.player1.losePoints(this.player1.getBetPoints());
                    } else {
                        this.player2.losePoints(this.player2.getBetPoints());
                    }
                }
            }
            case "Quick Answer" -> {
                if (this.answer.getCorrectAnswer() && this.firstHere) {
                    if (numberOfPlayer == 1) {
                        player1.winPoints(1000);
                    } else {
                        this.player2.winPoints(1000);
                    }
                    firstHere = false;
                }
                else if (this.answer.getCorrectAnswer()) {
                    if (numberOfPlayer == 1) {
                        player1.winPoints(500);
                    } else {
                        this.player2.winPoints(500);
                    }
                    firstHere = true;
                }
            }
            case "Thermometer" -> {
                if (numberOfPlayer == this.player1.getPlayerNumber()) {
                    this.player1.increaseCorrectAnswers();
                    if (this.player1.getCorrectAnswers() == 5)
                        this.player1.winPoints(5000);
                }
                else {
                    this.player2.increaseCorrectAnswers();
                    if (this.player2.getCorrectAnswers() == 5)
                        this.player2.winPoints(5000);
                }
            }
        }
    }

    /**
     * @param numberOfPlayer the number that the player has.
     *
     * @return the points that one of the player bet.
     */

    public int getBetPoints(int numberOfPlayer) {
        if (numberOfPlayer == this.player1.getPlayerNumber())
            return this.player1.getBetPoints();
        else
            return  this.player2.getBetPoints();
    }

    /**
     * @param numberOfPlayer the number that the player has.
     *
     * @return the points of the player in the end of the round.
     */

    public int getEndOfRoundPoints(int numberOfPlayer) {
        if (numberOfPlayer == this.player1.getPlayerNumber())
            return this.player1.getPoints();
        else
            return this.player2.getPoints();
    }

    /**
     * This method sets the current number of question in the round and clears
     * all the arraylists that held the information of the questions,categories
     * and possible answers in the question and answer object.
     */

    public void setCurrentQuestion() {
        this.round.setCurrentNumberOfQuestion();

        this.question.questions.clear();
        this.question.categories.clear();
        this.question.possibleAnswers.clear();
        this.answer.categories.clear();
    }

    /**
     * This method updates the score of the player if they made a high score,
     * in solo game and updates the number of wins of the winner of the current
     * game in multiplayer mode.
     *
     * @param numberOfPlayer the number that the player has.
     * @param winner is the number of the player that won the "Multiplayer" mode.
     */

    public void refreshStatistics(int numberOfPlayer, int winner) {
        if (numberOfPlayer == this.player1.getPlayerNumber())
            this.statistics.refreshSoloGame(this.statistics.getOldStatistics(),
                    this.player1.getName(), this.player1.getPoints());
        else {
            if (winner == this.player1.getPlayerNumber())
                this.statistics.refreshMultiplayer(this.statistics.getOldStatistics(), this.player1.getName());
            else
                this.statistics.refreshMultiplayer(this.statistics.getOldStatistics(), this.player2.getName());
        }
    }

    /**
     * This method lets the winner of the game know that they won.
     *
     * @return a string that uses the name of the winner to tell them they won.
     */

    public String getWinner() {
        if (this.player1.getPoints() > this.player2.getPoints())
        {
            refreshStatistics(2, 1);
            return this.player1.getName() + ", you won!";
        }
        else
        {
            refreshStatistics(2, 2);
            return player2.getName() + ", you won!";
        }
    }
}
