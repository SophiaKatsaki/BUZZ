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
        Game game = new Game();

        System.out.println("Let's Play!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        Player player = new Player(scanner.nextLine());
        System.out.println("Welcome " + player.getName() + "!");

        System.out.println("Ready to play buzz?");

        System.out.println("Select:");
        System.out.println("1) Choose the number of rounds.");
        System.out.println("2) Random rounds.");
        scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        scanner.nextLine();
        while (answer != 1 && answer != 2) {
            answer = scanner.nextInt();
            scanner.nextLine();
        }
        game.setRounds(answer);

        if (answer == 1) {
            System.out.println("You chose " + game.getRounds() + " round/s.");
        }
        else {
            System.out.println(game.getRounds() + " round/s was chosen.");
        }

        Round round = new Round();
        int rounds=1;
        while (rounds <= game.getRounds()) {
            System.out.println("Round " + rounds);
            if (rounds == game.getRounds()) {
                System.out.println("Last Round");
            }
            round.setKind();
            System.out.println(round.getKind());

            round.hasNumberOfQuestions();

            Question question = new Question();
            Answer objectAnswer = new Answer();
            int questions=1;
            while (questions <= round.getNumberOfQuestions()) {
                System.out.println("Question " + questions);
                if (round.getKind().equals("Bet")) {
                    question.setCategory();
                    System.out.println("\"" + question.getCategory() + "\"");
                    System.out.println("Bet 250, 500, 750 or 1000");
                    scanner = new Scanner(System.in);
                    answer = scanner.nextInt();
                    scanner.nextLine();
                    while (answer != 250 && answer != 500 && answer != 750 && answer != 1000) {
                        answer = scanner.nextInt();
                        scanner.nextLine();
                    }
                }
                question.setQuestion();
                question.setNumberOfQuestion();
                System.out.println("\"" + question.getQuestion() + "\"");
                objectAnswer.showAnswers(question.getNumberOfQuestion());

                player.setAnswer();
                if (objectAnswer.getAnswer(question.getNumberOfQuestion(),
                        player.getAnswer()).equals(objectAnswer.getCorrectAnswer(question.getNumberOfQuestion()))) {
                    if (round.getKind().equals("Bet")) {
                        player.winPoints(answer);
                    }
                    else {
                        player.winPoints(1000);
                    }
                }

                if (round.getKind().equals("Bet") && !(objectAnswer.getAnswer(question.getNumberOfQuestion(),
                        player.getAnswer()).equals(objectAnswer.getCorrectAnswer(question.getNumberOfQuestion())))) {
                    player.losePoints(answer);
                }

                questions++;
            }

            System.out.println("You have " + player.getPoints() + " points.");
            rounds++;
        }

        System.out.println("The game is over.");
        System.out.println(player.getName() + ", you got " + player.getPoints() + " points.");

        System.out.println("See you next time!");
    }
}