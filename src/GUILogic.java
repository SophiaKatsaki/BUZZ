public class GUILogic {
    protected Game game;
    protected Player player1;
    protected Player player2;
    protected Round round;
    protected Question question;
    protected Answer answer;
    protected Answer answer2;

    GUILogic() {
        game = new Game();
        player1 = new Player(1);
        player2 = new Player(2);
    }

    public void makeRound() {
        round = new Round();
    }

    public void setQA () {
        question = new Question();

        question.setRandomQuestion();
        question.setNumberOfRandomQuestionInArray();

        answer = new Answer();

        answer.setFourPossibleAnswers(question.getNumberOfRandomQuestionInArray(),
                question.getNumberOfCategory());
    }

    public int makeWinner () {
        int number;

        if (player1.getPoints() > player2.getPoints())
            number = 1;
        else if (player1.getPoints() < player2.getPoints())
            number = 2;
        else
            number = 3;


        return number;
    }
}