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
     * This method loads the statistics of the game of the file that contains that
     * information.When it gets called it makes visible the statistics only for
     * the mode of the game that the user(s)/ player(s) said that they want to see.
     *
     * @param answer is an int that suggests for which mode of the game the
     *               user(s)/ player(s) want to see the the statistics.
     *               Number 1 is the "Solo Game".
     *               Number 2 is the "Play With a Friend"/"Multiplayer".
     *               At last the number 3 is used for the option that they do not
     *               want to see the statistics of any mode.
     *
     * @return statement gives back a String that contains the statistics for the
     * mode of the game that the user(s)/ player(s) said that they want to see or
     * nothing if they said that they not want to see any statistic.
     */

    public String makeStatistics(int answer) {
        int statisticAnswer = answer;
        Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();
        while (statisticAnswer!=1 && statisticAnswer!=2 && statisticAnswer!=3) {
            statisticAnswer = scanner.nextInt();
            scanner.nextLine();
        }

        StringBuilder multiplayer = new StringBuilder();

        if (!(statisticAnswer == 3)) {
            try (BufferedReader reader = new BufferedReader(new
                    FileReader("src/Statistics.txt"))) {
                String line;
                boolean ok = false;

                while ((line = reader.readLine()) != null) {
                    if (line.contains("Solo Game") && statisticAnswer == 1)
                        return (reader.readLine());
                    else if (line.contains("Multiplayer") && statisticAnswer == 2) {
                        ok = true;
                    }
                    if (ok && !line.contains("Multiplayer") && !line.isBlank()) {
                        multiplayer.append(line).append("\n");
                    }
                }
                return (multiplayer.toString());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return "";
    }

    /**
     * This method loads the statistic that are not refreshed yet and it is called
     * from the program whenever it needs that information.
     *
     * @return statement gives back the statistics before they got refreshed.
     */

    public String getOldStatistics() {
        StringBuilder oldStatistics = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new
                FileReader("src/Statistics.txt"))) {
            String line;

            while ((line = reader.readLine()) != null)
                oldStatistics.append(line).append(System.lineSeparator());
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        return oldStatistics.toString();
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
                    if (Integer.parseInt(words[6]) <= points) {
                        oldStatistics = oldStatistics.replaceFirst(words[0], "\"" + playerName + "\"");
                        newStatistics = oldStatistics.replaceFirst(words[6], valueOf(points));
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
     * This method is used from the program when the mode
     * "Game With a Friend" / "Multiplayer" comes to an end and it is responsible
     * for the refreshing part of the the statistics to that mode.
     *
     * @param oldStatistics is the statistics which are not refreshed yet.
     * @param playerName is the name of the player that won the game.
     */

    public void refreshMultiplayer(String oldStatistics, String playerName) {
        String newStatistics = oldStatistics;

        try (BufferedReader reader = new BufferedReader(new
                FileReader("src/Statistics.txt"))) {
            String line;
            boolean ok = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Multiplayer"))
                    ok = true;
                if (ok) {
                    if (line.contains(playerName)) {
                        String[] words = line.split(" ");
                        int temp = Integer.parseInt(words[2]);
                        temp++;
                        newStatistics = oldStatistics.replace(words[2], valueOf(temp));

                        break;
                    }
                }
            }
            if (oldStatistics.equals(newStatistics))
                newStatistics += "\"" + playerName + "\" has 1 wins!";

            FileWriter writer = new FileWriter("src/Statistics.txt");

            writer.write(newStatistics);
            writer.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}