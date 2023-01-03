package Project;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class Details extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9,l10;
    JTextField Name, Age, Aadhaar, GrNo, Address, ContactNo,RollNo;
    JDateChooser DOB;
    JRadioButton Male, Female;
    JButton Submit, back;
   static String name, age, aadhaar, grno, address, contactNo,rollNo,dob,gender;
    ButtonGroup bg;
    int lx = 150, lh = 20, lw = 150;  //size Variables.
    int tx = 250, tw = 250, th = 30;
    public Font F = new Font("Times New Roman", Font.BOLD, 20);

    Details() {


        setSize(750, 900);

        l9 = new JLabel("Details...");
        l9.setBounds(200, 10, 500, 75);
        l9.setFont(new Font("Times New Roman", Font.BOLD, 50));
        add(l9);


        l1 = new JLabel("GrNo");
        l1.setBounds(lx, 100, lw, lh);
        l1.setFont(F);
        add(l1);
        l2 = new JLabel("RollNo");
        l2.setBounds(lx, 150, lw, lh);
        l2.setFont(F);
        add(l2);

        l2 = new JLabel("Name");
        l2.setBounds(lx, 200, lw, lh);
        l2.setFont(F);
        add(l2);

        l3 = new JLabel("DOB");
        l3.setBounds(lx, 250, lw, lh);
        l3.setFont(F);
        add(l3);

        l4 = new JLabel("Age");
        l4.setBounds(lx, 300, lw, lh);
        l4.setFont(F);
        add(l4);

        l5 = new JLabel("Gender");
        l5.setBounds(lx, 350, lw, lh);
        l5.setFont(F);
        add(l5);

        l6 = new JLabel("Address");
        l6.setBounds(lx, 400, lw, lh);
        l6.setFont(F);
        add(l6);

        l8 = new JLabel("Contact No");
        l8.setBounds(lx, 450, lw, lh);
        l8.setFont(F);
        add(l8);

        l7 = new JLabel("Aadhaar");
        l7.setBounds(lx, 500, lw, lh);
        l7.setFont(F);
        add(l7);


        GrNo = new JTextField();
        GrNo.setBounds(tx, 100, tw, th);
        add(GrNo);

        RollNo = new JTextField();
        RollNo.setBounds(tx, 150, tw, th);
        add(RollNo);

        Name = new JTextField();
        Name.setBounds(tx, 200, tw, th);
        add(Name);

        Age = new JTextField();
        Age.setBounds(tx, 300, tw, th);
        add(Age);

        Address = new JTextField();
        Address.setBounds(tx, 400, tw, th);
        add(Address);

        ContactNo = new JTextField();
        ContactNo.setBounds(tx, 450, tw, th);
        add(ContactNo);

        Aadhaar = new JTextField();
        Aadhaar.setBounds(tx, 500, tw, th);
        add(Aadhaar);

        DOB = new JDateChooser();
        DOB.setBounds(tx, 250, tw, th);
        add(DOB);

        bg = new ButtonGroup();

        Male = new JRadioButton("Male");
        Male.setBounds(tx, 350, 75, lh);
        bg.add(Male);
        this.add(Male);

        Female = new JRadioButton("Female");
        Female.setBounds(325, 350, 75, lh);
        bg.add(Female);
        this.add(Female);

        Submit = new JButton("Submit");
        Submit.setBounds(250, 550, 75, 50);
        Submit.addActionListener(this);
        add(Submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/BlackBoard.png"));
        Image i3 =i1.getImage().getScaledInstance(750,700,Image.SCALE_SMOOTH);
        ImageIcon i4 =new ImageIcon(i3);
        JLabel i2 =new JLabel(i4);
        i2.setBounds(0,0,750,650);
        add(i2);
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("images/reload.png"));
        Image i7 =i5.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon i8 =new ImageIcon(i7);

        ImageIcon i9 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i =i9.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon I=new ImageIcon(i);
        back = new JButton(I);
        back.setBounds(0, 0, 40, 40);
        back.addActionListener(this);
        add(back);


        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);


    }//

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == this.Submit) {
            grno = this.GrNo.getText();
            name = this.Name.getText();
            age  = this.Age.getText();
            address = this.Address.getText();
            contactNo = this.ContactNo.getText();
            aadhaar = this.Aadhaar.getText();
            rollNo = this.RollNo.getText();

            //For storing date.
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dob = dateFormat.format(this.DOB.getDate());

            //For Storing Gender.
            gender = null;
            if(this.Male.isSelected()){
                gender = "Male";

            }
            else if (this.Female.isSelected()){
                gender = "Female";
            }

            connector c = new connector();

            try {
                String str = "insert into details (GrNo,RollNo,Name,DOB,Age,Gender,Address,ContactNo,Aadhaar) values('"+grno+"','"+rollNo+"','"+name+"','"+dob+"','"+age+"','"+gender+"','"+address+"','"+contactNo+"','"+aadhaar+"');";
                 c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Data has been Submitted Successfully!!!");

            }catch (Exception e){
                System.out.println(""+e);
            }
            new Dis_Details();
            setVisible(false);
        }
        else if (a.getSource()==back) {
            new Dis_Details();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Details();
    }

}
