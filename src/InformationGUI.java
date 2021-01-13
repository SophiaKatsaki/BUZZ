import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationGUI {
    private JFrame infoFrame;
    private JPanel infoPanel;
    private GUILogic logic;

    public InformationGUI() {
        this.logic = new GUILogic();

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

    public void start(){
        this.infoFrame.setVisible(true);
    }

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

    public void startNewGame() {
        JButton newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame.setEnabled(false);
                SettingsGUI settingsGUI = new SettingsGUI(logic);
            }
        });
        this.infoPanel.add(newGame, BorderLayout.PAGE_END);
    }

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
                                logic.getStatistics(temp+1),
                                "Solo Game",
                                JOptionPane.INFORMATION_MESSAGE);
                    case 1 ->
                        JOptionPane.showMessageDialog(infoFrame,
                                logic.getStatistics(temp+1),
                                "Game With A Friend",
                                JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        this.infoPanel.add(statistics, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        InformationGUI BUZZ = new InformationGUI();
        BUZZ.start();
    }
}