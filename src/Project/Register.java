package Project;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class Register extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23;
    JTextField Username,SecurityAnswer,FN,MN,LN,N,O,MobNo,Email,Country,Fln,srt,A,St,PhNo,Pin,Ct;
    JPasswordField Password,ConfirmPassword;
    JRadioButton Male,Female;
    ButtonGroup bg;
    JDateChooser DOB;
    JButton Continue1,Continue2,Continue3,Submit;
    JTabbedPane tabs;
    JTable basicdetails,personaldetails,address,professionaldetails;
    int lx = 20, lh = 20, lw = 250;  //size Variables.
    int tx = 250, tw = 250, th = 30;
    JComboBox<String> SecurityQuestion;
    // public Font F = new Font("Times New Roman", Font.BOLD, 20);
    String[] SQ= {"What is your date of birth?","What was your favorite school teacher’s name?","What’s your favorite movie?","What was your first car?","What is your Pets name"};
    Register(){
        setSize(900,650);

        basicdetails = new JTable();
        basicdetails.setBounds(0,100,600,600);
        basicdetails.setFont(new Font("Times New Roman",Font.BOLD,20));
        this.add(basicdetails);



        personaldetails = new JTable();
        personaldetails.setBounds(5,150,350,450);
        personaldetails.setFont(new Font("Times New Roman",Font.BOLD,20));
        this.add(personaldetails);

        address = new JTable();
        address.setBounds(5,20,350,450);
        address.setFont(new Font("Times New Roman",Font.BOLD,20));
        this.add(address);

        professionaldetails = new JTable();
        professionaldetails.setBounds(5,20,350,450);
        professionaldetails.setFont(new Font("Times New Roman",Font.BOLD,20));
        this.add(professionaldetails);


        l1 = new JLabel("Create Your Account");
        l1.setBounds(10,10,200,50);
        l1.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(l1);

        l2 = new JLabel("Username");
        l2.setBounds(lx,50,lw,lh);
        l2.setFont(new Font("Times New Roman",Font.BOLD,20));
        basicdetails.add(l2);

        l3 = new JLabel("Password");
        l3.setBounds(lx,150,lw,lh);
        l3.setFont(new Font("Times New Roman",Font.BOLD,20));
        basicdetails.add(l3);
        l4 = new JLabel("Confirm Password");
        l4.setBounds(lx,250,lw,lh);
        l4.setFont(new Font("Times New Roman",Font.BOLD,20));
        basicdetails.add(l4);

        l5 = new JLabel("Security Question");
        l5.setBounds(lx,350,lw,lh);
        l5.setFont(new Font("Times New Roman",Font.BOLD,20));
        basicdetails.add(l5);

        l6 = new JLabel("Security Answer");
        l6.setBounds(lx,450,lw,lh);
        l6.setFont(new Font("Times New Roman",Font.BOLD,20));
        basicdetails.add(l6);

        Username =new JTextField("");
        Username.setBounds(tx,50,tw,th);
        basicdetails.add(Username);

        Password =new JPasswordField("");
        Password.setBounds(tx,150,tw,th);
        basicdetails.add(Password);

        ConfirmPassword =new JPasswordField("");
        ConfirmPassword.setBounds(tx,250,tw,th);
        basicdetails.add(ConfirmPassword);

        SecurityQuestion= new JComboBox<>(SQ);
        SecurityQuestion.setBounds(tx,350,tw,th);
        basicdetails.add(SecurityQuestion);

        SecurityAnswer =new JTextField("");
        SecurityAnswer.setBounds(tx,450,tw,th);
        basicdetails.add(SecurityAnswer);

        Continue1 = new JButton("Continue");
        Continue1.setBounds(450,500,100,30);
        Continue1.addActionListener(this);
        basicdetails.add(Continue1);

        //personal details
        l8= new JLabel("First Name");
        l8.setBounds(lx,30,lw,lh);
        l8.setFont(new Font("Times New Roman",Font.BOLD,20));
        personaldetails.add(l8);
        l9 = new JLabel("Middle name");
        l9.setBounds(lx,80,lw,lh);
        l9.setFont(new Font("Times New Roman",Font.BOLD,20));
        personaldetails.add(l9);
        l10 = new JLabel("Last name");
        l10.setBounds(lx,130,lw,lh);
        l10.setFont(new Font("Times New Roman",Font.BOLD,20));
        personaldetails.add(l10);

        l7 = new JLabel("DOB");
        l7.setBounds(lx,180,lw,lh);
        l7.setFont(new Font("Times New Roman",Font.BOLD,20));
        personaldetails.add(l7);

        l16 = new JLabel("Gender");
        l16.setBounds(lx,230,lw,lh);
        l16.setFont(new Font("Times New Roman",Font.BOLD,20));
        personaldetails.add(l16);

        bg = new ButtonGroup();

        Male = new JRadioButton("Male");
        Male.setBounds(tx, 230, 75, lh);
        bg.add(Male);
        this.personaldetails.add(Male);

        Female = new JRadioButton("Female");
        Female.setBounds(325, 230, 75, lh);
        bg.add(Female);
        this.personaldetails.add(Female);

        l11 = new JLabel("Occupation");
        l11.setBounds(lx,280,lw,lh);
        l11.setFont(new Font("Times New Roman",Font.BOLD,20));
        personaldetails.add(l11);
        l12 = new JLabel("Email");
        l12.setBounds(lx,330,lw,lh);
        l12.setFont(new Font("Times New Roman",Font.BOLD,20));
        personaldetails.add(l12);
        l13 = new JLabel("Mobile No");
        l13.setBounds(lx,380,lw,lh);
        l13.setFont(new Font("Times New Roman",Font.BOLD,20));
        personaldetails.add(l13);
        l14 = new JLabel("Country");
        l14.setBounds(lx,430,lw,lh);
        l14.setFont(new Font("Times New Roman",Font.BOLD,20));
        personaldetails.add(l14);
        l15 = new JLabel("Nationality");
        l15.setBounds(lx,480,lw,lh);
        l15.setFont(new Font("Times New Roman",Font.BOLD,20));
        personaldetails.add(l15);

        FN =new JTextField("");
        FN.setBounds(tx,30,tw,th);
        personaldetails.add(FN);
        MN =new JTextField("");
        MN.setBounds(tx,80,tw,th);
        personaldetails.add(MN);
        LN =new JTextField("");
        LN.setBounds(tx,130,tw,th);
        personaldetails.add(LN);
        O =new JTextField("");
        O.setBounds(tx,280,tw,th);
        this.personaldetails.add(O);
        Email =new JTextField("");
        Email.setBounds(tx,330,tw,th);
        personaldetails.add(Email);
        MobNo =new JTextField("");
        MobNo.setBounds(tx,380,tw,th);
        personaldetails.add(MobNo);
        Country =new JTextField("");
        Country.setBounds(tx,430,tw,th);
        personaldetails.add(Country);
        N=new JTextField("");
        N.setBounds(tx,480,tw,th);
        personaldetails.add(N);

        DOB = new JDateChooser();
        DOB.setBounds(tx, 180, tw, th);
        personaldetails.add(DOB);

        Continue2 = new JButton("Continue");
        Continue2.setBounds(450,510,100,30);
        Continue2.addActionListener(this);
        personaldetails.add(Continue2);

        //address
        l17= new JLabel("FlatNo");
        l17.setBounds(lx,50,lw,lh);
        l17.setFont(new Font("Times New Roman",Font.BOLD,20));
        address.add(l17);
        l18= new JLabel("Street");
        l18.setBounds(lx,100,lw,lh);
        l18.setFont(new Font("Times New Roman",Font.BOLD,20));
        address.add(l18);
        l19= new JLabel("Area");
        l19.setBounds(lx,150,lw,lh);
        l19.setFont(new Font("Times New Roman",Font.BOLD,20));
        address.add(l19);
        l20= new JLabel("Pincode");
        l20.setBounds(lx,200,lw,lh);
        l20.setFont(new Font("Times New Roman",Font.BOLD,20));address.add(l20);
        l21= new JLabel("State");
        l21.setBounds(lx,250,lw,lh);
        l21.setFont(new Font("Times New Roman",Font.BOLD,20));
        address.add(l21);
        l22= new JLabel("City");
        l22.setBounds(lx,300,lw,lh);
        l22.setFont(new Font("Times New Roman",Font.BOLD,20));
        address.add(l22);
        l23= new JLabel("MobNo");
        l23.setBounds(lx,350,lw,lh);
        l23.setFont(new Font("Times New Roman",Font.BOLD,20));
        address.add(l23);

        Fln =new JTextField("");
        Fln.setBounds(tx,50,tw,th);
        address.add(Fln);

        srt =new JTextField("");
        srt.setBounds(tx,100,tw,th);
        address.add(srt);

        A =new JTextField("");
        A.setBounds(tx,150,tw,th);
        address.add(A);

        Pin =new JTextField("");
        Pin.setBounds(tx,200,tw,th);
        address.add(Pin);

        St =new JTextField("");
        St.setBounds(250,250,250,30);
        address.add(St);

        Ct =new JTextField("");
        Ct.setBounds(tx,300,tw,th);
        address.add(Ct);

        PhNo =new JTextField("");
        PhNo.setBounds(tx,350,tw,th);
        address.add(PhNo);

        Continue3 = new JButton("Continue");
        Continue3.setBounds(350,450,100,30);
        Continue3.addActionListener(this);
        address.add(Continue3);
        //professionaldetails

        Submit = new JButton("Submit");
        Submit.setBounds(350,500,75,30);
        Submit.addActionListener(this);
        professionaldetails.add(Submit);

        tabs = new JTabbedPane();
        tabs.setBounds(20,50,600,700);
        tabs.add("Basic Details",basicdetails);
        tabs.setBounds(70,50,600,700);
        tabs.add("Personal Details",personaldetails);
        tabs.setBounds(120,50,600,700);
        tabs.add("Address",address);
        tabs.setBounds(120,50,600,700);
        tabs.add("Professional Details",professionaldetails);
        add(tabs);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Continue1) {
            String Username = this.Username.getText();
            String Password = String.valueOf(this.Password.getPassword());
            String ConfirmPassword = String.valueOf(this.ConfirmPassword.getPassword());
            if (!Password.equals(ConfirmPassword)){
                JOptionPane.showMessageDialog(null, "Incorrect Password!!!");
                new Register();
            }
            String SecurityQuestion = this.SecurityQuestion.getSelectedItem().toString();
            String SecurityAnswer = this.SecurityAnswer.getText();

            connector c = new connector();
            try {
                String str1 = "insert into stud_mon_sys.basicdetails (Username,Password,ConfirmPassword,SecurityQuestion,SecurityAnswer) values ('" + Username + "','"+Password +" ','" + ConfirmPassword + "','" + SecurityQuestion + "','" + SecurityAnswer + "');";
                String str = "insert into stud_mon_sys.login (Username,Password) values ('" + Username + "','"+Password +"' );";

                c.s.executeUpdate(str1);
                c.s.executeUpdate(str);
            } catch (Exception e) {
                System.out.println(""+e);
            }
            tabs.setSelectedIndex(1);

        } else if (ae.getSource() == Continue2) {
            String FirstName = this.FN.getText();
            String MiddleName = this.MN.getText();
            String LastName  = this.LN.getText();
            String Occupation = this.O.getText();
            String Email = this.Email.getText();
            String Mobile = this.MobNo.getText();
            String Country = this.Country.getText();
            String Nation = this.N.getText();
            //For storing date.
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String DOB = dateFormat.format(this.DOB.getDate());

            //For Storing Gender.
            String Gender = null;
            if(this.Male.isSelected()){
                Gender = "Male";

            }
            else if (this.Female.isSelected()){
                Gender = "Female";
            }

            connector c = new connector();


            try {
                if (FirstName==null||MiddleName==null||LastName==null||Gender==null||Occupation==null||Email==null||MobNo==null||Country==null||Nation==null) {
                    JOptionPane.showMessageDialog(null, "Insufficient Information!!!");
                }else {
                    String str = "insert into stud_mon_sys.personaldetails (FirstName,MiddleName,LastName,DOB,Gender,Occupation,Email,MobNo,Country,Nationality) values('" + FirstName + "','" + MiddleName + "','" + LastName + "','" + DOB + "','" + Gender + "','" + Occupation + "','" + Email + "','" + Mobile + "','" + Country + "','" + Nation + "');";
                    c.s.executeUpdate(str);
                }
            }catch (Exception e){
                System.out.println(" "+e);
            }
            tabs.setSelectedIndex(2);

        }
        else if (ae.getSource() ==Submit){
            String FlatNo = this.Fln.getText();
            String Street = this.srt.getText();
            String Area  = this.A.getText();
            String Pincode = this.Pin.getText();
            String Mobile = this.PhNo.getText();
            String State = this.St.getText();
            String City = this.Ct.getText();

            connector c = new connector();

            try {
                String str = "insert into stud_mon_sys.address (FlatNo,Street,Area,Pincode,State,City,MobNo) values('"+FlatNo+"','"+Street+"','"+Area+"','"+Pincode+"','"+State+"','"+City+"','"+Mobile+"');";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Data Submitted Successfully !!!");

            }catch (Exception e){
                System.out.println(" "+e);
            }
            setVisible(false);
            new Login();
        }
    }


    public static void main(String[] args) {
        new Register();
    }
}

