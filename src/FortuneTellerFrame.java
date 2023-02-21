import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton readButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;
    int newWidth = 60;
    int newHeight = 70;


    public FortuneTellerFrame() {
        super("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        fortunes = new ArrayList<>();
        fortunes.add("You will meet your soulmate today.");
        fortunes.add("You will be famous someday.");
        fortunes.add("You will win tickets to a concert today.");
        fortunes.add("You will live a long and happy life.");
        fortunes.add("You will find new opportunities in life.");
        fortunes.add("You will win the lottery today.");
        fortunes.add("You will make a great discovery soon.");
        fortunes.add("You will find inner peace.");
        fortunes.add("You will have a successful career.");
        fortunes.add("You will find true happiness.");
        fortunes.add("You will find a true friend today");

        titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        ImageIcon icon = new ImageIcon("fortune-teller.png");
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        titleLabel.setIcon(icon);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        fortuneArea = new JTextArea();
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("Arial", Font.PLAIN, 24));

        JScrollPane scrollPane = new JScrollPane(fortuneArea);

        readButton = new JButton("Read My Fortune!");
        readButton.setFont(new Font("Arial", Font.BOLD, 24));
        readButton.addActionListener((ActionEvent e) -> {
            String fortune = getRandomFortune();
            fortuneArea.append(fortune + "\n");
        });

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.BOLD, 24));
        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(readButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private String getRandomFortune() {
        int index = lastFortuneIndex;
        while (index == lastFortuneIndex) {
            index = new Random().nextInt(fortunes.size());
        }
        lastFortuneIndex = index;
        return fortunes.get(index);
    }
}
