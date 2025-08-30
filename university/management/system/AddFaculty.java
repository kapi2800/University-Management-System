package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class AddFaculty extends JFrame implements ActionListener {

    JTextField textName, textFather, textAddress, textPhone, textEmail, textM10, textM12, textAadhar;
    JLabel empText;
    JDateChooser cdob;
    JComboBox<String> courseBox, departmentBox;
    JButton submit, cancel;

    Random ran = new Random();
    long empId = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddFaculty() {
        setTitle("Add Faculty Details");
        setLayout(null);
        getContentPane().setBackground(new Color(166, 164, 252));

        // Heading
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        textName = new JTextField();
        textName.setBounds(200, 150, 150, 30);
        add(textName);

        // Father Name
        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        textFather = new JTextField();
        textFather.setBounds(600, 150, 150, 30);
        add(textFather);

        // Employee ID
        JLabel empID = new JLabel("Employee ID");
        empID.setBounds(50, 200, 200, 30);
        empID.setFont(new Font("serif", Font.BOLD, 20));
        add(empID);

        empText = new JLabel("1409" + empId);
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("serif", Font.BOLD, 20));
        add(empText);

        // Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600, 200, 150, 30);
        add(cdob);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 150, 30);
        add(textAddress);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600, 250, 150, 30);
        add(textPhone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(200, 300, 150, 30);
        add(textEmail);

        // Class X Marks
        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(400, 300, 200, 30);
        M10.setFont(new Font("serif", Font.BOLD, 20));
        add(M10);

        textM10 = new JTextField();
        textM10.setBounds(600, 300, 150, 30);
        add(textM10);

        // Class XII Marks
        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50, 350, 200, 30);
        M12.setFont(new Font("serif", Font.BOLD, 20));
        add(M12);

        textM12 = new JTextField();
        textM12.setBounds(200, 350, 150, 30);
        add(textM12);

        // Qualification
        JLabel Qualification = new JLabel("Qualification");
        Qualification.setBounds(50, 400, 200, 30);
        Qualification.setFont(new Font("serif", Font.BOLD, 20));
        add(Qualification);

        String[] courses = { "B.Tech", "BBA", "BCA", "BSC", "MSC", "MBA", "MCA", "MCom", "MA", "BA" };
        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(200, 400, 150, 30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        // Department
        JLabel Department = new JLabel("Department");
        Department.setBounds(400, 350, 200, 30);
        Department.setFont(new Font("serif", Font.BOLD, 20));
        add(Department);

        String[] departments = { "Computer Science", "Electronics", "Mechanical", "Civil", "IT" };
        departmentBox = new JComboBox<>(departments);
        departmentBox.setBounds(600, 350, 150, 30);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(350, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = textName.getText();
            String fname = textFather.getText();
            String empid = empText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String classX = textM10.getText();
            String classXII = textM12.getText();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();

            if (name.isEmpty() || fname.isEmpty() || dob.isEmpty() || address.isEmpty() || phone.isEmpty()
                    || email.isEmpty() || classX.isEmpty() || classXII.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required.");
                return;
            }

            try (Connection conn = DriverManager.getConnection("jdbc:mysql:///universitymanagement", "root", "112233")) {
                String query = "INSERT INTO teacher (name, fname, empid, dob, address, phone, email, class_x, class_xii, education, department) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setString(1, name);
                pstmt.setString(2, fname);
                pstmt.setString(3, empid);
                pstmt.setString(4, dob);
                pstmt.setString(5, address);
                pstmt.setString(6, phone);
                pstmt.setString(7, email);
                pstmt.setString(8, classX);
                pstmt.setString(9, classXII);
                pstmt.setString(10, course);
                pstmt.setString(11, department);
+
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Details Inserted Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddFaculty();
    }
}
