import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Trafic extends JFrame implements ActionListener {
    static JFrame f;
    static JRadioButton rb1, rb2, rb3;
    static JButton b1, b2;
    static JLabel l;
    static JTextField t1, t2, t3, t4;

    Trafic() {
    }

    public static void main(String[] args) {
        f = new JFrame("Trafic Signal");
        l = new JLabel("Signal");
        rb1 = new JRadioButton("red");
        rb2 = new JRadioButton("yellow");
        rb3 = new JRadioButton("green");
        b1 = new JButton("start");
        b2 = new JButton("stop");
        ButtonGroup rbg = new ButtonGroup();
        rbg.add(rb1);
        rbg.add(rb2);
        rbg.add(rb3);
        t1 = new JTextField(30);
        t2 = new JTextField(6);
        t3 = new JTextField(6);
        t4 = new JTextField(6);
        Font fo = new Font("seria", 10, 10);
        l.setFont(fo);
        JPanel p = new JPanel();
        JPanel p1 = new JPanel();
        p.add(l);
        p.add(rb1);
        p.add(rb2);
        p.add(rb3);
        p.add(t1);
        p.add(t2);
        p.add(t3);
        p.add(t4);
        p1.add(b1);
        p1.add(b2);
        f.add(p);
        f.add(p1, BorderLayout.SOUTH);
        f.setSize(300, 300);
        f.setVisible(true);
        Trafic sig = new Trafic();
        b1.addActionListener(sig);
        b2.addActionListener(sig);
        rb1.addActionListener(sig);
        rb2.addActionListener(sig);
        rb3.addActionListener(sig);

    }

    int flag = 0;

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("start")) {
            flag = 1;
            mythread obj = new mythread();
            obj.start();
        } else if (s.equals("stop")) {
            flag = 0;

        }

        if (s.equals("red")) {
            t2.setBackground(Color.RED);
            t3.setBackground(Color.WHITE);
            t4.setBackground(Color.WHITE);
            t1.setBackground(Color.RED);
            t1.setText("stop");

        } else if (s.equals("yellow")) {
            t2.setBackground(Color.WHITE);
            t3.setBackground(Color.YELLOW);
            t4.setBackground(Color.WHITE);
            t1.setBackground(Color.YELLOW);
            t1.setText("Ready to stop");
        }

        else {
            t2.setBackground(Color.WHITE);
            t3.setBackground(Color.WHITE);
            t4.setBackground(Color.GREEN);
            t1.setBackground(Color.GREEN);
            t1.setText("go");
        }

    }

    class mythread extends Thread {
        public void run() {
            while (flag == 1) {
                t2.setBackground(Color.RED);
                t3.setBackground(Color.WHITE);
                t4.setBackground(Color.WHITE);
                t1.setBackground(Color.RED);
                t1.setText("stop");
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                t2.setBackground(Color.WHITE);
                t3.setBackground(Color.WHITE);
                t4.setBackground(Color.GREEN);
                t1.setBackground(Color.GREEN);
                t1.setText("go");
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                t2.setBackground(Color.WHITE);
                t3.setBackground(Color.YELLOW);
                t4.setBackground(Color.WHITE);
                t1.setBackground(Color.YELLOW);
                t1.setText("Ready to stop");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            t2.setBackground(Color.WHITE);
            t3.setBackground(Color.WHITE);
            t4.setBackground(Color.WHITE);
            t1.setBackground(Color.WHITE);
            t1.setText("");
        }
    }
}
