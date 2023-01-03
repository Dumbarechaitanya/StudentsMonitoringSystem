package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel l1,l2;
    JButton SignIn,Cancel,Register;
    JTextField Username;
    JPasswordField Password;
    String username,password;
    public Font F = new Font("Agency FB",Font.BOLD,20);
    Login(){
          setSize(400,370);
          l1 = new JLabel("Username");
          l1.setBounds(50,75,100,50);
          l1.setFont(F);
          add(l1);

          l2 = new JLabel("Password");
          l2.setBounds(50,125,100,50);
          l2.setFont(F);
          add(l2);

          Username =new JTextField("");
          Username.setBounds(150,80,150,30);
          add(Username);

          Password =new JPasswordField("");
          Password.setBounds(150,135,150,30);
          add(Password);

          SignIn = new JButton("SignIn");
          SignIn.setBounds(100,175,75,30);
          SignIn.addActionListener(this);
          add(SignIn);
          Register = new JButton("Register");
          Register.setBounds(200,175,75,30);
          Register.addActionListener(this);
          add(Register);

          Cancel = new JButton("Cancel");
          Cancel.setBounds(300,175,75,30);
          Cancel.addActionListener(this);
          add(Cancel);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image i3 =i1.getImage().getScaledInstance(400,375,Image.SCALE_SMOOTH);
        ImageIcon i4 =new ImageIcon(i3);
        JLabel i2 =new JLabel(i4);
        i2.setBounds(0,0,400,340);
        add(i2);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == this.SignIn) {
            username = this. Username.getText();
            password = String. valueOf(this.Password.getPassword());
            connector c = new connector();
            try{
                String str1 = "select * from stud_mon_sys.login where Username ='"+username+"'and Password ='"+password+"';";
                ResultSet rs = c.s.executeQuery(str1);
                if (rs.next()){
                    JOptionPane.showMessageDialog(null,"Login Successfulliy!!!");
                    new homepage();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid Username Or Password!!!");
                    new Login();
                }
            }catch (Exception e){
                System.out.println(""+e);
            }

            setVisible(false);
        } else if (a.getSource() == this.Cancel) {
            System.exit(0);
            setVisible(false);
        }
        else if (a.getSource() == this.Register) {
            new Register();
            setVisible(false);
        }
    }

    public static void main(String[] args) {new Login();}
}
