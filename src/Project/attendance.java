package Project;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class attendance extends JFrame implements ActionListener {
    JButton add,defaulters, reload,back;
    JTable T;
    JScrollPane sp;

    attendance(){
        setSize(1000,650);
        sp = new JScrollPane();
        sp.setBounds(350,50,600,300);
        add(sp);
        T = new JTable();
        sp.setViewportView(T);

        ImageIcon i9 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i =i9.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon I=new ImageIcon(i);
        back = new JButton(I);
        back.setBounds(0, 0, 40, 40);
        back.addActionListener(this);
        add(back);

        add = new JButton("ADD/Update");
        add.setBounds(50, 200, 150, 50);
        add.addActionListener(this);
        add(add);
        defaulters = new JButton("Defaulters");
        defaulters.setBounds(50, 400, 150, 50);
        defaulters.addActionListener(this);
        add(defaulters);

        Displayoriginal();

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image i3 =i1.getImage().getScaledInstance(1000,650,Image.SCALE_SMOOTH);
        ImageIcon i4 =new ImageIcon(i3);
        JLabel i2 =new JLabel(i4);
        i2.setBounds(0,0,1000,650);
        add(i2);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("images/reload.png"));
        Image i7 =i5.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon i8 =new ImageIcon(i7);

        reload = new JButton(i8);
        reload.setBounds(930, 350, 20, 20);
        reload.addActionListener(this);
        add(reload);
        i2.add(reload);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    void Displayoriginal(){
        connector c = new connector();
        try {
            String str = "select RollNo,Name,Address,ContactNo,Attendance,Absentee from stud_mon_sys.details;";
            ResultSet rs = c.s.executeQuery(str);
            T.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add) {
            new addAttendence();
        }
        else  if (ae.getSource() == reload) {
           Displayoriginal();
        }
        else if (ae.getSource()==defaulters) {
            connector c = new connector();
            try {
                String str = "select RollNo,Name,Address,ContactNo,Attendance,Absentee from stud_mon_sys.details where (Attendance<'135 '); ";
                ResultSet rs = c.s.executeQuery(str);
                T.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e){
                System.out.println(""+e);
            }
        }
        else if (ae.getSource()==back) {
            new Task();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new attendance();
    }
}