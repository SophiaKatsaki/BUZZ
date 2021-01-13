import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsGUI {
    private JFrame settingsFrame;
    private JPanel settingsPanel;
    private JLabel messageLabel;
    private GUILogic logic;

    public SettingsGUI(GUILogic logic) {
        this.logic = logic;

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
        this.logic.setMode(temp+1);
    }

    public void setNameOfPlayer() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter your name: ");


        JButton ready = new JButton("Ready to play");
        if (this.logic.getNumberOfPlayers() == 1) {
            this.messageLabel.setText("Solo game is chosen! The only one who can win you is yourself!");
            panel = new JPanel(new GridLayout(3, 1, 4, 5));

            JTextField textField = new JTextField(30);

            ready.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    logic.setName(1, textField.getText());
                    JOptionPane.showMessageDialog(settingsFrame,
                            "You can select an answer with the keys 1, 2, 3 or 4\n" +
                                    "or by clicking with the mouse!",
                            "Welcome " + logic.getName(1) + "!",
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
        else if (this.logic.getNumberOfPlayers() == 2) {
            this.messageLabel.setText("I see two players in here! Only one will be the master of BUZZ!");
            panel = new JPanel(new GridLayout(4,1,4,5));

            JTextField textField = new JTextField(30);
            JTextField textField2 = new JTextField(30);

            ready.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    logic.setName(1, textField.getText());
                    logic.setName(2, textField2.getText());
                    JOptionPane.showMessageDialog(settingsFrame,
                            logic.getName(1) +
                                    ", you select an answer with the keys 1, 2, 3 or 4!"
                                    + "\n" + logic.getName(2) +
                                    ", you select an answer with the keys 6, 7, 8 or 9!",
                            "Welcome " + logic.getName(1) + " and "
                                    + logic.getName(2) + "!",
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

    public void setNumberOfRounds() {
        JButton ready = new JButton("Ready");
        ready.setVisible(true);
        ready.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsFrame.dispose();
                BuzzGameGUI BUZZ = new BuzzGameGUI(logic);
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
                this.logic.setRounds((int) secondOptions[temp2]);

                this.settingsPanel.setVisible(true);
                this.messageLabel.setText("Your rounds will be: " + logic.getRounds() + ".");
                this.settingsPanel.add(this.messageLabel, BorderLayout.PAGE_START);
            }
            case 1 -> {
                this.logic.setRounds(-1);

                this.settingsPanel.setVisible(true);
                this.messageLabel.setText("We have decided that your round/s will be: " +
                        this.logic.getRounds() + ".");
                this.settingsPanel.add(this.messageLabel, BorderLayout.PAGE_START);
            }
        }
    }
}