package hospital.managemet.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ALL_Patient_Info extends JFrame {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    ALL_Patient_Info(){

        JPanel jPanel = new JPanel();
        jPanel.setBounds(5,5,930,590);
        jPanel.setBackground(new Color(90,134,32));
        jPanel.setLayout(null);
        add(jPanel);


        JTable jTable = new JTable();
        jTable.setBounds(10,40,940,450);
        jTable.setBackground(new Color(90,156,163));
        jTable.setFont(new Font("Tahoma",Font.BOLD,12));
//        jTable.setRowHeight(8,8);
//        jTable.setRowMargin(10);
//        jTable.setLayout(null);
        jPanel.add(jTable);

        try {
            conn c = new conn();
            String q = "Select *from Patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            jTable.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

         l1 = new JLabel("ID");
         l1.setBounds(33,11,100,14);
         l1.setFont(new Font("Tahoma",Font.BOLD,18));
         l1.setForeground(Color.white);
         jPanel.add(l1);

         l2 = new JLabel("Number");
         l2.setBounds(125,11,100,14);
         l2.setFont(new  Font("Tahoma",Font.BOLD,18));
         l2.setForeground(Color.white);
         jPanel.add(l2);

        l3 = new JLabel("Name");
        l3.setBounds(240,11,100,14);
        l3.setFont(new  Font("Tahoma",Font.BOLD,18));
        l3.setForeground(Color.white);
        jPanel.add(l3);


        l4 = new JLabel("Gende");
        l4.setBounds(370,11,100,14);
        l4.setFont(new  Font("Tahoma",Font.BOLD,18));
        l4.setForeground(Color.white);
        jPanel.add(l4);

        l5= new JLabel("DIscase");
        l5.setBounds(470,11,100,14);
        l5.setFont(new  Font("Tahoma",Font.BOLD,18));
        l5.setForeground(Color.white);
        jPanel.add(l5);

        l6 = new JLabel("Room_no");
        l6.setBounds(570,11,100,14);
        l6.setFont(new  Font("Tahoma",Font.BOLD,18));
        l6.setForeground(Color.white);
        jPanel.add(l6);

        l7= new JLabel("Time");
        l7.setBounds(740,11,100,14);
        l7.setFont(new  Font("Tahoma",Font.BOLD,18));
        l7.setForeground(Color.white);
        jPanel.add(l7);

        l8= new JLabel("Deposite");
        l8.setBounds(840,11,100,14);
        l8.setFont(new  Font("Tahoma",Font.BOLD,18));
        l8.setForeground(Color.white);
        jPanel.add(l8);

        JButton button = new JButton("BACk");
        button.setBounds(450,510,120,30);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        jPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });












        setSize(950,600);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);


    }
    public static void main(String[] args) {
        new  ALL_Patient_Info();
    }
}
