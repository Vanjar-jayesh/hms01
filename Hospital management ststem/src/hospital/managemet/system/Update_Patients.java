package hospital.managemet.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Patients extends JFrame {
    Update_Patients(){


        JPanel jPanel = new JPanel();
        jPanel.setBounds(5,5,940,490);
        jPanel.setBackground(new Color(15, 231, 66));
        jPanel.setLayout(null);
        add(jPanel);

            ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("hospital/icon/updated.png"));
            Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
            ImageIcon imageIcon1 = new ImageIcon(image);
            JLabel label = new JLabel(imageIcon1);
            label.setBounds(500,60,300,300);
            jPanel.add(label);

            JLabel label1 = new JLabel("Update_Discharge_Details");
            label1.setBounds(124,11,290,25);
            label1.setFont(new Font("Tahoma",Font.BOLD,20));
            label1.setForeground(Color.white);
            jPanel.add(label1);

           JLabel label2= new JLabel("Name :");
            label2.setBounds(25,88,75,14);
            label2.setFont(new Font("Tahoma",Font.PLAIN,14));
            label2.setForeground(Color.white);
            jPanel.add(label2);

            Choice choice = new Choice();
            choice.setBounds(248,85,140,25);
            jPanel.add(choice);


            try {

                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery("Select * from Patient_info");
                while (resultSet.next()){
                    choice.add(resultSet.getString("name"));
                }

            }catch (Exception e){
                e.printStackTrace();

            }
        JLabel label3= new JLabel("RoomNumber :");
        label3.setBounds(25,129,100,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        label3.setForeground(Color.white);
        jPanel.add(label3);

        JTextField textFieldr = new JTextField();
        textFieldr.setBounds(248,129,140,20);
        jPanel.add(textFieldr);

        JLabel label4= new JLabel("In-Time :");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.white);
        jPanel.add(label4);

        JTextField textFieldInTIme = new JTextField();
        textFieldInTIme.setBounds(248,174,140,20);
        jPanel.add(textFieldInTIme);

        JLabel label5= new JLabel("Amount Paid (RS):");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.white);
        jPanel.add(label5);

        JTextField textFieldAmont= new JTextField();
        textFieldAmont.setBounds(248,216,140,20);
        jPanel.add(textFieldAmont);

        JLabel label6= new JLabel("Pending Amount(RS):");
        label6.setBounds(25,261,150,14);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        label6.setForeground(Color.white);
        jPanel.add(label6);

        JTextField textFieldPending= new JTextField();
        textFieldPending.setBounds(248,261,140,20);
        jPanel.add(textFieldPending);


        JButton check = new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        jPanel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "Select * from Patient_info where name = '"+id+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textFieldr.setText(resultSet.getString("Room_number"));
                        textFieldInTIme.setText(resultSet.getString("Time"));
                        textFieldAmont.setText(resultSet.getString("Deposite"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select* from Room where Room_number = '"+textFieldr.getText()+"'");
                    while (resultSet1.next()){
                        String  Price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(Price) - Integer.parseInt(textFieldAmont.getText());
                        textFieldPending.setText(" "+amountPaid);
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Update= new JButton("UPDATE");
        Update.setBounds(56,378,89,23);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.white);
        jPanel.add(Update);
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String Room = textFieldr.getText();
                    String Time = textFieldInTIme.getText();
                    String amount = textFieldAmont.getText();

                    c.statement.executeUpdate("update Patient_info set Room_number = '"+Room+"', Time='"+Time+"',Deposite='"+amount+"' where name='"+q+"'");
                    JOptionPane.showMessageDialog( null,"Updated Succeesfule");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton Back= new JButton("BACK");
        Back.setBounds(168,378,89,23);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        jPanel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Update_Patients();
    }
}
