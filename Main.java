import java.awt.*;
import javax.swing.*;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getGradeStatus() {
        if (score >= 70) {
            return "Lulus";
        } else {
            return "Tidak Lulus";
        }
    }
}
public class Main extends JFrame {
    private  JLabel resultLabel;

    public Main() {
        setTitle("Student Grade Checker");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        userInterface();
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lenovo\\IdeaProjects\\UAS1\\src\\0.png"));
    }

    private void userInterface() {
        JLabel judul = new JLabel("Student");
        judul.setHorizontalAlignment(JLabel.CENTER);
        judul.setFont(new Font("Rockwell bold", Font.PLAIN, 20));
        judul.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(judul, "North");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(Color.WHITE);

        JLabel name = new JLabel("Name :");
        name.setPreferredSize(new Dimension(110, 25));
        name.setFont(new Font("Times new roman", Font.PLAIN, 16));
        panel.add(name);

        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(210, 25));
        panel.add(nameField);

        JLabel score = new JLabel("Score: ");
        score.setPreferredSize(new Dimension(110, 25));
        score.setFont(new Font("Times new roman", Font.PLAIN, 16));
        panel.add(score);

        JTextField scoreField = new JTextField();
        scoreField.setPreferredSize(new Dimension(210, 25));
        panel.add(scoreField);

        getContentPane().add(panel);

        JPanel Button = new JPanel();
        Button.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton submitButton = new JButton("Check");
        submitButton.setBackground(new java.awt.Color(0, 102, 102));
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        panel.add(submitButton);
        resultLabel = new JLabel();
        panel.add(resultLabel);

        submitButton.addActionListener(e -> {
            String nam = nameField.getText();
            int scor = Integer.parseInt(scoreField.getText());

            Student student = new Student(nam, scor);
            String grade = student.getGradeStatus();

            resultLabel.setText("Grade Status: " + grade);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());

    }
}
