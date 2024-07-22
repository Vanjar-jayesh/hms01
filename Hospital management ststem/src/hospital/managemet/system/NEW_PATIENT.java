package hospital.managemet.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

public class NEW_PATIENT extends JFrame  implements ActionListener {

    JComboBox comboBox;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1, r2;
    Choice c1;
    JLabel Date;
    JButton b1, b2;

    NEW_PATIENT() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("hospital/icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENE FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelName);


        JLabel labeLID = new JLabel("ID : ");
        labeLID.setBounds(35, 76, 200, 14);
        labeLID.setFont(new Font("Tahoma", Font.BOLD, 14));
        labeLID.setForeground(Color.white);
        panel.add(labeLID);

        comboBox = new JComboBox(new String[]{"Aadhar Card", "Voter Id", "Driving License"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(comboBox);


        JLabel labelNumber = new JLabel("Number : ");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name : ");
        labelName1.setBounds(35, 151, 200, 14);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelName1.setForeground(Color.white);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271, 151, 150, 20);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(189, 164, 170));
        r1.setBounds(271, 191, 80, 20);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(189, 164, 170));
        r2.setBounds(350, 191, 80, 20);
        panel.add(r2);

        JLabel labelDisease = new JLabel("Disease : ");
        labelDisease.setBounds(35, 231, 200, 14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 231, 150, 20);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room : ");
        labelRoom.setBounds(35, 274, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);

        // Room choice //
        c1=new Choice();
        try {
                conn c =new conn();
            ResultSet resultSet = c.statement.executeQuery("select *from Room");
            while (resultSet.next()){
                c1.add(resultSet.getString("Room_number"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        c1.setBounds(271,274,150,26);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);


        JLabel labelDate = new JLabel("Time : ");
        labelDate.setBounds(35, 316, 200, 14);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDate.setForeground(Color.white);
        panel.add(labelDate);

        Date date1 = new Date();

        Date = new JLabel("" + date1);
        Date.setBounds(271, 316, 250, 14);
        Date.setForeground(Color.white);
        Date.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Date);

        JLabel labelDeposite = new JLabel(" Deposite: ");
        labelDeposite.setBounds(35, 359, 200, 20);
        labelDeposite.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDeposite.setForeground(Color.white);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271, 359, 150, 20);
        panel.add(textFieldDeposite);

        b1 = new JButton("ADD ");
        b1.setBounds(100, 430, 120, 30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        panel.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Back");
        b2.setBounds(260, 430, 120, 30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        panel.add(b2);
        b2.addActionListener(this);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //   new Reception();
            }
        });


        setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource()==b1){
                conn c = new conn();
                String radioBTN = null;
                if (r1.isSelected()){
                    radioBTN = "Male";
                }
                else if (r2.isSelected()){
                    radioBTN = "Female";
                }

                String s1 = (String) comboBox.getSelectedItem();
                String s2 = textFieldNumber.getText();
                String s3 = textName.getText();
                String s4 = radioBTN;
                String s5 = textFieldDisease.getText();
                String s6 = c1.getSelectedItem();
                String s7 = Date.getText();
                String  s8 = textFieldDeposite.getText();


                try {
                    String q = "insert into Patient_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                    String q1 = "Update room set Avaliability = 'Occupied' where Room_number = "+s6;
                    c.statement.executeUpdate(q);
                    c.statement.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"Added successfully");
                    setVisible(false);

                }catch (Exception E){
                    E.printStackTrace();
                }

            }else {
                setVisible(false);
            }



    }

    public static void main(String[] args) {
        new NEW_PATIENT();
    }

}
