package university.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class main_class extends JFrame implements ActionListener {

    main_class() {
        // Set background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.png"));
        Image i2 = i1.getImage().getScaledInstance(1540, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1540, 750);  // Set bounds for the background image

        // Set layout
        setLayout(new BorderLayout());

        // Create Menu Bar
        JMenuBar mb = new JMenuBar();

        // Set font for the menu bar items
        Font menuFont = new Font("Arial", Font.PLAIN, 16);

        // New Information Menu
        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.BLACK);
        newInfo.setFont(menuFont);
        mb.add(newInfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.setFont(menuFont);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.setFont(menuFont);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        // View Details Menu
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLACK);
        details.setFont(menuFont);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.setFont(menuFont);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.setFont(menuFont);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        // Apply Leave Menu
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        leave.setFont(menuFont);
        mb.add(leave);

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.setFont(menuFont);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.setFont(menuFont);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        // Leave Details Menu
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLACK);
        leaveDetails.setFont(menuFont);
        mb.add(leaveDetails);

        JMenuItem facultyleaveDetails = new JMenuItem("Faculty Leave Details");
        facultyleaveDetails.setBackground(Color.WHITE);
        facultyleaveDetails.setFont(menuFont);
        facultyleaveDetails.addActionListener(this);
        leaveDetails.add(facultyleaveDetails);

        JMenuItem studentleaveDetails = new JMenuItem("Student Leave Details");
        studentleaveDetails.setBackground(Color.WHITE);
        studentleaveDetails.setFont(menuFont);
        studentleaveDetails.addActionListener(this);
        leaveDetails.add(studentleaveDetails);

        // Exam Menu
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        exam.setFont(menuFont);
        mb.add(exam);

        JMenuItem ExaminationDetails = new JMenuItem("Examination Results");
        ExaminationDetails.setBackground(Color.WHITE);
        ExaminationDetails.setFont(menuFont);
        ExaminationDetails.addActionListener(this);
        exam.add(ExaminationDetails);

        JMenuItem EnterMarks = new JMenuItem("Enter Marks");
        EnterMarks.setBackground(Color.WHITE);
        EnterMarks.setFont(menuFont);
        EnterMarks.addActionListener(this);
        exam.add(EnterMarks);

        // Update Info Menu
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLACK);
        updateInfo.setFont(menuFont);
        mb.add(updateInfo);

        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.setFont(menuFont);
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);

        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.setFont(menuFont);
        updatestudentinfo.addActionListener(this);
        updateInfo.add(updatestudentinfo);

        // Fee Menu
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        fee.setFont(menuFont);
        mb.add(fee);

        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.setFont(menuFont);
        feestructure.addActionListener(this);
        fee.add(feestructure);

        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
        feeForm.setFont(menuFont);
        feeForm.addActionListener(this);
        fee.add(feeForm);

        // About Menu
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLACK);
        about.setFont(menuFont);
        mb.add(about);

        JMenuItem About = new JMenuItem("About");
        About.setBackground(Color.WHITE);
        About.setFont(menuFont);
        About.addActionListener(this);
        about.add(About);

        // Exit Menu
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        exit.setFont(menuFont);
        mb.add(exit);

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.WHITE);
        Exit.setFont(menuFont);
        Exit.addActionListener(this);
        exit.add(Exit);

        setJMenuBar(mb);


        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.setBackground(new Color(255, 255, 255, 150)); // Semi-transparent background

        JLabel welcomeLabel = new JLabel("Welcome to University Management System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.BLUE);
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);

        add(img, BorderLayout.CENTER);
        add(welcomePanel, BorderLayout.CENTER);
        // Frame Settings
        setSize(1540, 850);
        setVisible(true);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
        if (sm.equals("Exit")) {
            System.exit(15);
        } else if (sm.equals("New Faculty Information")) {
            new AddFaculty();
        } else if (sm.equals("New Student Information")) {
            new AddStudent();
        } else if (sm.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (sm.equals("View Student Details")) {
            new StudentDetails();
        } else if (sm.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (sm.equals("Student Leave")) {
            new StudentLeave();
        } else if (sm.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (sm.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (sm.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (sm.equals("Update Student Details")) {
            new updateStudent();
        } else if (sm.equals("Enter Marks")) {
            new EnterMarks();
        } else if (sm.equals("Examination Results")) {
            new ExaminationDetails();
        } else if (sm.equals("Fee Structure")) {
            new FreeStructure();
        } else if (sm.equals("Student Fee Form")) {
            new StudentFeeForm();
        } else if (sm.equals("About")) {
            new About();
        }
    }

    public static void main(String[] args) {
        new main_class();
    }
}
