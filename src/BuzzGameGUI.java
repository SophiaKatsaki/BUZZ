import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BuzzGameGUI {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JLabel questionLabel;
    private JLabel pointsLabel;
    private JLabel pointsLabel2;
    private GUILogic logic;

    public BuzzGameGUI(GUILogic logic) {
        this.logic = logic;

        mainFrame = new JFrame("BUZZ");
        this.mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(true);
        mainFrame.setSize(1200, 860);
        mainFrame.setLocationRelativeTo(null);

        this.mainPanel = new JPanel();
        this.mainPanel.setVisible(false);
        this.mainPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.mainPanel.setBackground(Color.WHITE);
        this.mainFrame.add(this.mainPanel);

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
        this.mainPanel.add(box, BorderLayout.CENTER);

        this.mainFrame.setFocusable(true);
        this.mainFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '1') {
                    logic.setAnswer(1, 1);
                    logic.checkCorrectAnswer(1);
                    showPoints(1);
                    buttonA.doClick();
                } else if (e.getKeyChar() == '6') {
                    logic.setAnswer(6, 2);
                    logic.checkCorrectAnswer(2);
                    showPoints(2);
                    buttonA.doClick();
                } else if (e.getKeyChar() == '2') {
                    logic.setAnswer(2, 1);
                    logic.checkCorrectAnswer(1);
                    showPoints(1);
                    buttonB.doClick();
                } else if (e.getKeyChar() == '7') {
                    logic.setAnswer(7, 2);
                    logic.checkCorrectAnswer(2);
                    showPoints(2);
                    buttonB.doClick();
                } else if (e.getKeyChar() == '3') {
                    logic.setAnswer(3, 1);
                    logic.checkCorrectAnswer(1);
                    showPoints(1);
                    buttonC.doClick();
                } else if (e.getKeyChar() == '8') {
                    logic.setAnswer(8, 2);
                    logic.checkCorrectAnswer(2);
                    showPoints(2);
                    buttonC.doClick();
                } else if (e.getKeyChar() == '4') {
                    logic.setAnswer(4, 1);
                    logic.checkCorrectAnswer(1);
                    showPoints(1);
                    buttonD.doClick();
                } else if (e.getKeyChar() == '9') {
                    logic.setAnswer(9, 2);
                    logic.checkCorrectAnswer(2);
                    showPoints(2);
                    buttonD.doClick();
                }
            }
        });

        this.questionLabel = new JLabel();
        this.questionLabel.setVisible(false);
        this.questionLabel.setForeground(Color.BLACK);

        this.pointsLabel = new JLabel();
        this.pointsLabel.setVisible(false);
        this.pointsLabel.setForeground(Color.BLACK);

        this.pointsLabel2 = new JLabel();
        this.pointsLabel2.setVisible(false);
        this.pointsLabel2.setForeground(Color.BLACK);

        Box box2 = Box.createVerticalBox();
        box.add(this.questionLabel);
        box.add(this.pointsLabel);
        box.add(this.pointsLabel2);
        this.mainPanel.add(box2, BorderLayout.PAGE_START);

        startRound();
    }

    public void button(JButton button) {
        if (this.logic.getNumberOfPlayers() == 1) {
            this.logic.checkCorrectAnswer(1);
        } else {}
    }

    public void startRound() {
        if (this.logic.endOfRounds()) {
            if (logic.getNumberOfPlayers() == 1) {
                JOptionPane.showMessageDialog(mainFrame,
                        logic.getName(1) + ", you got " +
                        logic.getPoints(1) + " points.",
                        "The game is over.",
                        JOptionPane.INFORMATION_MESSAGE);
                logic.refreshStatistics(1, 1);

                this.mainFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(mainFrame,
                        logic.getName(1) + ", you got " + logic.getPoints(1)
                        + " points!\n" + logic.getName(2) + ", you got "
                        + logic.getPoints(2) + " points!",
                        "The game is over.",
                        JOptionPane.INFORMATION_MESSAGE);

                JOptionPane.showMessageDialog(mainFrame,
                        logic.getWinner(),
                        "See you next time!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
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

            //watch
            this.logic.setCurrentRound();
            startQuestion();
        }
    }

    public void startQuestion() {
        if (this.logic.endOfQuestions()) {
            JOptionPane.showMessageDialog(mainFrame,
                    logic.getName(1) + ", you have "
                    + logic.getEndOfRoundPoints(1) + " points.",
                    "End Of The Round",
                    JOptionPane.INFORMATION_MESSAGE);
            if (this.logic.getNumberOfPlayers() == 2)
                JOptionPane.showMessageDialog(mainFrame,
                        logic.getName(2) + ", you have "
                        + logic.getEndOfRoundPoints(2) + " points.",
                        "End Of The Round",
                        JOptionPane.INFORMATION_MESSAGE);
            //watch
            //this.logic.setCurrentRound();
            startRound();
        }
        else {
            JOptionPane.showMessageDialog(mainFrame,
                    "Select an answer: ",
                    "Question " + logic.getCurrentQuestion(),
                    JOptionPane.INFORMATION_MESSAGE);
            if (this.logic.getKind().equals("Bet")) {
                this.mainPanel.setEnabled(false);
                this.mainPanel.setVisible(false);
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
                    logic.setBets(1, (int) betPoints[temp]);
                    mainPanel.setEnabled(true);
                    mainPanel.setVisible(true);
                } else {
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
                    logic.setBets(1, (int) betPoints[temp]);

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
                    logic.setBets(2, (int) betPoints[temp]);
                }
            }
            mainPanel.setEnabled(true);
            mainPanel.setVisible(true);

            showAnswers();
        }
    }

    public void showAnswers() {
        JPanel answerPanel = new JPanel(new GridLayout(4, 1));
        answerPanel.setVisible(true);
        answerPanel.setBackground(Color.WHITE);
        answerPanel.add(new JLabel(this.logic.getAPossibleAnswer(0)));
        answerPanel.add(new JLabel(this.logic.getAPossibleAnswer(1)));
        answerPanel.add(new JLabel(this.logic.getAPossibleAnswer(2)));
        answerPanel.add(new JLabel(this.logic.getAPossibleAnswer(3)));

        mainPanel.add(answerPanel, BorderLayout.CENTER);
        this.questionLabel.setText(this.logic.getQuestion());
        this.questionLabel.setVisible(true);
    }

    public void showPoints(int numberOfPlayer) {
        switch (this.logic.getKind()) {
            case "Correct Answer" -> {
                if (this.logic.getCorrectAnswer()) {
                    if (numberOfPlayer == 1) {
                        this.pointsLabel.setText(this.logic.getName(2) + " +1000");
                        this.pointsLabel.setVisible(true);
                    } else {
                        this.pointsLabel2.setText(this.logic.getName(2) + " +1000");
                        this.pointsLabel2.setVisible(true);
                    }
                }
            }
            case "Stop The Watch" -> {}
            case "Bet" -> {
                if (this.logic.getCorrectAnswer()) {
                    if (numberOfPlayer == 1) {
                        this.pointsLabel.setText(this.logic.getName(1) + " +"
                                                 + this.logic.getPoints(1));
                    } else {
                        this.pointsLabel2.setText(logic.getName(2) + " +"
                                                  + logic.getPoints(2));
                    }
                    this.pointsLabel.setVisible(true);
                } else {
                    if (numberOfPlayer == 1) {
                        this.pointsLabel.setText(logic.getName(1) + " -"
                                                 + logic.getPoints(1));
                    } else {
                        this.pointsLabel2.setText(logic.getName(2) + " -"
                                                  + logic.getPoints(2));
                    }
                    this.pointsLabel.setVisible(true);
                    this.pointsLabel2.setVisible(true);
                }
            }
            case "Quick Answer" -> {}
            case "Thermometer" -> {}
        }

        this.logic.setCurrentQuestion();
        startQuestion();
    }
}
