
package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JTextField textFieldName;
    JPasswordField passwordField;
    JButton login, back;

    Login() {
        // Panel for Form Layout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username Label
        JLabel labelname = new JLabel("Username");
        labelname.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(labelname, gbc);

        // Username TextField
        textFieldName = new JTextField();
        textFieldName.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(textFieldName, gbc);

        // Password Label
        JLabel labelpass = new JLabel("Password");
        labelpass.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(labelpass, gbc);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(passwordField, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        login = new JButton("Login");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Arial", Font.BOLD, 16));
        login.addActionListener(this);
        buttonPanel.add(login);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.addActionListener(this);
        buttonPanel.add(back);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);

        // Image Panel
        JLabel imgLabel = new JLabel();
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        imgLabel.setIcon(new ImageIcon(i2));
        imgLabel.setHorizontalAlignment(JLabel.CENTER);

        // Main Layout
        setLayout(new BorderLayout(20, 20));
        add(imgLabel, BorderLayout.EAST);
        add(formPanel, BorderLayout.CENTER);

        // Frame Settings
        setTitle("University Management System - Login");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String username = textFieldName.getText();
            String password = new String(passwordField.getPassword());

            String query = "SELECT * FROM login WHERE username = ? AND password = ?";
            try {
                Conn c = new Conn();
                PreparedStatement preparedStatement = c.connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultset = preparedStatement.executeQuery();
                if (resultset.next()) {
                    setVisible(false);
                    new main_class();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
