import java.util.Scanner;

/**
 * In this class exists the view of our game.
 *
 * From the begin, it creates an object of the class Game that has the most important elements of the game.
 * That object gets destroyed only when the game ends.
 *
 * Afterwards, messages are displayed and the interface with the user/ player has already begun.
 *
 * When it asks to enter the name, an object from the class Player gets created.
 * That object contains the elements that the player will need.
 * That object gets destroyed when the game ends.
 *
 * Messages are displayed again and the interface with the user/ player continues.
 *
 * When all the important data got taken, then an object from the class Round gets created.
 * That object gets destroyed everytime a round ends and gets created again when a new round begins.
 *
 * The interface with the user/ player continues with some messages.
 *
 * Sooner than later, objects from the classes Question and Answer get created.
 * The first one contains everything that a question must do.
 * The second one contains everything that an answer must do.
 * Both get destroyed everytime a question ends and get created again when a new question begins.
 *
 * In the end, there exists some last messages that make the last interface with the user/ player.
 * These messages inform them about the end of the game and ends the game, the main class and, at the same time,
 * the view.
 * */

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello and welcome to the best game ever,Buzz!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        Player player = new Player(scanner.nextLine());
        System.out.println("Welcome " + player.getName() + "!");

        System.out.println("Ready to play buzz?");

        System.out.println("Select:");
        System.out.println("1) Choose the number of rounds.");
        System.out.println("2) Random rounds.");
        scanner = new Scanner(System.in);
        Game game=new Game(scanner.nextInt());

        if (game.getNumberOfRounds()==1) {
            System.out.println("From 1 to 10,");
            System.out.println("how many rounds do you want to play?");
            game.setNumberOfRounds(scanner.nextInt());
            System.out.println("You choose "+game.getNumberOfRounds()+" round/s.");
        }
        else {
            game.setRandomRounds();
            System.out.println(game.getNumberOfRounds()+" round/s was chosen.");
        }

        while (game.getCurrentRound() <= game.getNumberOfRounds()) {
            Round round = new Round();

            System.out.println("Round " + game.getCurrentRound());
            if (game.getCurrentRound()== game.getNumberOfRounds()) {
                System.out.println("Last Round");
            }

            System.out.println(round.getKind());

            while (round.getCurrentNumberOfQuestion() <= round.getRandomNumberOfQuestions()) {
                Question question = new Question();

                System.out.println("Question " + round.getCurrentNumberOfQuestion());
                if (round.getKind().equals("Bet")) {
                    System.out.println("\"" + question.getCategory() + "\"");
                    System.out.println("Bet 250, 500, 750 or 1000");
                    scanner = new Scanner(System.in);
                    round.setBetPoints(scanner.nextInt());
                }

                question.setRandomQuestion();
                question.setNumberOfRandomQuestionInArray();
                System.out.println("\"" + question.getRandomQuestion() + "\"");

                Answer answer = new Answer();
                answer.showAnswers(question.getNumberOfRandomQuestionInArray());

                System.out.println("Select an answer between 1 and 4");
                player.setNumberOfAnswer(scanner.nextInt());
                answer.setCorrectAnswer(player.getNumberOfAnswer(), question.getNumberOfRandomQuestionInArray());

                if (answer.getCorrectAnswer()) {
                    if(round.getKind().equals("Bet")){
                        player.winPoints(round.getBetPoints());
                        System.out.println("+" + round.getBetPoints());
                    }
                    else
                    {
                        player.winPoints(1000);
                        System.out.println("+1000");
                    }
                }

                if ((round.getKind().equals("Bet")) && (!(answer.getCorrectAnswer()))) {
                    player.losePoints(round.getBetPoints());
                    System.out.println("-" + round.getBetPoints());
                }

                round.setCurrentNumberOfQuestion();
            }

            System.out.println("You have " + player.getPoints() + " points.");

            game.setCurrentRound();
        }

        System.out.println("The game is over.");
        System.out.println(player.getName() + ", you got " + player.getPoints() + " points.");

        System.out.println("See you next time!");
    }
}