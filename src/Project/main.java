package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame implements ActionListener {
    JLabel L1;
    JButton Login;
    main(){
       setSize(800,500);

       this.L1 = new JLabel("Students Monitoring System");
       this.L1.setBounds(200,25,500,75);
       this.L1.setFont(new Font("Agency FB",Font.BOLD,35));
       this.add(this.L1);
       this.Login = new JButton("Login...");
       this.Login.setBounds(350,300,100,50);
       this.Login.addActionListener(this);
       this.add(this.Login);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/1.png"));
        Image i3 =i1.getImage().getScaledInstance(1000,500,Image.SCALE_SMOOTH);
        ImageIcon i4 =new ImageIcon(i3);
        JLabel i2 =new JLabel(i4);
        i2.setBounds(0,0,1000,500);
        add(i2);
       this.setLayout(null);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== this .Login){
            new Login ();
            setVisible(false);
        }
    }

    public static void main(String[] args) {new main ();}
}
