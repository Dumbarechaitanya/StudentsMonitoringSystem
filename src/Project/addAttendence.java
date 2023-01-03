package Project;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addAttendence extends JFrame implements ActionListener {
    public Font F = new Font("Agency FB",Font.BOLD,15);
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JTable T;
    JScrollPane sp;
    JButton Display,Submit,back;
    String a = null;



    addAttendence(){
        setSize(600,500);
        sp = new JScrollPane();
        sp.setBounds(50,150,500,80);
        add(sp);
        T = new JTable();
        sp.setViewportView(T);

        l1 = new JLabel("RollNo :");
        l1.setBounds(50,50,100,50);
        l1.setFont(F);
        add(l1);

        l2 = new JLabel("Add Attendance :");
        l2.setBounds(50,250,150,50);
        l2.setFont(F);
        add(l2);
        l3 = new JLabel("Add Absentee :");
        l3.setBounds(50,300,150,50);
        l3.setFont(F);
        add(l3);

        t1 =new JTextField();
        t1.setBounds(150,60,150,30);
        add(t1);

        t2 =new JTextField();
        t2.setBounds(200,260,150,30);
        add(t2);
        t3 =new JTextField();
        t3.setBounds(200,310,150,30);
        add(t3);
        Display = new JButton("Display");
        Display.setBounds(320,60,100,30);
        Display.addActionListener(this);
        add(Display);
        Submit = new JButton("Submit");
        Submit.setBounds(100,400,75,30);
        Submit.addActionListener(this);
        add(Submit);
        ImageIcon i9 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i =i9.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon I=new ImageIcon(i);
        back = new JButton(I);
        back.setBounds(0, 0, 40, 40);
        back.addActionListener(this);
        add(back);



        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        String rollNo = this.t1.getText();
        String attendance = this.t2.getText();
        String absentee = this.t3.getText();
        connector c = new connector();

        if (ae.getSource() == Display) {
            try {
                String str = "select RollNo,Name,Address,ContactNo,Attendance,Absentee from stud_mon_sys.details where (RollNo ='"+rollNo+"'); ";
                ResultSet rs = c.s.executeQuery(str);
                T.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e){
                System.out.println(""+e);
            }
        }
        else  if (ae.getSource() == this.Submit) {

            try {
                String str = "UPDATE `stud_mon_sys`.`details` SET `Attendance` = '"+attendance+"',Absentee ='"+absentee+"' WHERE(`RollNo` = '"+rollNo+"');";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Data has been Submitted Successfully!!!");
                new attendance();
                setVisible(false);
            }
            catch (Exception e){
                System.out.println(""+e);
            }
        }
        else if (ae.getSource()==back) {
             new attendance();
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new addAttendence();
    }

}
