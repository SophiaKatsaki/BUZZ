import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class makes the proper preparations before the game.Those preparations
 * have to do with the options of the user(s)/player(s) about the rounds they are
 * going to play and the mode of game they desire to play(Solo or with two
 * players).It has a frame,a panel,a label and a GUIController object.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */

public class SettingsGUI {
    private JFrame settingsFrame;
    private JPanel settingsPanel;
    private JLabel messageLabel;
    private GUIController controller;


    /**
     * Constructor
     *
     * The constructor takes as a parameter a GUIController object and
     * initializes the object that it holds,creates a frame,a panel,
     * sets the default image as the one that is used as an opening
     * image.It also creates a label for the messages that the
     * user(s)/player(s) are going to see during the game and calls the methods
     * that are for deciding the number of players and setting their names.
     */

    public SettingsGUI(GUIController controller) {
        this.controller = controller;

        this.settingsFrame = new JFrame("Let's begin!");
        this.settingsFrame.setVisible(true);
        this.settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.settingsFrame.setResizable(false);
        this.settingsFrame.setSize(600, 430);
        this.settingsFrame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("openingImage.jpg"));
        this.settingsFrame.setIconImage(icon.getImage());

        this.settingsPanel = new JPanel();
        this.settingsPanel.setVisible(false);
        this.settingsPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.settingsPanel.setBackground(Color.WHITE);
        this.settingsFrame.add(this.settingsPanel);

        this.messageLabel = new JLabel();
        this.settingsPanel.add(this.messageLabel, BorderLayout.PAGE_START);

        setNumberOfPlayers();
        setNameOfPlayer();
    }


    /**
     *
     * This method sets the number of players to either 1 or 2,
     * depending on what the user chose as their desired mode
     * of game.
     *
     */

    public void setNumberOfPlayers() {
        Object[] options = {"Solo Game", "Game With A Friend"};
        int temp = JOptionPane.CLOSED_OPTION;

        while (temp == JOptionPane.CLOSED_OPTION) {
            temp = JOptionPane.showOptionDialog(settingsFrame,
                    "Well..we need to know if you want to play solo or with an opponent.",
                    "BUZZ",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
        }
        this.controller.setMode(temp+1);
    }


    /**
     *
     * This method lets the player(s) enter their names.If it is solo mode,
     * the player just inputs their name.They are also informed that they
     * can play with their mouse by clicking the available buttons to answer
     * or by pressing the keys 1,2,3 and 4.In game with two players,the players
     * enter their names and are then informed that the only way to play in this
     * mode is by pressing the keys 1,2,3,4(first player) and 6,7,8,9(second
     * player).
     *
     */

    public void setNameOfPlayer() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter your name: ");


        JButton ready = new JButton("Ready to play");
        if (this.controller.getNumberOfPlayers() == 1) {
            this.messageLabel.setText("Solo game is chosen! The only one who can win you is yourself!");
            panel = new JPanel(new GridLayout(3, 1, 4, 5));

            JTextField textField = new JTextField(30);

            ready.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.setName(1, textField.getText());
                    JOptionPane.showMessageDialog(settingsFrame,
                            "You can select an answer with the keys 1, 2, 3 or 4\n" +
                                    "or by clicking with the mouse!",
                            "Welcome " + controller.getName(1) + "!",
                            JOptionPane.INFORMATION_MESSAGE);
                    settingsPanel.setVisible(false);

                    setNumberOfRounds();
                    ready.setVisible(false);
                }
            });

            panel.add(label, BorderLayout.CENTER);
            panel.add(textField);
            panel.add(ready);
        }
        else if (this.controller.getNumberOfPlayers() == 2) {
            this.messageLabel.setText("I see two players in here! Only one will be the master of BUZZ!");
            panel = new JPanel(new GridLayout(4,1,4,5));

            JTextField textField = new JTextField(30);
            JTextField textField2 = new JTextField(30);

            ready.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.setName(1, textField.getText());
                    controller.setName(2, textField2.getText());
                    JOptionPane.showMessageDialog(settingsFrame,
                            controller.getName(1) +
                                    ", you select an answer with the keys 1, 2, 3 or 4!"
                                    + "\n" + controller.getName(2) +
                                    ", you select an answer with the keys 6, 7, 8 or 9!",
                            "Welcome " + controller.getName(1) + " and "
                                    + controller.getName(2) + "!",
                            JOptionPane.INFORMATION_MESSAGE);
                    settingsPanel.setVisible(false);

                    setNumberOfRounds();
                    ready.setVisible(false);
                }
            });

            panel.add(label, BorderLayout.CENTER);
            panel.add(textField);
            panel.add(textField2);
            panel.add(ready);
        }
        this.settingsPanel.setVisible(true);
        this.settingsPanel.add(panel, BorderLayout.PAGE_END);
    }

    /**
     *
     * This method sets the number of rounds the game will have.Right away
     * after the player(s) have entered their name and have been informed about
     * the way they are going to play, it is time for them to chose whether
     * they want to choose their desired rounds(1 to 10) or to let the game
     * decide randomly for them(again 1 to 10 rounds).
     *
     */

    public void setNumberOfRounds() {
        JButton ready = new JButton("Ready");
        ready.setVisible(true);
        ready.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsFrame.dispose();
                BuzzGameGUI BUZZ = new BuzzGameGUI(controller);
            }
        });

        this.settingsPanel.removeAll();

        this.settingsPanel.add(this.messageLabel);
        this.settingsPanel.add(ready);

        Object[] options = {"Select Rounds", "Random Rounds"};
        int temp = JOptionPane.CLOSED_OPTION;

        while (temp == JOptionPane.CLOSED_OPTION) {
            temp = JOptionPane.showOptionDialog(settingsFrame,
                    "Select one of the following.",
                    "Rounds",
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
                    temp2 = JOptionPane.showOptionDialog(settingsFrame,
                            "Write how many rounds you want from 1 to 10",
                            "Almost Ready",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            secondOptions,
                            secondOptions[9]);
                }
                this.controller.setRounds((int) secondOptions[temp2]);

                this.settingsPanel.setVisible(true);
                this.messageLabel.setText("Your rounds will be: " + controller.getRounds() + ".");
                this.settingsPanel.add(this.messageLabel, BorderLayout.PAGE_START);
            }
            case 1 -> {
                this.controller.setRounds(-1);

                this.settingsPanel.setVisible(true);
                this.messageLabel.setText("We have decided that your round/s will be: " +
                        this.controller.getRounds() + ".");
                this.settingsPanel.add(this.messageLabel, BorderLayout.PAGE_START);
            }
        }
    }
}