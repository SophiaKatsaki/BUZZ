import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JButton button;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton s_rounds_solo;
    private JButton r_rounds_solo;
    private JButton s_rounds_two;
    private JButton r_rounds_two;
    private JLabel label;
    private JLabel label2;
    private JTextField textField;
    private JTextField textField2;
    private Player player;
    private Player player2;
    private Game game;

    public GUI()
    {
        frame = new JFrame("BUZZ");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(500, 270);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setVisible(true);
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel.setBackground(Color.BLUE);
        frame.add(panel, BorderLayout.PAGE_START);

        button= new JButton("New Game");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button();
            }
        });
        panel.add(button);

        panel2 = new JPanel();
        panel2.setVisible(true);
        panel2.setBackground(Color.white);
        frame.add(panel2, BorderLayout.CENTER);

        label=new JLabel("Hello and welcome to the best game ever...BUZZ!");
        label.setVisible(true);
        label2=new JLabel("You can try 'Challenge For One' or play with a friend.");
        label2.setVisible(true);

        label.setForeground(Color.black);
        label2.setForeground(Color.black);
        panel2.add(label);
        panel2.add(label2);
    }
    private void button()
    {
        button.setVisible(true);

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

        button2=new JButton("Solo Game");
        button2.setVisible(true);
        button3=new JButton("Game With A Friend");
        button3.setVisible(true);
        panel.add(button2);
        panel.add(button3);

        panel2=new JPanel();
        panel2 = new JPanel();
        panel2.setVisible(true);
        panel2.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel2.setBackground(Color.white);
        frame2.add(panel2,BorderLayout.CENTER);
        label=new JLabel("Well..we need to know if you want to play solo or with an opponent.");
        label.setForeground(Color.black);

        panel2.add(label);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3();
            }
        });
    }

    private void button2()
    {
        button2.setVisible(false);
        button3.setVisible(false);

        label.setText("Solo game is chosen!The only one who can win you is yourself!");
        panel.add(label);
        label2=new JLabel("Enter your name");
        panel2.add(label2);

        textField=new JTextField(30);
        panel2.add(textField);

        button4=new JButton("Ready to play");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button4();
            }
        });
        panel2.add(button4);
    }

    private void button3()
    {
        button2.setVisible(false);
        button3.setVisible(false);

        label.setText("I see two players in here!Only one will be the master of BUZZ!");
        panel.add(label);
        label2=new JLabel("Enter your names");
        panel2.add(label2);

        textField=new JTextField(30);
        textField2=new JTextField(30);
        panel2.add(textField);
        panel2.add(textField2);

        button5=new JButton("Ready to play");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button5();
            }
        });
        panel2.add(button5);
    }

    private void button4()
    {
        label2.setVisible(false);
        textField.setVisible(false);
        button4.setVisible(false);

        player=new Player(1);
        player.setName(textField.getText());

        label2=new JLabel("Welcome "+player.getName()+"!Select one of the following.");

        game=new Game(2);
        game.setNumberOfPlayers(1);

        panel2.add(label2);

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
        panel2.add(s_rounds_solo);

        r_rounds_solo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r_rounds_solo();
            }
        });
        panel2.add(r_rounds_solo);
    }

    private void button5()
    {
        label2.setVisible(false);

        textField.setVisible(false);
        textField2.setVisible(false);

        button5.setVisible(false);

        player=new Player(1);
        player2=new Player(2);
        player.setName(textField.getText());
        player2.setName(textField2.getText());

        label2=new JLabel("Welcome "+player.getName()+ " and "+player2.getName());

        game=new Game(2);
        game.setNumberOfPlayers(2);

        panel2.add(label2);

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
        panel2.add(s_rounds_two);

        r_rounds_two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r_rounds_two();
            }
        });
        panel2.add(r_rounds_two);


    }

    private void s_rounds_solo()
    {
        String h=JOptionPane.showInputDialog(null,"Write how many rounds you want from 1 to 10");

        label2.setVisible(false);
        label.setVisible(false);
        s_rounds_solo.setVisible(false);
        r_rounds_solo.setVisible(false);

        int i=Integer.parseInt(h);
        game.setNumberOfRounds(i);

        label=new JLabel("Your rounds will be: "+game.getNumberOfRounds()+".");
        label2=new JLabel("In order to answer to the questions press the keys 1,2,3 and 4!");

        panel2.add(label);
        panel2.add(label2);

    }

    private void r_rounds_solo()
    {
        label.setVisible(false);
        label2.setVisible(false);

        s_rounds_solo.setVisible(false);
        r_rounds_solo.setVisible(false);

        game.setRandomRounds();

        label=new JLabel("Our masters have decided that your round(s) will be: " +game.getNumberOfRounds()+".");
        label2=new JLabel("In order to answer to the questions press the keys 1,2,3 and 4!");

        panel2.add(label);
        panel2.add(label2);

    }

    private void s_rounds_two()
    {
        String k=JOptionPane.showInputDialog(null,"Write how many rounds you want from 1 to 10");

        label2.setVisible(false);
        label.setVisible(false);

        s_rounds_two.setVisible(false);
        r_rounds_two.setVisible(false);

        int i=Integer.parseInt(k);
        game.setNumberOfRounds(i);

        JLabel label3=new JLabel("Your rounds will be: "+game.getNumberOfRounds());
        panel2.add(label3);
        label2=new JLabel(player.getName()+",in order to answer to the questions press the keys 1,2,3 and 4 " +
                "and "+player2.getName()+" the keys 6,7,8,9 are for you!");
        panel2.add(label2);

    }

    private void r_rounds_two()
    {
        label.setVisible(false);
        label2.setVisible(false);

        s_rounds_two.setVisible(false);
        r_rounds_two.setVisible(false);

        game.setRandomRounds();

        label=new JLabel("You lucky people!Our masters have picked: "+game.getNumberOfRounds()+" rounds for you.");
        label2=new JLabel(player.getName()+",in order to answer to the questions press the keys 1,2,3 and 4 " +
                "and "+player2.getName()+" the keys 6,7,8,9 are for you!");
        panel2.add(label);
        panel2.add(label2);

    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }


}