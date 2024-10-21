package hospital.managemet.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class searchRoom extends JFrame {

            Choice choice = new Choice();
            JTable table = new JTable();
        searchRoom(){

            JPanel panel = new JPanel();
            panel.setBounds(5,5,690,490);
            panel.setBackground(new Color(90,156,163));
            panel.setLayout(null);
            add(panel);

            JLabel For = new JLabel("Search for Room");
            For.setBounds(250,11,186,31);
            For.setForeground(Color.white);
            For.setFont(new Font("Tahoma",Font.BOLD,20));
            panel.add(For);

            JLabel status = new JLabel("Status");
            status .setBounds(70,70,80,20);
            status .setForeground(Color.white);
            status .setFont(new Font("Tahoma",Font.BOLD,15));
            panel.add(status );

            choice = new Choice();
            choice.setBounds(170,70,120,20);
            choice.add("Availabil");
            choice.add("Occupied");
            panel.add(choice);

            table = new JTable();
            table.setBounds(0,187,700,210);
            table.setBackground(new Color(90,156,163));
            table.setForeground(Color.white);
            panel.add(table);

            try {
                conn c = new conn();
                String q = "Select *from Room";
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch (Exception e){
                e.printStackTrace();
            }


            JLabel Roomno = new JLabel(" Room Number");
            Roomno.setBounds(23,162,150,20);
            Roomno.setForeground(Color.white);
            Roomno.setFont(new Font("Tahoma",Font.BOLD,15));
            panel.add(Roomno);

            JLabel available= new JLabel("Availability");
            available.setBounds(175,162,150,20);
            available.setForeground(Color.white);
            available.setFont(new Font("Tahoma",Font.BOLD,15));
            panel.add(available);


            JLabel price= new JLabel(" Price");
            price.setBounds(352,162,150,20);
            price.setForeground(Color.white);
            price.setFont(new Font("Tahoma",Font.BOLD,15));
            panel.add( price);


            JLabel bed= new JLabel("Bed Type");
            bed.setBounds(490,162,150,20);
            bed.setForeground(Color.white);
            bed.setFont(new Font("Tahoma",Font.BOLD,15));
            panel.add(bed);


            JButton button = new JButton("Search");
            button.setBounds(200,420,120,25);
            button.setBackground(Color.black);
            button.setForeground(Color.white);
            panel.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String q = "select *from Room where  Avaliability = '"+choice.getSelectedItem()+"'";
                    try {

                        conn c = new conn();
                      //  String q = "select *from Room where Availabil = '"+choice.getSelectedItem()+"'";
                        ResultSet resultSet = c.statement.executeQuery(q);
//                      table.setModel(DbUtils.resultSetToTableModel(resultSet));
                        table.setModel(DbUtils.resultSetToTableModel(resultSet));

                    }catch (Exception E){
                        E.printStackTrace();
                    }
                }
            });



            JButton button1 = new JButton("Back");
            button1.setBounds(380,420,120,25);
            button1.setBackground(Color.black);
            button1.setForeground(Color.white);
            panel.add(button1);
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });



            setSize(700,500);
            setLayout(null);
            setLocation(450,250);
            setVisible(true);
        }

    public static void main(String[] args) {
        new searchRoom();
    }
}
