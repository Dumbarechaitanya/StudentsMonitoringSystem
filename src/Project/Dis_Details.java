package Project;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Dis_Details extends JFrame implements ActionListener {
    JTable T;
    JScrollPane sp;
    JButton add,delete,relod,update,back;
    Dis_Details (){
        setSize(1100,650);
        sp = new JScrollPane();
        sp.setBounds(50,50,1000,300);
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

        add = new JButton("ADD Student");
        add.setBounds(200, 500, 150, 50);
        add.addActionListener(this);
        add(add);

        delete = new JButton("Delete");
        delete.setBounds(500, 500, 150, 50);
        delete.addActionListener(this);
        add(delete);

        update = new JButton("Update");
        update.setBounds(800, 500, 150, 50);
        update.addActionListener(this);
        add(update);

        Display();

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image i3 =i1.getImage().getScaledInstance(1100,650,Image.SCALE_SMOOTH);
        ImageIcon i4 =new ImageIcon(i3);
        JLabel i2 =new JLabel(i4);
        i2.setBounds(0,0,1100,650);
        add(i2);
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("images/reload.png"));
        Image i7 =i5.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon i8 =new ImageIcon(i7);

        relod = new JButton(i8);
        relod.setBounds(1030, 30, 20, 20);
        relod.addActionListener(this);
        add(relod);


        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

    }

     void Display() {
         connector c = new connector();
         try {
             String str = "select * from stud_mon_sys.details;";
             ResultSet rs = c.s.executeQuery(str);
             T.setModel(DbUtils.resultSetToTableModel(rs));

         }catch (Exception e){
             System.out.println(e);
         }

     }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            new Details();
            setVisible(false);
        }
        else if (e.getSource()==this.delete) {

        }
        else if (e.getSource()==relod) {
            Display();
        }
        else if (e.getSource()==update) {

        }
        else if (e.getSource()==back) {
            new Task();
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Dis_Details();
    }



}
