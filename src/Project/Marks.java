package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Marks extends JFrame implements ActionListener {
    JLabel l1 , l2 ,l3,l4,l5,l6,l7,l8 ;
    JTextField Sub1, Sub2, Sub3, Sub4, Sub5, Total,Name, RollNo;
    JButton display , update,back;
    int tw = 150;
    int th = 50;
    String total1;
    String mechanics, maths1, bee,physics1,chemistry1,maths2,edg,cp,physics2,chemistry2,name,rollNo;
    Marks(){
        setSize(500,650);
        setBounds(150,10,500,650);
        ImageIcon i9 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i =i9.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon I=new ImageIcon(i);
        back = new JButton(I);
        back.setBounds(0, 0, 40, 40);
        back.addActionListener(this);
        add(back);

        l1 = new JLabel("Name :");
        l1.setBounds(60,150,150,50);
        add(l1);

        l2 = new JLabel("RollNO :");
        l2.setBounds(60,100,150,50);
        add(l2);

        l3 = new JLabel("Subject 1");
        l3.setBounds(60,200,150,50);
        add(l3);
        l4 = new JLabel("Subject 2");
        l4.setBounds(60,250,150,50);
        add(l4);
        l5 = new JLabel("Subject 3");
        l5.setBounds(60,300,150,50);
        add(l5);
        l6 = new JLabel("Subject 4");
        l6.setBounds(60,350,150,50);
        add(l6);
        l7 = new JLabel("Subject 5");
        l7.setBounds(60,400,150,50);
        add(l7);
        l8 = new JLabel("Total :");
        l8.setBounds(60,450,150,50);
        add(l8);

        Name = new JTextField();
        Name.setBounds(150,150,tw,50);
        add(Name);

        RollNo = new JTextField();
        RollNo.setBounds(150,100,tw,50);
        add(RollNo);

        Sub1 = new JTextField();
        Sub1.setBounds(150,200,tw,th);
        add(Sub1);

        Sub2 = new JTextField();
        Sub2.setBounds(150,250,tw,th);
        add(Sub2);

        Sub3 = new JTextField();
        Sub3.setBounds(150,300,tw,th);
        add(Sub3);

        Sub4 = new JTextField();
        Sub4.setBounds(150,350,tw,th);
        add(Sub4);

        Sub5 = new JTextField();
        Sub5.setBounds(150,400,tw,th);
        add(Sub5);

        Total = new JTextField();
        Total.setBounds(150,450,tw,th);
        add(Total);


        display = new JButton("Calculate");
        display.setBounds(300,450,100,40);
        display.addActionListener(this);
        add(display);

        update = new JButton("Update");
        update.setBounds(150,550,100,40);
        update.addActionListener(this);
        add(update);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/mark.png"));
        Image i3 =i1.getImage().getScaledInstance(500,700,Image.SCALE_SMOOTH);
        ImageIcon i4 =new ImageIcon(i3);
        JLabel i2 =new JLabel(i4);
        i2.setBounds(0,0,500,700);
        add(i2);

        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==display){
            total1 = String.valueOf(Integer.parseInt(Sub1.getText())+Integer.parseInt(Sub2.getText())+Integer.parseInt(Sub3.getText())+Integer.parseInt(Sub4.getText())+Integer.parseInt(Sub5.getText()));
            Total.setText(total1);
        }

        if(ae.getSource()==update){
            if(Dis_Marks.SEM1.isShowing()){
            mechanics = this.Sub1.getText();
            maths1 = this.Sub2.getText();
            bee = this.Sub3.getText();
            physics1 = this.Sub4.getText();
            chemistry1 = this.Sub5.getText();
            rollNo = this.RollNo.getText();
            name = this.Name.getText();

            connector c = new connector();
            try{
                String str1 = "INSERT INTO `stud_mon_sys`.`sem1` (`RollNo`, `Name`, `Mechanics`, `Maths1`, `BEE`, `Physics1`, `Chemistry1`, `Total`) VALUES ('"+rollNo+"', '"+name+"', '"+mechanics+"', '"+maths1+"', '"+bee+"', '"+physics1+"', '"+chemistry1+"', '"+total1+"'); ";
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"Marks added Successfully!");
            }catch(Exception e){
                System.out.println(e);
            }
            }
            else if(Dis_Marks.SEM2.isShowing()){
                cp = this.Sub1.getText();
                maths2 = this.Sub2.getText();
                edg = this.Sub3.getText();
                physics2 = this.Sub4.getText();
                chemistry2 = this.Sub5.getText();
                name = this.Name.getText();
                rollNo = this.RollNo.getText();
                connector c = new connector();
                try{
                    String str1 = "INSERT INTO `stud_mon_sys`.`sem2` (`RollNo`, `Name`, `Maths2`,`EDG`, `CProgramming`, `Physics2`, `Chemistry2`, `Total`) VALUES ('"+rollNo+"', '"+name+"', '"+maths2+"', '"+edg+"', '"+cp+"', '"+physics2+"', '"+chemistry2+"', '"+total1+"'); ";
                    c.s.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null,"Marks added Successfully!");
                }catch(Exception e){
                    System.out.println(e);
                }

            }
            new Dis_Marks();
        }
        else if (ae.getSource()==back) {
            new Dis_Marks();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Marks();
    }

}
