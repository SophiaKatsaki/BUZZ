import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GUI2 {
    private JFrame firstFrame;
    private JFrame mainFrame;
    private JPanel firstPanel;
    private JPanel secondPanel;
    private JPanel mainPanel;
    private JPanel answerPanel;
    private JButton newGame;
    private JButton statistics;
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JLabel welcomeLabel;
    private JLabel imageLabel;
    private JLabel questionLabel;
    private JLabel answerLabel;
    private JLabel answerLabel2;
    private GUILogic logic;

    public GUI2() {
        logic = new GUILogic();

        mainFrame = new JFrame("BUZZ");
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(true);
        mainFrame.setSize(1200, 860);
        mainFrame.setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        mainPanel.setBackground(Color.WHITE);
        mainFrame.add(mainPanel, BorderLayout.CENTER);

        firstFrame = new JFrame("BUZZ");
        firstFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        firstFrame.setResizable(false);
        firstFrame.setSize(600, 430);
        firstFrame.setLocationRelativeTo(null);

        firstPanel = new JPanel();
        firstPanel.setVisible(true);
        firstPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        firstPanel.setBackground(Color.WHITE);
        firstFrame.add(firstPanel, BorderLayout.PAGE_START);

        secondPanel = new JPanel();
        secondPanel.setVisible(true);
        secondPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        secondPanel.setBackground(Color.WHITE);
        firstFrame.add(secondPanel, BorderLayout.CENTER);

        newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame.setEnabled(false);
                newGame();
            }
        });
        firstPanel.add(newGame);

        statistics = new JButton("Statistics");
        statistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStatistics();
            }
        });
        firstPanel.add(statistics);

        welcomeLabel = new JLabel("Hello and welcome to the best game ever...BUZZ!");
        welcomeLabel.setVisible(true);
        firstPanel.add(welcomeLabel);

        ImageIcon icon = new ImageIcon(getClass().getResource("openingImage.jpg"));
        imageLabel = new JLabel(icon);
        imageLabel.setVisible(true);
        secondPanel.add(imageLabel);
        firstFrame.setIconImage(icon.getImage());
        mainFrame.setIconImage(icon.getImage());

        buttonA = new JButton("A");
        buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logic.game.getNumberOfPlayers() == 1)
                    logic.player1.setNumberOfAnswer(1);
                button(buttonA);
            }
        });

        buttonB = new JButton("B");
        buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logic.game.getNumberOfPlayers() == 1)
                    logic.player1.setNumberOfAnswer(2);
                button(buttonB);
            }
        });

        buttonC = new JButton("C");
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logic.game.getNumberOfPlayers() == 1)
                    logic.player1.setNumberOfAnswer(3);
                button(buttonC);
            }
        });

        buttonD = new JButton("D");
        buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logic.game.getNumberOfPlayers() == 1)
                    logic.player1.setNumberOfAnswer(4);
                button(buttonD);
            }
        });

        Box box = Box.createVerticalBox();
        box.add(buttonA);
        box.add(buttonB);
        box.add(buttonC);
        box.add(buttonD);
        mainPanel.add(box, BorderLayout.CENTER);

        mainFrame.setFocusable(true);
        mainFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '1') {
                    logic.player1.setNumberOfAnswer(1);
                    buttonA.doClick();
                }
                else if (e.getKeyChar() == '6') {
                    logic.player2.setNumberOfAnswer(6);
                    buttonA.doClick();
                }
                else if (e.getKeyChar() == '2') {
                    logic.player1.setNumberOfAnswer(2);
                    buttonB.doClick();
                }
                else if (e.getKeyChar() == '7') {
                    logic.player2.setNumberOfAnswer(7);
                    buttonB.doClick();
                }
                else if (e.getKeyChar() == '3') {
                    logic.player1.setNumberOfAnswer(3);
                    buttonC.doClick();
                }
                else if (e.getKeyChar() == '8') {
                    logic.player2.setNumberOfAnswer(8);
                    buttonC.doClick();
                }
                else if (e.getKeyChar() == '4') {
                    logic.player1.setNumberOfAnswer(4);
                    buttonD.doClick();
                }
                else if (e.getKeyChar() == '9') {
                    logic.player2.setNumberOfAnswer(9);
                    buttonD.doClick();
                }
            }
        });

        questionLabel = new JLabel();
        questionLabel.setVisible(false);
        questionLabel.setForeground(Color.BLACK);
        mainPanel.add(questionLabel, BorderLayout.PAGE_START);

        answerLabel = new JLabel();
        answerLabel.setVisible(false);
        answerLabel.setForeground(Color.BLACK);

        answerLabel2 = new JLabel();
        answerLabel2.setVisible(false);
        answerLabel2.setForeground(Color.BLACK);

        Box box2 = Box.createVerticalBox();
        box.add(answerLabel);
        box.add(answerLabel2);
        mainPanel.add(box2, BorderLayout.CENTER);
    }

    public void start (Frame frame) {
        frame.setVisible(true);
    }

    public void showStatistics() {
        Object[] statistics = {"Solo Game", "Game With A Friend"};
        int temp = JOptionPane.showOptionDialog(this.firstFrame,
                "What mode do you want?",
                "Statistics",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                statistics,
                statistics[1]);

        try (BufferedReader reader = new BufferedReader(new
                FileReader("src/Statistics.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (temp == 0 && line.contains("Solo Game")) {
                    JOptionPane.showMessageDialog(this.firstFrame,
                            reader.readLine(),
                            "Solo Game",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                else if (temp == 1 && line.contains("Multiplayer")) {
                    JOptionPane.showMessageDialog(this.firstFrame,
                            reader.readLine() + "\n" + reader.readLine(),
                            "Multiplayer",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void newGame() {
        JFrame secondFrame = new JFrame("BUZZ");
        secondFrame.setVisible(true);
        secondFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        secondFrame.setResizable(false);
        secondFrame.setSize(600, 430);
        secondFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("openingImage.jpg"));
        secondFrame.setIconImage(icon.getImage());

        JPanel endPanel = new JPanel();
        endPanel.setVisible(true);
        endPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        endPanel.setBackground(Color.WHITE);
        secondFrame.add(endPanel, BorderLayout.PAGE_END);
        JLabel label = new JLabel();
        label.setVisible(true);
        endPanel.add(label);

        JPanel topPanel = new JPanel();
        topPanel.setVisible(true);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        topPanel.setBackground(Color.WHITE);
        secondFrame.add(topPanel, BorderLayout.PAGE_START);
        JLabel enterLabel = new JLabel();
        enterLabel.setVisible(true);
        topPanel.add(enterLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.setVisible(true);
        centerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        centerPanel.setBackground(Color.WHITE);
        secondFrame.add(centerPanel, BorderLayout.CENTER);
        JButton ready = new JButton("Ready to play");
        ready.setVisible(false);
        centerPanel.add(ready);

        Object[] options = {"Solo Game", "Game With A Friend"};
        int temp = JOptionPane.CLOSED_OPTION;

        while (temp == JOptionPane.CLOSED_OPTION) {
            temp = JOptionPane.showOptionDialog(secondFrame,
                    "Well..we need to know if you want to play solo or with an opponent.",
                    "BUZZ",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
        }

        switch (temp) {
            case 0 -> {
                logic.game.setNumberOfPlayers(1);
                label.setText("Solo game is chosen! The only one who can win you is yourself!");
                enterLabel.setText("Enter your name: ");
                JTextField textField = new JTextField(30);
                topPanel.add(textField);
                ready.setVisible(true);
                ready.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        logic.player1.setName(textField.getText());
                        secondFrame.dispose();
                        setRounds();
                    }
                });
            }
            case 1 -> {
                logic.game.setNumberOfPlayers(2);
                label.setText("I see two players in here! Only one will be the master of BUZZ!");
                enterLabel.setText("Enter your names: ");
                JTextField textField = new JTextField(30);
                JTextField secondTextField = new JTextField(30);
                Box box = Box.createVerticalBox();
                box.add(textField);
                box.add(secondTextField);
                topPanel.add(box);
                ready.setVisible(true);
                ready.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        logic.player1.setName(textField.getText());
                        logic.player2.setName(secondTextField.getText());
                        secondFrame.dispose();
                        setRounds();
                    }
                });
            }
        }

        secondFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                newGame.setEnabled(true);
            }
        });
    }

    public void setRounds () {
        JFrame secondFrame = new JFrame("BUZZ");
        secondFrame.setVisible(true);
        secondFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        secondFrame.setResizable(false);
        secondFrame.setSize(600, 430);
        secondFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("openingImage.jpg"));
        secondFrame.setIconImage(icon.getImage());

        JPanel topPanel = new JPanel();
        topPanel.setVisible(true);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        topPanel.setBackground(Color.WHITE);
        secondFrame.add(topPanel, BorderLayout.PAGE_START);
        JLabel write = new JLabel();
        write.setVisible(true);
        topPanel.add(write);
        JButton ready = new JButton("Ready");
        ready.setVisible(false);
        topPanel.add(ready);

        String text;
        if (logic.game.getNumberOfPlayers() == 1)
            text = "Welcome " + logic.player1.getName() + "!";
        else
            text = "Welcome " + logic.player1.getName() + " and " + logic.player2.getName() + "!";

        Object[] options = {"Select Rounds", "Random Rounds"};
        int temp = JOptionPane.CLOSED_OPTION;

        while (temp == JOptionPane.CLOSED_OPTION) {
            temp = JOptionPane.showOptionDialog(secondFrame,
                    "Select one of the following.",
                    text,
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
        }

        switch (temp) {
            case 0 -> {
                Object[] secondOptions = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                int temp2 = JOptionPane.CLOSED_OPTION;

                while (temp2 == JOptionPane.CLOSED_OPTION) {
                    temp2 = JOptionPane.showOptionDialog(secondFrame,
                            "Write how many rounds you want from 1 to 10",
                            "Almost Ready",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            secondOptions,
                            secondOptions[9]);
                }

                logic.game.setNumberOfRounds((int) secondOptions[temp2]);
                write.setText("Your rounds will be: " + logic.game.getNumberOfRounds() + ".");
                ready.setVisible(true);
                ready.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        secondFrame.dispose();
                        gameREALLYStart();
                    }
                });
            }
            case 1 -> {
                logic.game.setRandomRounds();
                write.setText("We have decided that your round/s will be: " + logic.game.getNumberOfRounds()+".");
                ready.setVisible(true);
                ready.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        secondFrame.dispose();
                        gameREALLYStart();
                    }
                });

            }
        }

        secondFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                newGame.setEnabled(true);
            }
        });
    }

    public void gameREALLYStart() {
        newGame.setEnabled(false);
        start(mainFrame);

        answerLabel.setVisible(false);
        answerLabel2.setVisible(false);

        if (logic.game.getCurrentRound() <= logic.game.getNumberOfRounds()) {
            logic.makeRound();

            if (logic.game.getCurrentRound() == logic.game.getNumberOfRounds())
                JOptionPane.showMessageDialog(mainFrame, "Round " + logic.game.getCurrentRound()
                        + "\n" + "Last Round");
            else
                JOptionPane.showMessageDialog(mainFrame, "Round " + logic.game.getCurrentRound());

            JLabel kindLabel = new JLabel(logic.round.getKind());
            kindLabel.setVisible(true);
            mainPanel.add(kindLabel, BorderLayout.PAGE_START);

            gameStart();
        }
        else {
            JOptionPane.showMessageDialog(mainFrame, "The game is over.");

            answerLabel.setText(logic.player1.getName() + ", you got " + logic.player1.getPoints() + " points.");
            answerLabel.setVisible(true);
            if (logic.game.getNumberOfPlayers() == 2) {
                answerLabel2.setText(logic.player2.getName() + ", you got " + logic.player2.getPoints() + " points.");
                answerLabel2.setVisible(true);
            }

            if (logic.game.getNumberOfPlayers() == 2) {
                if (logic.makeWinner() == 1)
                    JOptionPane.showMessageDialog(mainFrame, logic.player1.getName() + ", you won!");
                else if (logic.makeWinner() == 2)
                    JOptionPane.showMessageDialog(mainFrame, logic.player2.getName() + ", you won!");
                else
                    JOptionPane.showMessageDialog(mainFrame, "Tie!");
            }

            JOptionPane.showMessageDialog(mainFrame, "See you next time!");

            logic = new GUILogic();
            mainPanel = new JPanel();
            newGame.setEnabled(true);
            mainFrame.dispose();
        }

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                logic = new GUILogic();
                mainPanel = new JPanel();
                //maybe we will not need the dispose()
                mainFrame.dispose();
                newGame.setEnabled(true);
            }
        });
    }

    public void gameStart() {
        answerPanel = new JPanel(new GridLayout(4, 1));
        answerPanel.setVisible(true);
        answerPanel.setBackground(Color.WHITE);

        questionLabel.setVisible(true);
        //maybe dont need this
        answerLabel.setVisible(false);
        answerLabel2.setVisible(false);

        if (logic.round.getCurrentNumberOfQuestion() <= logic.round.getRandomNumberOfQuestions()) {
            logic.setQA();

            if (logic.round.getKind().equals("Bet")) {
                if (logic.game.getNumberOfPlayers() == 1)
                    betPoints(1);
                else {
                    betPoints(1);
                    betPoints(2);
                }
            }

            questionLabel.setText(logic.question.getRandomQuestion());

            answerPanel.add(new JLabel(logic.answer.getFourPossibleAnswers().get(0)));
            answerPanel.add(new JLabel(logic.answer.getFourPossibleAnswers().get(1)));
            answerPanel.add(new JLabel(logic.answer.getFourPossibleAnswers().get(2)));
            answerPanel.add(new JLabel(logic.answer.getFourPossibleAnswers().get(3)));
            mainPanel.add(answerPanel);
        }
        else {
            answerLabel.setText(logic.player1.getName() + ", you have " + logic.player1.getPoints() + " points.");
            answerLabel.setVisible(true);
            if (logic.game.getNumberOfPlayers() == 2) {
                answerLabel2.setText(logic.player2.getName() + ", you have " + logic.player2.getPoints() + " points.");
                answerLabel2.setVisible(true);
            }

            logic.game.setCurrentRound();
            gameREALLYStart();
        }

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                logic = new GUILogic();
                mainPanel = new JPanel();
                //maybe we will not need the dispose()
                mainFrame.dispose();
                newGame.setEnabled(true);
            }
        });
    }

    public void betPoints(int numberOfPlayer) {
        mainPanel.setEnabled(false);
        mainPanel.setVisible(false);

        Object[] betPoints = {250, 500, 750, 1000};
        int temp = JOptionPane.CLOSED_OPTION;

        while (temp == JOptionPane.CLOSED_OPTION) {
            temp = JOptionPane.showOptionDialog(mainFrame,
                    logic.player1.getName() + ": Bet 250, 500, 750 or 1000",
                    "\"" + logic.question.getCategory() + "\"",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    betPoints,
                    betPoints[3]);
        }

        if (logic.player1.getPlayerNumber() == numberOfPlayer)
            logic.player1.setBetPoints((int) betPoints[temp]);
        else
            logic.player2.setBetPoints((int) betPoints[temp]);

        mainPanel.setEnabled(true);
        mainPanel.setVisible(true);
    }
    public void button(JButton buttonPressed) {
        buttonPressed.setBackground(Color.YELLOW);
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        logic.answer.setCorrectAnswer(logic.player1.getNumberOfAnswer(),
                logic.question.getNumberOfRandomQuestionInArray());
        if (logic.game.getNumberOfPlayers() == 2)
            logic.answer.setCorrectAnswer(logic.player2.getNumberOfAnswer(),
                    logic.question.getNumberOfRandomQuestionInArray());

        getPoints(buttonPressed, logic.player1.getPlayerNumber());
        if (logic.game.getNumberOfPlayers() == 2)
            getPoints(buttonPressed, logic.player2.getPlayerNumber());
    }

    public void getPoints (JButton buttonPressed, int numberOfPlayer) {
        switch (logic.round.getKind()) {
            case "Correct Answer" -> {
                if (logic.answer.getCorrectAnswer()) {
                    if (numberOfPlayer == 1) {
                        logic.player1.winPoints(1000);
                        answerLabel.setText(logic.player1.getName() + " +1000");
                        answerLabel.setVisible(true);
                    }
                    else {
                        logic.player2.winPoints(1000);
                        answerLabel2.setText(logic.player2.getName() + " +1000");
                        answerLabel2.setVisible(true);
                    }
                }
            }
            case "Stop The Watch" -> {

            }
            case "Bet" -> {
                if (logic.answer.getCorrectAnswer()) {
                    if (numberOfPlayer == 1) {
                        logic.player1.winPoints(logic.player1.getBetPoints());
                        answerLabel.setText(logic.player1.getName() + " +" + logic.player1.getBetPoints());
                    }
                    else {
                        logic.player2.winPoints(logic.player2.getBetPoints());
                        answerLabel2.setText(logic.player2.getName() + " +" + logic.player2.getBetPoints());
                    }
                }
                else {
                    if (numberOfPlayer == 1) {
                        logic.player1.losePoints(logic.player1.getBetPoints());
                        answerLabel.setText(logic.player1.getName() + " -" + logic.player1.getBetPoints());
                    }
                    else {
                        logic.player2.losePoints(logic.player2.getBetPoints());
                        answerLabel2.setText(logic.player2.getName() + " -" + logic.player2.getBetPoints());
                    }
                }
                answerLabel.setVisible(true);
                answerLabel2.setVisible(true);
            }
            case "Quick Answer" -> {

            }
            case "Thermometer" -> {

            }
        }

        answerPanel.removeAll();

        logic.round.setCurrentNumberOfQuestion();

        logic.question.questions.clear();
        logic.question.categories.clear();
        logic.question.possibleAnswers.clear();

        buttonPressed.setBackground(new JButton().getBackground());
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);

        //wait before hide points again MUST DONE
        gameStart();
    }

    public void game () {
        answerLabel.setVisible(false);
        answerLabel2.setVisible(false);

        if (logic.round.getCurrentNumberOfQuestion() <= logic.round.getRandomNumberOfQuestions()) {
            logic.setQA();

            if (logic.round.getKind().equals("Bet")) {
                mainPanel.setEnabled(false);
                mainPanel.setVisible(false);
                Object[] betPoints = {250, 500, 750, 1000};
                int temp = JOptionPane.CLOSED_OPTION;

                while (temp == JOptionPane.CLOSED_OPTION) {
                    temp = JOptionPane.showOptionDialog(mainFrame,
                            logic.player1.getName() + ": Bet 250, 500, 750 or 1000",
                            "\"" + logic.question.getCategory() + "\"",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            betPoints,
                            betPoints[3]);
                }
                logic.player1.setBetPoints((int) betPoints[temp]);
                mainPanel.setEnabled(true);
                mainPanel.setVisible(true);
            }

            questionLabel.setText(logic.question.getRandomQuestion());

            answerPanel.add(new JLabel(logic.answer.getFourPossibleAnswers().get(0)));
            answerPanel.add(new JLabel(logic.answer.getFourPossibleAnswers().get(1)));
            answerPanel.add(new JLabel(logic.answer.getFourPossibleAnswers().get(2)));
            answerPanel.add(new JLabel(logic.answer.getFourPossibleAnswers().get(3)));
            mainPanel.add(answerPanel);
        }
    }

    public static void main(String[] args) {
        GUI2 BuzzApp = new GUI2();
        BuzzApp.start(BuzzApp.firstFrame);
    }
}