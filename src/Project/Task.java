package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task extends JFrame implements ActionListener {

    JButton Attendance ,Details,Marks,Cancel;
    Task(){
        setSize(510,400);
        Attendance = new JButton("Attendance");
        Attendance.setBounds(50,200,150,50);
        Attendance.addActionListener(this);
        add(Attendance);
        Details = new JButton("Details");
        Details.setBounds(300,200,150,50);
        Details.addActionListener(this);
        add(Details);
        Marks = new JButton("Marks");
        Marks.setBounds(50,300,150,50);
        Marks.addActionListener(this);
        add(Marks);
        Cancel = new JButton("Cancel");
        Cancel.setBounds(300,300,150,50);
        Cancel.addActionListener(this);
        add(Cancel);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/task.png"));
        Image i3 =i1.getImage().getScaledInstance(510,400,Image.SCALE_SMOOTH);
        ImageIcon i4 =new ImageIcon(i3);
        JLabel i2 =new JLabel(i4);
        i2.setBounds(0,0,510,400);
        add(i2);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){

        if (e.getSource() == Cancel) {
            new homepage();
            setVisible(false);
        }
        else if (e.getSource() == Details) {
            new Dis_Details();
            setVisible(false);
        }
        else if (e.getSource() == Attendance) {
            new attendance();
            setVisible(false);
        }
        else if (e.getSource() == Marks) {
            new Dis_Marks();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Task();
    }
}
