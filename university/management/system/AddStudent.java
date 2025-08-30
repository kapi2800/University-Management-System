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

public class AddStudent extends JFrame implements ActionListener {
    JTextField textName, textFather, textAddress, textPhone, textEmail, textM10, textM12;
    JLabel empText;
    JDateChooser cdob;
    JComboBox<String> courseBox, departmentBox;
    JButton submit, cancel;

    Random ran = new Random();
    long rollNumber = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent() {
        setTitle("Add Student Details");
        setLayout(null);
        getContentPane().setBackground(new Color(200, 220, 240));

        // Heading
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(300, 30, 400, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading);

        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 100, 150, 30);
        name.setFont(new Font("serif", Font.BOLD, 18));
        add(name);

        textName = new JTextField();
        textName.setBounds(200, 100, 200, 30);
        add(textName);

        // Father Name
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(450, 100, 150, 30);
        fname.setFont(new Font("serif", Font.BOLD, 18));
        add(fname);

        textFather = new JTextField();
        textFather.setBounds(600, 100, 200, 30);
        add(textFather);

        // Roll Number
        JLabel rollNo = new JLabel("Roll Number");
        rollNo.setBounds(50, 150, 150, 30);
        rollNo.setFont(new Font("serif", Font.BOLD, 18));
        add(rollNo);

        empText = new JLabel("2023" + rollNumber);
        empText.setBounds(200, 150, 200, 30);
        empText.setFont(new Font("serif", Font.BOLD, 18));
        add(empText);

        // Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(450, 150, 150, 30);
        dob.setFont(new Font("serif", Font.BOLD, 18));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600, 150, 200, 30);
        add(cdob);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 200, 150, 30);
        address.setFont(new Font("serif", Font.BOLD, 18));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 200, 200, 30);
        add(textAddress);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(450, 200, 150, 30);
        phone.setFont(new Font("serif", Font.BOLD, 18));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600, 200, 200, 30);
        add(textPhone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 250, 150, 30);
        email.setFont(new Font("serif", Font.BOLD, 18));
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(200, 250, 200, 30);
        add(textEmail);

        // Class X Marks
        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(450, 250, 150, 30);
        M10.setFont(new Font("serif", Font.BOLD, 18));
        add(M10);

        textM10 = new JTextField();
        textM10.setBounds(600, 250, 200, 30);
        add(textM10);

        // Class XII Marks
        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50, 300, 150, 30);
        M12.setFont(new Font("serif", Font.BOLD, 18));
        add(M12);

        textM12 = new JTextField();
        textM12.setBounds(200, 300, 200, 30);
        add(textM12);

        // Course
        JLabel course = new JLabel("Course");
        course.setBounds(450, 300, 150, 30);
        course.setFont(new Font("serif", Font.BOLD, 18));
        add(course);

        String[] courses = {"B.Tech", "BBA", "BCA", "BSC", "MSC", "MBA", "MCA", "MCom", "MA", "BA"};
        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(600, 300, 200, 30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        // Department
        JLabel department = new JLabel("Branch");
        department.setBounds(50, 350, 150, 30);
        department.setFont(new Font("serif", Font.BOLD, 18));
        add(department);

        String[] departments = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        departmentBox = new JComboBox<>(departments);
        departmentBox.setBounds(200, 350, 200, 30);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);

        // Buttons
        submit = new JButton("Submit");
        submit.setBounds(250, 450, 150, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif", Font.BOLD, 18));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 450, 150, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif", Font.BOLD, 18));
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 600);
        setLocation(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = textName.getText();
            String fname = textFather.getText();
            String rollNo = empText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String classX = textM10.getText();
            String classXII = textM12.getText();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();

            if (name.isEmpty() || fname.isEmpty() || dob.isEmpty() || address.isEmpty() ||
                phone.isEmpty() || email.isEmpty() || classX.isEmpty() || classXII.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required.");
                return;
            }

            try  (Connection conn = DriverManager.getConnection("jdbc:mysql:///universitymanagement", "root", "112233")){

                String query = "INSERT INTO student (name, fname,rollno , dob, address, phone, email, class_x, class_xii, course, branch) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setString(1, name);
                pstmt.setString(2, fname);
                pstmt.setString(3, rollNo);
                pstmt.setString(4, dob);
                pstmt.setString(5, address);
                pstmt.setString(6, phone);
                pstmt.setString(7, email);
                pstmt.setString(8, classX);
                pstmt.setString(9, classXII);
                pstmt.setString(10, course);
                pstmt.setString(11, department);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Student Details Added Successfully");
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
        new AddStudent();
    }
}
