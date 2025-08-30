package university.management.system;

import java.awt.*;
import javax.swing.*;

public class About extends JFrame {
    About() {
        // Frame Title
        setTitle("About the Project");

        // Panel for Content
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(null);

        // Project Logo or Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/about.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(275, 20, 150, 150);
        contentPanel.add(img);

        // Project Title
        JLabel projectTitle = new JLabel("University Management System");
        projectTitle.setBounds(50, 200, 600, 40);
        projectTitle.setFont(new Font("Serif", Font.BOLD, 30));
        projectTitle.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(projectTitle);

        // Description
        JLabel description = new JLabel("<html>A comprehensive system to manage university<br>operations, including students, faculty, fees, and more.</html>");
        description.setBounds(100, 260, 500, 60);
        description.setFont(new Font("Tahoma", Font.PLAIN, 18));
        description.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(description);

        // Team Members
        JLabel contributorsLabel = new JLabel("Developed By:");
        contributorsLabel.setBounds(50, 340, 600, 30);
        contributorsLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        contributorsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(contributorsLabel);

        JLabel teamMembers = new JLabel("<html>Ashish Sharma<br>Kapil Kumar</html>");
        teamMembers.setBounds(50, 380, 600, 40);
        teamMembers.setFont(new Font("Tahoma", Font.PLAIN, 20));
        teamMembers.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(teamMembers);

        

        // Adding Panel to Frame
        add(contentPanel);

        // Frame Properties
        setSize(700, 600);
        setLocation(400, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
