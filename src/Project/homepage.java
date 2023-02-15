package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homepage extends JFrame implements ActionListener {
    JMenuBar mb;
    JButton home ,register,profile,logout;


    homepage(){
        setSize(600,435);
        mb =new JMenuBar();
        mb.setBounds(0,350,600,50);
        mb.setBackground(Color.BLUE);
        mb.setLayout(new GridLayout(1,3));
        add(mb);

        home = new JButton("Home");
        home.addActionListener(this);
        mb.add(home);
        register = new JButton("Register");
        register.addActionListener(this);
        mb.add(register);
        profile = new JButton("Profile");
        profile.addActionListener(this);
        mb.add(profile);
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("images/logout.png"));
        Image i7 =i5.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon i8 =new ImageIcon(i7);
        logout = new JButton(i8);
        logout.setBounds(540, 0, 50, 50);
        logout.addActionListener(this);
        add(logout);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/2.png"));
        Image i3 =i1.getImage().getScaledInstance(600,400,Image.SCALE_SMOOTH);
        ImageIcon i4 =new ImageIcon(i3);
        JLabel i2 =new JLabel(i4);
        i2.setBounds(0,0,600,400);
        add(i2);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home) {
            new homepage();
            setVisible(false);
        }
        else if (e.getSource() == register) {
            new Task();
            setVisible(false);
        }
        else if (e.getSource() == profile) {

            setVisible(false);
        }
        else if (e.getSource() == logout) {
            new Login();
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new homepage();
    }
}
