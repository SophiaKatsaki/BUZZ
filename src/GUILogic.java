import java.util.ArrayList;

public class GUILogic {
    private Game game;
    private Statistics statistics;
    private Player player1;
    private Player player2;
    private Round round;
    private Question question;
    private Answer answer;
    private boolean firstHere = true;

    public GUILogic() {
        this.game = new Game();
        this.statistics = new Statistics() {};
        this.player1 = new Player(1);
        this.player2 = new Player(2);
    }

    public String getStatistics(int answer){
        return this.statistics.makeStatistics(answer);
    }

    public void setMode(int answer) {
        this.game.setNumberOfPlayers(answer);
    }

    public int getNumberOfPlayers() {
        return this.game.getNumberOfPlayers();
    }

    public void setName(int playerNumber, String name) {
        if (playerNumber == player1.getPlayerNumber()) {
            player1.setName(name);
        }
        else {
            player2.setName(name);
        }
    }

    public String getName(int playerNumber) {
        if (playerNumber == player1.getPlayerNumber()) {
            return player1.getName();
        }
        else {
            return player2.getName();
        }
    }

    public void setRounds(int answer) {
        if (answer < 0)
            this.game.setRandomRounds();
        else
            this.game.setNumberOfRounds(answer);
    }

    public int getRounds() {
        return this.game.getNumberOfRounds();
    }

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

    public boolean isLastRound() {
        if (this.game.getNumberOfPlayers() == 2 && this.game.getCurrentRound() == this.game.getNumberOfRounds())
            this.round.makeLastRound();
        return this.game.getCurrentRound() == this.game.getNumberOfRounds();
    }

    public void setCurrentRound() {
        this.game.setCurrentRound();
    }

    public int getCurrentRound() {
        return this.game.getCurrentRound();
    }

    public String getKind() {
        return this.round.getKind();
    }

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

                this.answer = new Answer();

                this.answer.setFourPossibleAnswers(this.question.getNumberOfRandomQuestionInArray(),
                        this.question.getNumberOfCategory());

                return false;
            }
        }
    }

    public int getCurrentQuestion() {
        return this.round.getCurrentNumberOfQuestion();
    }

    public String getCategory(){
        return this.question.getCategory();
    }

    public void setBets(int numberOfPlayer, int betPoints) {
        if (numberOfPlayer == this.player1.getPlayerNumber())
            this.player1.setBetPoints(betPoints);
        else
            this.player2.setBetPoints(betPoints);
    }

    public String getQuestion() {
        return  this.question.getRandomQuestion();
    }

    public String getAPossibleAnswer(int i) {
        ArrayList<String> possibleAnswers= this.answer.getFourPossibleAnswers();
        return possibleAnswers.get(i);
    }

    public boolean checkCorrectAnswer(int numberOfPlayer, int answer) {
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
        setPoints(numberOfPlayer);
        return this.answer.getCorrectAnswer();
    }

    public void setPoints(int numberOfPlayer) {
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
            case "Stop The Watch" -> {}
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

    public int getBetPoints(int numberOfPlayer) {
        if (numberOfPlayer == this.player1.getPlayerNumber())
            return this.player1.getBetPoints();
        else
            return  this.player2.getBetPoints();
    }

    public int getEndOfRoundPoints(int numberOfPlayer) {
        if (numberOfPlayer == this.player1.getPlayerNumber())
            return this.player1.getPoints();
        else
            return this.player2.getPoints();
    }

    public void setCurrentQuestion() {
        this.round.setCurrentNumberOfQuestion();

        this.question.questions.clear();
        this.question.categories.clear();
        this.question.possibleAnswers.clear();
        this.answer.categories.clear();
    }

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

    public String getWinner() {
        if (this.player1.getPoints() > this.player2.getPoints()) {
            refreshStatistics(2, 1);
            return this.player1.getName() + ", you won!";
        }
        else if (this.player1.getPoints() < this.player2.getPoints()) {
            refreshStatistics(2, 2);
            return player2.getName() + ", you won!";
        }
        else
            return "Tie!";
    }
}
