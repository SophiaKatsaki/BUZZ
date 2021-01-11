import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.String.valueOf;

/**
 * This class represents the statistics of the performance of the players in the two modes of the game.
 * It handles the file which has the statistics and refreshes it in the end of every game. It, also, loads the file
 * and makes it visible to the user(s)/ player(s) whenever they want to see it. For that cause it has five methods
 * for the handling of the file depending on each mode of the game.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */

public abstract class Statistics {

    /**
     * This method loads the statistics of the game for the file that contains that information.
     * When it gets called it makes visible the statistics only for the mode of the game that
     * the user(s)/ player(s) said that they want to see.
     *
     * @param answer is an int that suggests for which mode of the game the user(s)/ player(s)
     *               want to see the the statistics.
     *               Number 1 is the "Solo Game".
     *               Number 2 is the "Play With a Friend" or "Multiplayer"/
     *               At last the number 3 is used for the option that they do not want to see
     *               the statistics of any mode.
     */

    public void makeStatistics(int answer) {
        int statisticAnswer = answer;
        Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();
        while (statisticAnswer!=1 && statisticAnswer!=2 && statisticAnswer!=3) {
            statisticAnswer = scanner.nextInt();
            scanner.nextLine();
        }

        if (!(statisticAnswer == 3)) {
            try (BufferedReader reader = new BufferedReader(new
                    FileReader("src/Statistics.txt"))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    if (line.contains("Solo Game") && statisticAnswer == 1) {
                        System.out.println(reader.readLine());
                        break;
                    } else if (line.contains("Multiplayer") && statisticAnswer == 2) {
                        System.out.println(reader.readLine() + "\n" + reader.readLine());
                        break;
                    }
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * This method loads the statistic that are not refreshed yet and it is called from the
     * program whenever it needs that information.
     *
     * @return statement gives back the statistics before they got refreshed.
     */

    public String getOldStatistics() {
        String oldStatistics = "";

        try (BufferedReader reader = new BufferedReader(new
                FileReader("src/Statistics.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                oldStatistics = oldStatistics + line + System.lineSeparator();
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        return oldStatistics;
    }

    /**
     * This method is used from the program when the mode "Solo Game" comes to an end and it
     * refreshes the statistics for that mode according the performance of the player.
     *
     * @param oldStatistics is the statistics which are not refreshed yet.
     * @param playerName is the name of the player that chose to play "Solo Game".
     * @param points are the points that belongs to that player.
     */

    public void refreshSoloGame(String oldStatistics, String playerName, int points) {
        String newStatistics = oldStatistics;

        try (BufferedReader reader = new BufferedReader(new
                FileReader("src/Statistics.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Solo Game")) {
                    line = reader.readLine();
                    String[] words = line.split(" ");
                    if (Integer.parseInt(words[4]) <= points) {
                        oldStatistics = oldStatistics.replaceFirst(words[2], "\"" + playerName + "\"");
                        newStatistics = oldStatistics.replaceFirst(words[4], valueOf(points));
                    }
                    break;
                }
            }

            FileWriter writer = new FileWriter("src/Statistics.txt");

            writer.write(newStatistics);
            writer.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * This method is used from the program when the mode is "Game With a Friend" / "Multiplayer"
     * and it refreshes the statistics to one of the players each time.
     *
     * @param line is the line of the file that has been loaded when that this method is called.
     * @param points are the points of one of the players at the end of the game.
     * @param playerName is the name of the player that the points are belong to.
     * @param oldStatistics is the statistics which are not refreshed yet.
     * @return statement gives back the refreshed statistics.
     */

    public String getNewStatisticsInMultiplayer(String line, int points, String playerName,
                                                String oldStatistics) {
        String newStatistics = oldStatistics;

        String[] words = line.split(" ");
        if (Integer.parseInt(words[5]) <= points) {
            oldStatistics = oldStatistics.replace(words[3], "\"" + playerName + "\"");
            newStatistics = oldStatistics.replace(words[5], valueOf(points));
        }

        return newStatistics;
    }

    /**
     * This method is used from the program when the mode "Game With a Friend" / "Multiplayer" comes to
     * an end and it is responsible for the refreshing part of the the statistics to that mode.
     *
     * @param oldStatistics is the statistics which are not refreshed yet.
     * @param player1Name is the name of the player that won the game or if there was a tie then it
     *                    is the name of the player that was firstly introduced to the game and
     *                    they have unique number 1 and so their keys are 1, 2, 3 and 4.
     * @param player2Name is the name of the player that lost in the game or if there was a tie then it
     *                    is the name of the player that was secondly introduced to the game and
     *                    they have unique number 2 and so their keys are 6, 7, 8 and 9.
     * @param points1 are the points at the end of the game that belongs to the player who won the
     *                game or in case of "Tie" the points of the the player with the unique number 1.
     * @param points2 are the points at the end of the game that belongs to the player who lost in the
     *                game or in the case of "Tie" the points of the player with with the unique
     *                number 2.
     */

    public void refreshMultiplayer(String oldStatistics, String player1Name, String player2Name,
                                   int points1, int points2) {
        String newStatistics = oldStatistics;

        try (BufferedReader reader = new BufferedReader(new
                FileReader("src/Statistics.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Multiplayer")) {
                    line = reader.readLine();
                    oldStatistics = getNewStatisticsInMultiplayer(line, points1, player1Name, oldStatistics);

                    line = reader.readLine();
                    newStatistics = getNewStatisticsInMultiplayer(line, points2, player2Name, oldStatistics);

                    break;
                }
            }

            FileWriter writer = new FileWriter("src/Statistics.txt");

            writer.write(newStatistics);
            writer.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}