package hospital.managemet.system;

import javax.swing.*;
import java.awt.*;

public class Employee_info extends JFrame {
    Employee_info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(86, 31, 225));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
         table.setBounds(10,34,980,450);
        table.setBackground(new Color(189,164,170));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "Select *from Emp_Info;";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel jLabel1 = new JLabel("Name");
        jLabel1.setBounds(41,9,70,20);
        jLabel1.setFont(new Font("Tahoma",Font.BOLD,12));
        jLabel1.setBackground(Color.black);
        jLabel1.setForeground(Color.white);
        panel.add(jLabel1);

        JLabel jLabel2 = new JLabel("Age");
        jLabel2.setBounds(189,9,70,20);
        jLabel2.setFont(new Font("Tahoma",Font.BOLD,12));
        jLabel2.setBackground(Color.black);
        jLabel2.setForeground(Color.white);
        panel.add(jLabel2);

        JLabel jLabel3= new JLabel("Phone Number");
        jLabel3.setBounds(350,9,150,20);
        jLabel3.setFont(new Font("Tahoma",Font.BOLD,12));
        jLabel3.setBackground(Color.black);
        jLabel3.setForeground(Color.white);
        panel.add(jLabel3);

        JLabel jLabel4= new JLabel("Salary");
        jLabel4.setBounds(500,9,150,20);
        jLabel4.setFont(new Font("Tahoma",Font.BOLD,12));
        jLabel4.setBackground(Color.black);
        jLabel4.setForeground(Color.white);
        panel.add(jLabel4);

        JLabel jLabel5= new JLabel("Gmail_ID");
        jLabel5.setBounds(680,9,150,20);
        jLabel5.setFont(new Font("Tahoma",Font.BOLD,12));
        jLabel5.setBackground(Color.black);
        jLabel5.setForeground(Color.white);
        panel.add(jLabel5);

        JLabel jLabel6= new JLabel("Aadhar_number");
        jLabel6.setBounds(840,9,150,20);
        jLabel6.setFont(new Font("Tahoma",Font.BOLD,12));
        jLabel6.setBackground(Color.black);
        jLabel6.setForeground(Color.white);
        panel.add(jLabel6);

        JButton b1 = new JButton("BACk");
        b1.setBounds(350,500,120,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(1000,600);
        setLocation(350,230);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
     new  Employee_info();
    }
}
