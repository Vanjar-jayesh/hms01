package hospital.managemet.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_Discharge extends JFrame {
    Patient_Discharge(){

        JPanel jPanel = new JPanel();
        jPanel.setBounds(5,5,790,360);
        jPanel.setBackground(new Color(15, 231, 66));
        jPanel.setLayout(null);
        add(jPanel);

        JLabel label = new JLabel("Check-out");
        label.setBounds(100,20,160,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.white);
        jPanel.add(label);

        JLabel label2 = new JLabel("Customer Id");
        label2.setBounds(30,80,160,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        jPanel.add(label2);


        Choice choice = new Choice();
        choice.setBounds(200,80,160,25);
        jPanel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from Patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Numbere"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30,130,160,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        jPanel.add(label3);

        JLabel RN = new JLabel();
        RN.setBounds(200,130,160,20);
        RN.setFont(new Font("Tahoma",Font.BOLD,14));
        RN.setForeground(Color.white);
        jPanel.add(RN);


        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30,180,160,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        jPanel.add(label4);


        JLabel INTime = new JLabel();
        INTime.setBounds(200,180,250,20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,14));
        INTime.setForeground(Color.white);
        jPanel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30,230,160,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        jPanel.add(label5);

        Date date = new Date();

        JLabel Outime = new JLabel(""+date);
        Outime.setBounds(200,230,250,20);
        Outime.setFont(new Font("Tahoma",Font.BOLD,14));
        Outime.setForeground(Color.white);
        jPanel.add(Outime);

        JButton jButton = new JButton("Discharge");
        jButton.setBounds(30,300,120,30);
        jButton.setBackground(Color.black);
        jButton.setForeground(Color.white);
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    c.statement.executeUpdate("delete from Patient_info where Numbere = '"+choice.getSelectedItem()+"' ");
                    c.statement.executeUpdate("update Room set Avaliability = 'Avaliable' where Room_number ='"+RN.getText()+"' ");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton jButton1 = new JButton("Check");
        jButton1.setBounds(170,300,120,30);
        jButton1.setBackground(Color.black);
        jButton1.setForeground(Color.white);
        jPanel.add(jButton1);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    ResultSet resultSet = c.statement.executeQuery("Select *from Patient_info where Numbere = '"+choice.getSelectedItem()+"' ");
                    while (resultSet.next()){
                        RN.setText(resultSet.getString("Room_number"));
                        INTime.setText(resultSet.getString("Time"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton jButton2 = new JButton("Back");
        jButton2.setBounds(300,300,120,30);
        jButton2.setBackground(Color.black);
        jButton2.setForeground(Color.white);
        jPanel.add(jButton2);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Patient_Discharge();
    }
}

