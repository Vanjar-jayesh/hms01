package hospital.managemet.system;

import javax.swing.*;
import java.awt.*;
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
        INTime.setBounds(200,180,160,20);
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
        Outime.setBounds(200,230,160,20);
        Outime.setFont(new Font("Tahoma",Font.BOLD,14));
        Outime.setForeground(Color.white);
        jPanel.add(Outime);





















        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Patient_Discharge();
    }
}
