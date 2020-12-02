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

        if (game.getNumberOfRounds()==1)
        {
            System.out.println("From 1 to 10,");
            System.out.println("how many rounds do you want to play?");
            game.setNumberOfRounds(scanner.nextInt());
            System.out.println("You choose "+game.getNumberOfRounds()+" round/s.");
        }
        else
        {
            game.setRandomRounds();
            System.out.println(game.getNumberOfRounds()+" round/s was chosen.");
        }
        Round round = new Round(scanner.nextInt());

        while (game.getCurrentRound() <= game.getNumberOfRounds()) {
            System.out.println("Round " + game.getCurrentRound());
            if (game.getCurrentRound()== game.getNumberOfRounds()) {
                System.out.println("Last Round");
            }
            round.setKind();
            System.out.println(round.getKind());

            round.hasNumberOfQuestions();

            Question question = new Question(scanner.nextInt());
            Answer objectAnswer = new Answer(scanner.nextInt());

            while (round.getCurrentQuestion() <= round.getNumberOfQuestions()) {
                System.out.println("Question " + round.getCurrentQuestion());
                if (round.getKind().equals("Bet")) {
                    question.setCategory();
                    System.out.println("\"" + question.getCategory() + "\"");
                    System.out.println("Bet 250, 500, 750 or 1000");
                    scanner = new Scanner(System.in);
                    int answer = scanner.nextInt();
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


                System.out.println("Select an answer between 1 and 4");
                player.setNumberOfAnswer(scanner.nextInt());
                answer.setCorrectAnswer(player.getNumberOfAnswer(),question.getNumberOfRandomQuestion);

                if (answer.getCorrectAnswer()){
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
                if((round.getKind().equals("Bet")) && (!(answer.getCorrectAnswer())))
                {
                    player.losePoints(round.getBetPoints());
                    System.out.println("-" + round.getBetPoints());
                }



                /*    player.setAnswer();
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