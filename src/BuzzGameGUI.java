import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class is the main graphical interface to the game. It is the game when it has all
 * the important data from the setting point. It has one frame that will hold the game
 * in the whole time until it ends. It has a panel that contains three sub panels and all
 * of them are used in order to organize the frame and the things that it will present. It
 * contains the four buttons for the four possible answers that are existing for every
 * question. It also has five labels for the images, the questions, the points to each player
 * and the timer to the kind of round "Stop The Watch". At last, it has a box that organizes
 * the four possible answers, the controller which makes possible the implement of the graphics
 * and the logic and two booleans that is used to the "Multiplayer" / "Game With A Friend" mode
 * and "Quick Answer" kind of round.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */

public class BuzzGameGUI {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel firstPanel;
    private JPanel secondPanel;
    private JPanel thirdPanel;
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JLabel questionLabel;
    private JLabel imageLabel;
    private JLabel pointsLabel;
    private JLabel pointsLabel2;
    private JLabel timeFliesBy;
    private Box answerBox;
    private GUIController logic;
    private boolean bothHere = true;
    private boolean firstHere = true;

    /**
     * Constructor
     *
     * The constructor sets the main frame and puts an image to it. It also sets the buttons
     * and adds to them actionListeners and keyListeners in order to be used properly. It calls
     * a method in order to be set the main panel in a right way. It organizes all the containers
     * with the help of the layouts. It sets the labels and the controller with all the data that
     * it takes in the previous form. It sets an image to the frame which depends to the mode of
     * it. At last it calls the method startRound in order to begin the game.
     *
     * @param logic contains the data to make the implements possible.
     */

    public BuzzGameGUI(GUIController logic) {
        this.logic = logic;

        this.mainFrame = new JFrame("BUZZ");
        this.mainFrame.setVisible(true);
        this.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.mainFrame.setResizable(true);
        this.mainFrame.setSize(750, 520);
        this.mainFrame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("openingImage.jpg"));
        this.mainFrame.setIconImage(icon.getImage());

        this.mainPanel = new JPanel(new GridLayout(3,1));
        this.mainPanel.setVisible(false);
        this.mainPanel.setBackground(Color.WHITE);
        this.mainFrame.add(this.mainPanel);

        setMainPanel();

        this.buttonA = new JButton("A");
        this.buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logic.getNumberOfPlayers() == 1)
                    showPoints(1, logic.checkCorrectAnswer(1, 1));

            }
        });

        this.buttonB = new JButton("B");
        this.buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logic.getNumberOfPlayers() == 1)
                    showPoints(1, logic.checkCorrectAnswer(1, 2));
            }
        });

        this.buttonC = new JButton("C");
        this.buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logic.getNumberOfPlayers() == 1)
                    showPoints(1, logic.checkCorrectAnswer(1, 3));
            }
        });

        this.buttonD = new JButton("D");
        this.buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logic.getNumberOfPlayers() == 1)
                    showPoints(1, logic.checkCorrectAnswer(1, 4));
            }
        });

        Box box = Box.createVerticalBox();
        box.add(this.buttonA);
        box.add(Box.createVerticalStrut(10));
        box.add(this.buttonB);
        box.add(Box.createVerticalStrut(10));
        box.add(this.buttonC);
        box.add(Box.createVerticalStrut(10));
        box.add(this.buttonD);
        this.secondPanel.add(box, BorderLayout.LINE_START);

        this.mainFrame.setFocusable(true);
        this.mainFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '1') {
                    if (logic.getNumberOfPlayers() == 2)
                        showPoints(1, logic.checkCorrectAnswer(1, 1));
                    buttonA.doClick();
                } else if (e.getKeyChar() == '6' && logic.getNumberOfPlayers() == 2) {
                    showPoints(2, logic.checkCorrectAnswer(2, 6));
                    buttonA.doClick();
                } else if (e.getKeyChar() == '2') {
                    if (logic.getNumberOfPlayers() == 2)
                        showPoints(1, logic.checkCorrectAnswer(1, 2));
                    buttonB.doClick();
                } else if (e.getKeyChar() == '7' && logic.getNumberOfPlayers() == 2) {
                    showPoints(2, logic.checkCorrectAnswer(2, 7));
                    buttonB.doClick();
                } else if (e.getKeyChar() == '3') {
                    if (logic.getNumberOfPlayers() == 2)
                        showPoints(1, logic.checkCorrectAnswer(1, 3));
                    buttonC.doClick();
                } else if (e.getKeyChar() == '8' && logic.getNumberOfPlayers() == 2) {
                    showPoints(2, logic.checkCorrectAnswer(2, 8));
                    buttonC.doClick();
                } else if (e.getKeyChar() == '4') {
                    if (logic.getNumberOfPlayers() == 2)
                        showPoints(1, logic.checkCorrectAnswer(1, 4));
                    buttonD.doClick();
                } else if (e.getKeyChar() == '9' && logic.getNumberOfPlayers() == 2) {
                    showPoints(2, logic.checkCorrectAnswer(2, 9));
                    buttonD.doClick();
                }
            }
        });

        this.answerBox = Box.createVerticalBox();

        this.timeFliesBy = new JLabel();
        this.thirdPanel.add(this.timeFliesBy, BorderLayout.CENTER);
        this.timeFliesBy.setHorizontalAlignment(JLabel.CENTER);

        this.pointsLabel = new JLabel();
        this.pointsLabel.setForeground(Color.BLACK);
        this.pointsLabel2 = new JLabel();
        this.pointsLabel2.setForeground(Color.BLACK);

        Box box2 = Box.createVerticalBox();
        box2.add(this.pointsLabel);
        box2.add(Box.createVerticalStrut(15));
        box2.add(this.pointsLabel2);
        this.thirdPanel.add(box2);

        ImageIcon icon2;
        if (this.logic.getNumberOfPlayers() == 1)
            icon2 = new ImageIcon(getClass().getResource("soloMode.jpg"));
        else
            icon2 = new ImageIcon(getClass().getResource("gameWithAFriend.jpg"));
        Image image = icon2.getImage().getScaledInstance(220, 140,  java.awt.Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(icon2);
        this.thirdPanel.add(imageLabel);

        startRound();
    }

    /**
     * This method organizes the main panel (which has a gridLayout) to the three sub
     * panels and organizes them too.
     */

    public void setMainPanel() {
        this.firstPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.firstPanel.setBackground(Color.YELLOW);
        this.mainPanel.add(this.firstPanel);

        this.questionLabel = new JLabel();
        this.questionLabel.setForeground(Color.BLACK);
        this.firstPanel.add(this.questionLabel, BorderLayout.LINE_START);

        this.imageLabel = new JLabel();
        this.firstPanel.add(this.imageLabel, BorderLayout.AFTER_LAST_LINE);

        this.secondPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.secondPanel.setBackground(Color.WHITE);
        this.mainPanel.add(this.secondPanel);

        this.thirdPanel = new JPanel(new GridLayout(1,3));
        this.thirdPanel.setBackground(Color.WHITE);
        this.mainPanel.add(this.thirdPanel);
    }

    /**
     * This method is responsible to set and to change the image when a question has one
     * or if it does not have then it puts an image that was chosen to be as a default
     * image.
     */

    public void setImage() {
        ImageIcon icon;
        if(!this.logic.getImage().equals(""))
            icon = new ImageIcon(getClass().getResource(this.logic.getImage()));
        else
            icon = new ImageIcon(getClass().getResource("openingImage.jpg"));

        Image image = icon.getImage().getScaledInstance(220, 140, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        image.flush();
        this.imageLabel.setIcon(icon);
        this.firstPanel.add(this.imageLabel, BorderLayout.AFTER_LAST_LINE);
    }

    /**
     * This method starts the round and the main game in general. It checks if there exists
     * more rounds in order to continue the game and if there are not it ends it by disposing
     * the main frame after it informs the user(s)/ player(s) that the game is over. If there
     * are only one more round it informs them that they will play the last round. After it
     * tells in which round they are, it calls the method startQuestion for the starting
     * part of the round.
     */

    public void startRound() {
        if (this.logic.endOfRounds()) {
            if (logic.getNumberOfPlayers() == 1) {
                JOptionPane.showMessageDialog(mainFrame,
                        logic.getName(1) + ", you got " +
                                logic.getEndOfRoundPoints(1) + " points.",
                        "The game is over.",
                        JOptionPane.INFORMATION_MESSAGE);
                logic.refreshStatistics(1, 1);
            } else {
                JOptionPane.showMessageDialog(mainFrame,
                        logic.getName(1) + ", you got " + logic.getEndOfRoundPoints(1)
                                + " points!\n" + logic.getName(2) + ", you got "
                                + logic.getEndOfRoundPoints(2) + " points!",
                        "The game is over.",
                        JOptionPane.INFORMATION_MESSAGE);

                JOptionPane.showMessageDialog(mainFrame,
                        logic.getWinner(),
                        "See you next time!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            //this.logic = new GUILogic();
            this.mainFrame.dispose();
        }
        else {
            if (this.logic.isLastRound()) {
                JOptionPane.showMessageDialog(mainFrame,
                        logic.getKind(),
                        "Last Round",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(mainFrame,
                        logic.getKind(),
                        "Round " + logic.getCurrentRound(),
                        JOptionPane.INFORMATION_MESSAGE);
            }

            startQuestion();
        }
    }

    /**
     * This method starts a question after it checked that there exist more question to
     * the round they are. If there are not any, it informs the user(s)/ player(s) about
     * their current score and continues with the next round by calling the method startRound.
     * If there are more questions it shows the possible answers to them by calling the method
     * showAnswers, but firstly it checks if the kind of round is "Bet" and if so, it gets
     * from the player/s the points that they bet.
     */

    public void startQuestion() {
        if (this.logic.endOfQuestions()) {
            if (this.logic.getNumberOfPlayers() == 1)
                JOptionPane.showMessageDialog(mainFrame,
                        logic.getName(1) + ", you have "
                                + logic.getEndOfRoundPoints(1) + " points.",
                        "End Of The Round",
                        JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(mainFrame,
                        logic.getName(1) + ", you have "
                                + logic.getEndOfRoundPoints(1) + " points.\n"
                                + logic.getName(2) + ", you have "
                                + logic.getEndOfRoundPoints(2) + " points.\n",
                        "End Of The Round",
                        JOptionPane.INFORMATION_MESSAGE);
            this.logic.setCurrentRound();
            startRound();
        }
        else {
            this.mainPanel.setEnabled(false);
            this.mainPanel.setVisible(false);
            JOptionPane.showMessageDialog(mainFrame,
                    "Select an answer: ",
                    "Question " + logic.getCurrentQuestion(),
                    JOptionPane.INFORMATION_MESSAGE);
            if (this.logic.getKind().equals("Bet")) {
                Object[] betPoints = {250, 500, 750, 1000};
                int temp = JOptionPane.CLOSED_OPTION;

                if (logic.getNumberOfPlayers() == 1) {
                    while (temp == JOptionPane.CLOSED_OPTION) {
                        temp = JOptionPane.showOptionDialog(mainFrame,
                                logic.getName(1) + ": Bet 250, 500, 750 or 1000",
                                "\"" + logic.getCategory() + "\"",
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                betPoints,
                                betPoints[3]);
                    }
                    this.logic.setBets(1, (int) betPoints[temp]);
                }
                else {
                    while (temp == JOptionPane.CLOSED_OPTION) {
                        temp = JOptionPane.showOptionDialog(mainFrame,
                                logic.getName(1) + ": Bet 250, 500, 750 or 1000",
                                "\"" + logic.getCategory() + "\"",
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                betPoints,
                                betPoints[3]);
                    }
                    this.logic.setBets(1, (int) betPoints[temp]);

                    temp = JOptionPane.CLOSED_OPTION;
                    while (temp == JOptionPane.CLOSED_OPTION) {
                        temp = JOptionPane.showOptionDialog(mainFrame,
                                logic.getName(2) + ": Bet 250, 500, 750 or 1000",
                                "\"" + logic.getCategory() + "\"",
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                betPoints,
                                betPoints[3]);
                    }
                    this.logic.setBets(2, (int) betPoints[temp]);
                }
            }
            this.mainPanel.setEnabled(true);
            this.mainPanel.setVisible(true);
            showAnswers();
        }
    }

    /**
     * This method reset the texts to the answerBox that exists in the secondPanel and makes
     * possible to the player/s to see what are the answers to the the random question. It
     * also checks if the kind of the round is "Stop The Watch" and if so, it makes visible
     * the timer that counts for 5000 milliseconds to 0.
     */

    public void showAnswers() {
        this.questionLabel.setText(this.logic.getQuestion());
        setImage();

        this.answerBox.removeAll();
        this.answerBox.add(new JLabel(this.logic.getAPossibleAnswer(0)));
        this.answerBox.add(Box.createVerticalStrut(20));
        this.answerBox.add(new JLabel(this.logic.getAPossibleAnswer(1)));
        this.answerBox.add(Box.createVerticalStrut(20));
        this.answerBox.add(new JLabel(this.logic.getAPossibleAnswer(2)));
        this.answerBox.add(Box.createVerticalStrut(20));
        this.answerBox.add(new JLabel(this.logic.getAPossibleAnswer(3)));
        this.secondPanel.add(this.answerBox, BorderLayout.AFTER_LAST_LINE);

        Timer timer = new Timer(100, new ActionListener() {
            private int count = 5000;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count <= 0)
                    ((Timer) e.getSource()).stop();
                else
                    count -= 100;
                timeFliesBy.setText(Integer.toString(count));
            }
        });
        timer.start();
        this.timeFliesBy.setVisible(this.logic.getKind().equals("Stop The Watch"));
    }

    /**
     * This method shows the points or the correct answer depending on the kind of round when
     * a button from a player/s is pressed.
     *
     * @param numberOfPlayer is the unique number that the player that pressed the key has.
     * @param correctAnswer is true if the key that the player pressed is the correct answer
     *                      to the question and false if it is not.
     */

    public void showPoints(int numberOfPlayer, boolean correctAnswer) {
        this.logic.setPoints(numberOfPlayer, Integer.parseInt(timeFliesBy.getText())*0.2);
        if (this.logic.getNumberOfPlayers() == 1)
            this.timeFliesBy.setVisible(false);

        switch (this.logic.getKind()) {
            case "Correct Answer" -> {
                if (correctAnswer) {
                    if (numberOfPlayer == 1)
                        this.pointsLabel.setText(this.logic.getName(1) + " +1000");
                    else
                        this.pointsLabel2.setText(this.logic.getName(2) + " +1000");
                } else {
                    if (numberOfPlayer == 1)
                        this.pointsLabel.setText("");
                    else
                        this.pointsLabel2.setText("");
                }
            }
            case "Stop The Watch" -> {
                if (correctAnswer) {
                    if (numberOfPlayer == 1)
                        this.pointsLabel.setText(this.logic.getName(1) + " + The left time X 0.2");
                    else
                        this.pointsLabel2.setText(this.logic.getName(2) + " + The left time X 0.2");
                } else {
                    if (numberOfPlayer == 1)
                        this.pointsLabel.setText("");
                    else
                        this.pointsLabel2.setText("");
                }
            }
            case "Bet" -> {
                if (correctAnswer) {
                    if (numberOfPlayer == 1) {
                        this.pointsLabel.setText(this.logic.getName(1) + " +"
                                + this.logic.getBetPoints(1));
                    } else {
                        this.pointsLabel2.setText(logic.getName(2) + " +"
                                + logic.getBetPoints(2));
                    }
                    this.pointsLabel.setVisible(true);
                } else {
                    if (numberOfPlayer == 1)
                        this.pointsLabel.setText(logic.getName(1) + " -"
                                + logic.getBetPoints(1));
                    else
                        this.pointsLabel2.setText(logic.getName(2) + " -"
                                + logic.getBetPoints(2));
                }
            }
            case "Quick Answer" -> {
                if (correctAnswer && this.firstHere) {
                    if (numberOfPlayer == 1)
                        this.pointsLabel.setText(this.logic.getName(1) + " +1000");
                    else
                        this.pointsLabel2.setText(this.logic.getName(2) + " +1000");
                    this.firstHere = false;
                }
                else if (correctAnswer){
                    if (numberOfPlayer == 1)
                        this.pointsLabel.setText(this.logic.getName(1) + " +500");
                    else
                        this.pointsLabel2.setText(this.logic.getName(2) + " +500");
                    this.firstHere = true;
                }
                else
                    this.firstHere = true;
            }
            case "Thermometer" -> {
                if (correctAnswer) {
                    if (numberOfPlayer == 1)
                        this.pointsLabel.setText(this.logic.getName(1) + " +1 correct answer!");
                    else
                        this.pointsLabel2.setText(this.logic.getName(2) + " +1 correct answer!");
                } else {
                    if (numberOfPlayer == 1)
                        this.pointsLabel.setText("");
                    else
                        this.pointsLabel2.setText("");
                }
            }
        }

        if (this.logic.getNumberOfPlayers() == 2) {
            if (this.bothHere)
                this.bothHere = false;
            else {
                this.bothHere = true;
                this.timeFliesBy.setVisible(false);
                this.logic.setCurrentQuestion();
                startQuestion();
            }
        }
        else {
            this.logic.setCurrentQuestion();
            startQuestion();
        }
    }
}