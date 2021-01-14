import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BuzzGameGUI {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel answerPanel;
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
    private GUILogic logic;
    private boolean bothHere = true;
    private boolean firstHere = true;

    public BuzzGameGUI(GUILogic logic) {
        this.logic = logic;

        this.mainFrame = new JFrame("BUZZ");
        this.mainFrame.setVisible(true);
        this.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.mainFrame.setResizable(true);
        this.mainFrame.setSize(650, 450);
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
                button(buttonA);
            }
        });

        this.buttonB = new JButton("B");
        this.buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button(buttonB);
            }
        });

        this.buttonC = new JButton("C");
        this.buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button(buttonC);
            }
        });

        this.buttonD = new JButton("D");
        this.buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button(buttonD);
            }
        });

        Box box = Box.createVerticalBox();
        box.add(this.buttonA);
        box.add(this.buttonB);
        box.add(this.buttonC);
        box.add(this.buttonD);
        this.secondPanel.add(box);

        this.mainFrame.setFocusable(true);
        this.mainFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '1') {
                    showPoints(1, logic.checkCorrectAnswer(1, 1,
                            Integer.parseInt(timeFliesBy.getText())*0.2));
                    buttonA.doClick();
                } else if (e.getKeyChar() == '6') {
                    showPoints(2, logic.checkCorrectAnswer(2, 6,
                            Integer.parseInt(timeFliesBy.getText())*0.2));
                    buttonA.doClick();
                } else if (e.getKeyChar() == '2') {
                    showPoints(1, logic.checkCorrectAnswer(1, 2,
                            Integer.parseInt(timeFliesBy.getText())*0.2));
                    buttonB.doClick();
                } else if (e.getKeyChar() == '7') {
                    showPoints(2, logic.checkCorrectAnswer(2, 7,
                            Integer.parseInt(timeFliesBy.getText())*0.2));
                    buttonB.doClick();
                } else if (e.getKeyChar() == '3') {
                    showPoints(1, logic.checkCorrectAnswer(1, 3,
                            Integer.parseInt(timeFliesBy.getText())*0.2));
                    buttonC.doClick();
                } else if (e.getKeyChar() == '8') {
                    showPoints(2, logic.checkCorrectAnswer(2, 8,
                            Integer.parseInt(timeFliesBy.getText())*0.2));
                    buttonC.doClick();
                } else if (e.getKeyChar() == '4') {
                    showPoints(1, logic.checkCorrectAnswer(1, 4,
                            Integer.parseInt(timeFliesBy.getText())*0.2));
                    buttonD.doClick();
                } else if (e.getKeyChar() == '9') {
                    showPoints(2, logic.checkCorrectAnswer(2, 9,
                            Integer.parseInt(timeFliesBy.getText())*0.2));
                    buttonD.doClick();
                }
            }
        });

        this.answerPanel = new JPanel(new GridLayout(4, 1));
        this.answerPanel.setBackground(Color.WHITE);
        this.answerPanel.add(new JLabel());
        this.answerPanel.add(new JLabel());
        this.answerPanel.add(new JLabel());
        this.answerPanel.add(new JLabel());
        this.secondPanel.add(this.answerPanel);

        this.timeFliesBy = new JLabel();
        this.thirdPanel.add(this.timeFliesBy);
        this.timeFliesBy.setHorizontalAlignment(JLabel.CENTER);

        this.pointsLabel = new JLabel();
        this.pointsLabel.setForeground(Color.BLACK);
        this.pointsLabel2 = new JLabel();
        this.pointsLabel2.setForeground(Color.BLACK);

        Box box2 = Box.createVerticalBox();
        box.add(this.pointsLabel);
        box.add(this.pointsLabel2);
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

    public void setMainPanel() {
        this.firstPanel = new JPanel(new GridLayout(1,2));
        this.firstPanel.setBackground(Color.YELLOW);
        this.mainPanel.add(this.firstPanel);

        this.questionLabel = new JLabel();
        this.questionLabel.setForeground(Color.BLACK);
        this.firstPanel.add(this.questionLabel);

        this.imageLabel = new JLabel();
        this.firstPanel.add(this.imageLabel);

        this.secondPanel = new JPanel(new GridLayout(1,2));
        this.secondPanel.setBackground(Color.WHITE);
        this.mainPanel.add(this.secondPanel);

        this.thirdPanel = new JPanel(new GridLayout(1,3));
        this.thirdPanel.setBackground(Color.WHITE);
        this.mainPanel.add(this.thirdPanel);
    }

    public void button(JButton button) {
        if (this.logic.getNumberOfPlayers() == 1) {
        } else {}
    }

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

    public void showAnswers() {
        this.questionLabel.setText(this.logic.getQuestion());
        setImage();

        this.answerPanel.removeAll();
        this.answerPanel.add(new JLabel(this.logic.getAPossibleAnswer(0)));
        this.answerPanel.add(new JLabel(this.logic.getAPossibleAnswer(1)));
        this.answerPanel.add(new JLabel(this.logic.getAPossibleAnswer(2)));
        this.answerPanel.add(new JLabel(this.logic.getAPossibleAnswer(3)));
        this.secondPanel.add(this.answerPanel);

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

    public void showPoints(int numberOfPlayer, boolean correctAnswer) {
        switch (this.logic.getKind()) {
            case "Correct Answer" -> {
                if (correctAnswer) {
                    if (numberOfPlayer == 1)
                        this.pointsLabel.setText(this.logic.getName(1) + " +1000");
                    else
                        this.pointsLabel2.setText(this.logic.getName(2) + " +1000");
                }
            }
            case "Stop The Watch" -> {
                if (correctAnswer) {
                    if (numberOfPlayer == 1)
                        this.pointsLabel.setText(this.logic.getName(1) + " + The left time X 0.2");
                    else
                        this.pointsLabel2.setText(this.logic.getName(2) + " + The left time X 0.2");
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
                }
            }
        }

        if (this.logic.getNumberOfPlayers() == 2) {
            if (this.bothHere)
                this.bothHere = false;
            else {
                this.bothHere = true;
                this.logic.setCurrentQuestion();
                startQuestion();
            }
        }
        else {
            this.logic.setCurrentQuestion();
            startQuestion();
        }
    }

    public void setImage() {
        ImageIcon icon;
        if(!this.logic.getImage().equals(""))
            icon = new ImageIcon(getClass().getResource(this.logic.getImage()));
        else
            icon = new ImageIcon(getClass().getResource("openingImage.jpg"));

        Image image = icon.getImage().getScaledInstance(220, 180, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        image.flush();
        this.imageLabel.setIcon(icon);
        this.firstPanel.add(this.imageLabel);
    }
}