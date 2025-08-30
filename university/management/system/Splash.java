package university.management.system;

import java.awt.*;
import javax.swing.*;

public class Splash extends JFrame implements Runnable {
    Thread t;

    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        setUndecorated(true);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            Thread.sleep(3000);
            setVisible(false);
            new Login(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
