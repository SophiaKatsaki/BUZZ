import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI {
    private JFrame beginTheGameFrame;
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    private JButton newGame;
    private JButton statistics;
    private JButton soloGame;
    private JButton gameWithFriend;
    private JButton soloGame2;
    private JButton gameWithFriend2;
    private JButton s_rounds_solo;
    private JButton r_rounds_solo;
    private JButton s_rounds_two;
    private JButton r_rounds_two;
    private JLabel label;
    private JLabel label2;
    private JTextField InputOfFirstName;
    private JTextField InputOfSecondName;
    private Player player1;
    private Player player2;
    private Game game;

    public GUI()
    {
        beginTheGameFrame = new JFrame("BUZZ");
        beginTheGameFrame.setVisible(true);
        beginTheGameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        beginTheGameFrame.setResizable(true);
        beginTheGameFrame.setSize(500, 270);
        beginTheGameFrame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setVisible(true);
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel.setBackground(Color.cyan);
        beginTheGameFrame.add(panel, BorderLayout.PAGE_START);

        newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });
        panel.add(newGame);

        statistics = new JButton("Statistics");
        statistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"BOOM!You wanted statistics");

            }
        });
        panel.add(statistics);

        panel2 = new JPanel();
        panel2.setVisible(true);
        panel2.setBackground(Color.white);
        beginTheGameFrame.add(panel2, BorderLayout.CENTER);

        label=new JLabel("Hello and welcome to the best game ever...BUZZ!");
        label.setVisible(true);
        label2=new JLabel("You can try 'Challenge For One' or play with a friend.");
        label2.setVisible(true);

        label.setForeground(Color.black);
        label2.setForeground(Color.black);
        panel2.add(label);
        panel2.add(label2);
    }
    private void newGame()
    {
        newGame.setVisible(true);

        JFrame frame2=new JFrame("BUZZ");
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setResizable(true);
        frame2.setSize(500, 270);
        frame2.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setVisible(true);
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel.setBackground(Color.white);
        frame2.add(panel, BorderLayout.PAGE_END);

        soloGame =new JButton("Solo Game");
        soloGame.setVisible(true);
        gameWithFriend =new JButton("Game With A Friend");
        gameWithFriend.setVisible(true);
        panel.add(soloGame);
        panel.add(gameWithFriend);

        panel2=new JPanel();
        panel2 = new JPanel();
        panel2.setVisible(true);
        panel2.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel2.setBackground(Color.white);
        frame2.add(panel2,BorderLayout.CENTER);
        label=new JLabel("Well..we need to know if you want to play solo or with an opponent.");
        label.setForeground(Color.black);

        panel2.add(label);

        soloGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soloGame();
            }
        });

        gameWithFriend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWithFriend();
            }
        });
    }

    private void soloGame()
    {
        soloGame.setVisible(false);
        gameWithFriend.setVisible(false);

        label.setText("Solo game is chosen!The only one who can win you is yourself!");
        panel.add(label);
        panel3=new JPanel(new GridLayout(3,1,4,5));
        label2=new JLabel("Enter your name");
        panel3.add(label2);

        InputOfFirstName =new JTextField(30);
        panel3.add(InputOfFirstName);

        soloGame2 =new JButton("Ready to play");
        soloGame2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soloGame2();
            }
        });
        panel3.add(soloGame2);
        panel2.add(panel3);
    }

    private void gameWithFriend()
    {
        soloGame.setVisible(false);
        gameWithFriend.setVisible(false);

        label.setText("I see two players in here!Only one will be the master of BUZZ!");
        panel.add(label);
        label2=new JLabel("Enter your names");
        panel3=new JPanel(new GridLayout(4,1,4,5));
        panel3.add(label2);

        InputOfFirstName =new JTextField(30);
        InputOfSecondName =new JTextField(30);
        panel3.add(InputOfFirstName);
        panel3.add(InputOfSecondName);


        gameWithFriend2 =new JButton("Ready to play");
        gameWithFriend2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWithFriend2();
            }
        });
        panel3.add(gameWithFriend2);
        panel2.add(panel3);
    }

    private void soloGame2()
    {
        panel3.setVisible(false);
        label2.setVisible(false);
        InputOfFirstName.setVisible(false);
        soloGame2.setVisible(false);

        player1=new Player(1);
        player1.setName(InputOfFirstName.getText());

        label2=new JLabel("Welcome "+player1.getName()+"!Select one of the following.");

        game=new Game();
        game.setAnswer(2);
        game.setNumberOfPlayers(1);

        panel2.add(label2);
        panel3=new JPanel(new GridLayout(3,1,4,5));
        panel3.add(label2);
        panel2.add(panel3);

        s_rounds_solo=new JButton("Select Rounds");
        s_rounds_solo.setVisible(true);
        r_rounds_solo=new JButton("Random Rounds");
        r_rounds_solo.setVisible(true);

        s_rounds_solo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s_rounds_solo();
            }
        });
        panel3.add(s_rounds_solo);

        r_rounds_solo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r_rounds_solo();
            }
        });
        panel3.add(r_rounds_solo);

    }

    private void gameWithFriend2()
    {
        panel3.setVisible(false);
        label2.setVisible(false);

        InputOfFirstName.setVisible(false);
        InputOfSecondName.setVisible(false);

        gameWithFriend2.setVisible(false);

        player1=new Player(1);
        player2=new Player(2);
        player1.setName(InputOfFirstName.getText());
        player2.setName(InputOfSecondName.getText());

        label2=new JLabel("Welcome "+player1.getName()+ " and "+player2.getName());

        game=new Game();
        game.setAnswer(2);
        game.setNumberOfPlayers(2);

        panel2.add(label2);

        panel3=new JPanel(new GridLayout(3,1,4,5));
        panel3.add(label2);
        s_rounds_two=new JButton("Select Rounds");
        s_rounds_two.setVisible(true);
        r_rounds_two=new JButton("Random Rounds");
        r_rounds_two.setVisible(true);

        s_rounds_two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s_rounds_two();
            }
        });
        panel3.add(s_rounds_two);

        r_rounds_two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r_rounds_two();
            }
        });
        panel3.add(r_rounds_two);
        panel2.add(panel3);


    }

    private void s_rounds_solo()
    {
        String h=JOptionPane.showInputDialog(null,"Write how many rounds you want from 1 to 10");
        panel3.setVisible(false);
        label2.setVisible(false);
        label.setVisible(false);
        s_rounds_solo.setVisible(false);
        r_rounds_solo.setVisible(false);

        int i=Integer.parseInt(h);
        game.setNumberOfRounds(i);

        label=new JLabel("Your round/s will be: "+game.getNumberOfRounds()+".");
        label2=new JLabel("In order to answer to the questions press the keys 1,2,3 and 4!");

        panel2.add(label);
        panel2.add(label2);


        JButton startTheGame=new JButton("Let the game begin");
        startTheGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame startingGameFrame=new JFrame("BUZZ");
                startingGameFrame.setVisible(true);
                startingGameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                startingGameFrame.setResizable(true);
                startingGameFrame.setSize(500, 270);
                startingGameFrame.setLocationRelativeTo(null);

                Round round = new Round();
                label = new JLabel("Round: " + game.getCurrentRound()+".Your round is: "+round.getKind());

                Question question = new Question();
                question.setRandomQuestion();
                question.setNumberOfRandomQuestionInArray();
                Answer answer = new Answer();
                label2=new JLabel("Question " + round.getCurrentNumberOfQuestion()+":");

                JLabel label3=new JLabel(question.getRandomQuestion());
                answer.setFourPossibleAnswers(question.getNumberOfRandomQuestionInArray(),
                        question.getNumberOfCategory());

                JPanel panel5=new JPanel(new GridLayout(4,1));
                panel5.add(new JLabel("A) "+answer.getFourPossibleAnswers().get(0)));
                panel5.add(new JLabel("B) "+answer.getFourPossibleAnswers().get(1)));
                panel5.add(new JLabel("C) "+answer.getFourPossibleAnswers().get(2)));
                panel5.add(new JLabel("D) "+answer.getFourPossibleAnswers().get(3)));

                panel3 = new JPanel(new GridLayout(3,1));
                panel3.setVisible(true);
                //panel3.setLayout(new FlowLayout(FlowLayout.LEADING));
                startingGameFrame.add(panel3, BorderLayout.CENTER);

                JPanel panel4 = new JPanel(new GridLayout(3,1));
                panel4.add(label);
                panel4.add(label2);
                panel4.add(label3);

                panel3.add(panel4);
                panel3.add(panel5);

                JPanel panel6=new JPanel(new GridLayout(1,2));
                JLabel label5 = new JLabel("5000");
                panel6.add(label5);

                JButton countdown = new JButton("Begin Counting Down 5 Seconds!");
                countdown.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        label5.setText("5000");
                        Timer timer = new Timer(100, new ActionListener() {
                            private int count = 5000;

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (count <= 0) {
                                    ((Timer) e.getSource()).stop();
                                } else {
                                    count -= 100;
                                }
                                label5.setText(Integer.toString(count));

                            }

                        });
                        timer.start();

                    }
                });
                panel6.add(label5);
                panel6.add(countdown);
                panel3.add(panel6);

            }
        });
        panel2.add(startTheGame);

    }

    private void r_rounds_solo()
    {
        panel3.setVisible(false);
        label.setVisible(false);
        label2.setVisible(false);

        s_rounds_solo.setVisible(false);
        r_rounds_solo.setVisible(false);

        game.setRandomRounds();

        label=new JLabel("Our masters have decided that your round(s) will be: " +game.getNumberOfRounds()+".");
        label2=new JLabel("In order to answer to the questions press the keys 1,2,3 and 4!");

        panel2.add(label);
        panel2.add(label2);

        JButton startTheGame=new JButton("Let the game begin");
        startTheGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame startingGameFrame=new JFrame("BUZZ");
                startingGameFrame.setVisible(true);
                startingGameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                startingGameFrame.setResizable(true);
                startingGameFrame.setSize(500, 270);
                startingGameFrame.setLocationRelativeTo(null);

                panel3 = new JPanel();
                panel3.setVisible(true);
                panel3.setLayout(new FlowLayout(FlowLayout.LEADING));
                panel3.setBackground(Color.DARK_GRAY);
                startingGameFrame.add(panel3, BorderLayout.CENTER);

                Round round = new Round();
                label = new JLabel("Round: " + game.getCurrentRound());
                label.setVisible(true);
                //label.setHorizontalAlignment(JLabel.CENTER);
                panel3.add(label, BorderLayout.CENTER);
            }
        });
        panel2.add(startTheGame);
    }

    private void s_rounds_two()
    {

        String k=JOptionPane.showInputDialog(null,"Write how many rounds you want from 1 to 10");

        panel3.setVisible(false);
        label2.setVisible(false);
        label.setVisible(false);

        s_rounds_two.setVisible(false);
        r_rounds_two.setVisible(false);

        int i=Integer.parseInt(k);
        game.setNumberOfRounds(i);

        JLabel label3=new JLabel("Your rounds will be: "+game.getNumberOfRounds());
        panel2.add(label3);
        label2=new JLabel(player1.getName()+",in order to answer to the questions press the keys 1,2,3 and 4 " +
                "and "+player2.getName()+" the keys 6,7,8,9 are for you!");
        panel2.add(label2);

        JButton startTheGame=new JButton("Let the game begin");
        startTheGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame startingGameFrame=new JFrame("BUZZ");
                startingGameFrame.setVisible(true);
                startingGameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                startingGameFrame.setResizable(true);
                startingGameFrame.setSize(500, 270);
                startingGameFrame.setLocationRelativeTo(null);

                panel3 = new JPanel();
                panel3.setVisible(true);
                panel3.setLayout(new FlowLayout(FlowLayout.LEADING));
                panel3.setBackground(Color.DARK_GRAY);
                startingGameFrame.add(panel3, BorderLayout.CENTER);

                Round round = new Round();
                label = new JLabel("Round: " + game.getCurrentRound());
                label.setVisible(true);
                //label.setHorizontalAlignment(JLabel.CENTER);
                panel3.add(label, BorderLayout.CENTER);
            }
        });
        panel2.add(startTheGame);

    }

    private void r_rounds_two()
    {
        panel3.setVisible(false);
        label.setVisible(false);
        label2.setVisible(false);

        s_rounds_two.setVisible(false);
        r_rounds_two.setVisible(false);

        game.setRandomRounds();

        label=new JLabel("You lucky people!Our masters have picked: "+game.getNumberOfRounds()+" rounds for you.");
        label2=new JLabel(player1.getName()+",in order to answer to the questions press the keys 1,2,3 and 4 " +
                "and "+player2.getName()+" the keys 6,7,8,9 are for you!");
        panel2.add(label);
        panel2.add(label2);

        JButton startTheGame=new JButton("Let the game begin");
        startTheGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame startingGameFrame=new JFrame("BUZZ");
                startingGameFrame.setVisible(true);
                startingGameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                startingGameFrame.setResizable(true);
                startingGameFrame.setSize(500, 270);
                startingGameFrame.setLocationRelativeTo(null);

                panel3 = new JPanel();
                panel3.setVisible(true);
                panel3.setLayout(new FlowLayout(FlowLayout.LEADING));
                panel3.setBackground(Color.DARK_GRAY);
                startingGameFrame.add(panel3, BorderLayout.CENTER);

                Round round = new Round();
                label = new JLabel("Round: " + game.getCurrentRound());
                label.setVisible(true);
                //label.setHorizontalAlignment(JLabel.CENTER);
                panel3.add(label, BorderLayout.CENTER);


            }
        });
        panel2.add(startTheGame);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }


}