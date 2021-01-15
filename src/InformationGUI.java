import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the welcoming graphical interface. It was a frame with an image and two
 * buttons. One for starting the game called "New Game" and one for the statistics called "Statistics".
 * The first one can be clicked only once and then the class passes the graphical to the settingsGUI
 * in order to get the game started. The second button can be clicked anytime the player wants to see
 * the statistics to any mode (that is possible because the frame does not close when the game starts).
 * The class has also an object of the GUIController in order to be able to connect the logic to the
 * graphics.
 *
 * @author Sophia Katsaki
 * @author Stylianos Tozios
 */

public class InformationGUI {
    private JFrame infoFrame;
    private JPanel infoPanel;
    private GUIController controller;

    /**
     *Constructor
     *
     * The constructor of the InformationGUI class creates a new GUIController
     * object,makes a new frame,a panel that is added to the frame.It creates
     * a label that becomes visible with the message that appears on the
     * screen and greets the user(s)/player(s).It finally calls methods to
     * set the opening image,start a new game and show the statistics of the
     * game.
     *
     */

    public InformationGUI() {
        this.controller = new GUIController();

        this.infoFrame = new JFrame("BUZZ");
        this.infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.infoFrame.setResizable(false);
        this.infoFrame.setSize(600, 430);
        this.infoFrame.setLocationRelativeTo(null);

        this.infoPanel = new JPanel();
        this.infoPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.infoPanel.setBackground(Color.YELLOW);
        this.infoFrame.add(this.infoPanel, BorderLayout.PAGE_START);

        JLabel messageLabel = new JLabel("Hello and welcome to the best game ever,Buzz!");
        messageLabel.setVisible(true);
        this.infoPanel.add(messageLabel, BorderLayout.PAGE_END);

        setImage();
        startNewGame();
        showStatistics();
    }

    /**
     *
     *This method sets the frame that holds the image,greeting label and
     * 2 buttons as visible,in order for the user(s)/player(s) to begin.
     *
     */

    public void start(){
        this.infoFrame.setVisible(true);
    }

    /**
     *
     * This method sets the image with the logo of the BUZZ game
     * (opening image) and makes it visible in the opening frame.
     *
     */

    public void setImage() {
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setSize(300, 300);
        this.infoFrame.add(imagePanel);

        ImageIcon icon = new ImageIcon(getClass().getResource("openingImage.jpg"));
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setVisible(true);
        imagePanel.add(imageLabel);

        this.infoFrame.setIconImage(icon.getImage());
    }

    /**
     *
     *This method starts the game for the user(s)/player(s) and when the
     * the button "New Game" in it is pressed,it is not enabled anymore,
     * and a settingsGUI object is created with a GUIController object
     * "controller" as a parameter in the constructor.
     *
     */

    public void startNewGame() {
        JButton newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame.setEnabled(false);
                SettingsGUI settingsGUI = new SettingsGUI(controller);
            }
        });
        this.infoPanel.add(newGame, BorderLayout.PAGE_END);
    }

    /**
     *
     *This method is for showing the statistics of the game to the
     *user(s)/player(s) when the "Statistics" button is pressed.
     *There are two kinds of statistics,one that is for the "Solo Game" and
     * one that is for the "Game With A Friend"
     */

    public void showStatistics() {
        JButton statistics = new JButton("Statistics");
        statistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] statistics = {"Solo Game", "Game With A Friend"};
                int temp = JOptionPane.showOptionDialog(infoFrame,
                        "What mode do you want?",
                        "Statistics",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        statistics,
                        statistics[1]);

                switch (temp){
                    case 0 ->
                        JOptionPane.showMessageDialog(infoFrame,
                                controller.getStatistics(temp+1),
                                "Solo Game",
                                JOptionPane.INFORMATION_MESSAGE);
                    case 1 ->
                        JOptionPane.showMessageDialog(infoFrame,
                                controller.getStatistics(temp+1),
                                "Game With A Friend",
                                JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        this.infoPanel.add(statistics, BorderLayout.PAGE_END);
    }
}