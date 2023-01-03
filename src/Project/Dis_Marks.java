package Project;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Dis_Marks extends JFrame implements ActionListener {
    JTabbedPane tab;
    JScrollPane sp1, sp2;
    static JTable SEM1,SEM2;
    JButton Add, P,F, reload,back;
    public static String rollNo;
    public static String Name;
    public static String Mechanics, CPrograming;
    public static String Maths1, Maths2;
    public static String BEE, EDG;
    public static String Physics1, Physics2;
    public static String Chemistry1, Chemistry2;
    public static String Total1, Total2;
    int row;

    Dis_Marks() {
        setSize(1100, 650);

        SEM1 = new JTable();
        sp1 = new JScrollPane();
        sp1.setViewportView(SEM1);

        SEM2 = new JTable();
        sp2 = new JScrollPane();
        sp2.setViewportView(SEM2);

        Display();

        tab = new JTabbedPane();
        tab.setBounds(350, 75, 650, 350);


        tab.add("SEM1", sp1);
        tab.add("SEM2", sp2);
        add(tab);

        Add = new JButton("ADD/Update");
        Add.setBounds(100, 100, 150, 50);
        Add.addActionListener(this);
        add(Add);

        P = new JButton("PASS");
        P.setBounds(50, 300, 100, 50);
        P.addActionListener(this);
        add(P);
        F = new JButton("FAIL");
        F.setBounds(150, 300, 100, 50);
        F.addActionListener(this);
        add(F);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("images/reload.png"));
        Image i7 =i5.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon i8 =new ImageIcon(i7);

        reload = new JButton(i8);
        reload.setBounds(980, 75, 20, 20);
        reload.addActionListener(this);
        add(reload);
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

    void sem1Select() {
        SEM1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = SEM1.getSelectedRow();
                rollNo = SEM1.getModel().getValueAt(row, 0).toString();
                Name = SEM1.getModel().getValueAt(row, 1).toString();
                Mechanics = SEM1.getModel().getValueAt(row, 2).toString();
                Maths1 = SEM1.getModel().getValueAt(row, 0).toString();
                BEE = SEM1.getModel().getValueAt(row, 0).toString();
                Physics1 = SEM1.getModel().getValueAt(row, 0).toString();
                Chemistry1 = SEM1.getModel().getValueAt(row, 0).toString();
                Total1 = SEM1.getModel().getValueAt(row, 0).toString();
            }
        });
    }

    void sem2Select() {
        SEM2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 row = SEM2.getSelectedRow();
                 rollNo =SEM2 .getModel().getValueAt(row,0).toString();
                 Name =SEM2 .getModel().getValueAt(row,1).toString();
                 CPrograming =SEM2 .getModel().getValueAt(row,2).toString();
                 Maths2 =SEM2 .getModel().getValueAt(row,3).toString();
                 EDG =SEM2. getModel().getValueAt(row,4).toString();
                 Physics2 =SEM2. getModel().getValueAt(row,5).toString();
                 Chemistry2 =SEM2 .getModel().getValueAt(row,6).toString();
                 Total2 =SEM2 .getModel().getValueAt(row,7).toString();
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Add) {
                if(SEM1.isShowing()){
                    sem1Select();
                }
                else if(SEM2.isShowing()){
                    sem2Select();
                }
                new Marks();


        }
        else if (ae.getSource()==this.P) {
            connector c = new connector();
            if(SEM1.isShowing()){
                try {
                String str ="SELECT * FROM stud_mon_sys.sem1 WHERE(Mechanics >'32'or Maths1 >'32' or BEE >'24' or Physics1 >'24' or Chemistry1 >'24')";
                    ResultSet rs = c.s.executeQuery(str);
                    SEM1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch (Exception e){
                    System.out.println(""+e);
                }
            }
            else if(SEM2.isShowing()){
                try{
                    String str ="SELECT * FROM stud_mon_sys.sem2 WHERE(Maths2>'32'or EDG>'24' or CProgramming >'24' or Physics2 >'24' or Chemistry2 >'24')";
                    ResultSet rs = c.s.executeQuery(str);
                    SEM2.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch (Exception e){
                    System.out.println(""+e);
                }
            }


        }
        else if (ae.getSource()==this.F) {
            connector c = new connector();
            if(SEM1.isShowing()){
                try {
                    String str ="SELECT * FROM stud_mon_sys.sem1 WHERE(Mechanics <'32'or Maths1 <'32' or BEE <'24' or Physics1 <'24' or Chemistry1 <'24')";
                    ResultSet rs = c.s.executeQuery(str);
                    SEM1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch (Exception e){
                    System.out.println(""+e);
                }
            }
            else if(SEM2.isShowing()){
                try{
                    String str ="SELECT * FROM stud_mon_sys.sem2 WHERE(Maths2<'32'or EDG<'24' or CProgramming <'24' or Physics2 <'24' or Chemistry2 <'24')";
                    ResultSet rs = c.s.executeQuery(str);
                    SEM2.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch (Exception e){
                    System.out.println(""+e);
                }
            }


        }
        else if (ae.getSource()== reload) {
            Display();
        }
        else if (ae.getSource()==back) {
            new Task();
            setVisible(false);
        }

    }
    void Display(){
        connector c = new connector();


        try {
            String str1 = "SELECT * FROM stud_mon_sys.sem1;";
            ResultSet rs = c.s.executeQuery(str1);
            SEM1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(""+e);
        }

        try {
            String str2 = "SELECT * FROM stud_mon_sys.sem2;";
            ResultSet rs1 = c.s.executeQuery(str2);
            SEM2.setModel(DbUtils.resultSetToTableModel(rs1));

        } catch (Exception e) {
            System.out.println(""+e);
        }

    }


    public static void main(String[] args) {
        new Dis_Marks();
    }
}

