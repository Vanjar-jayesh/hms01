
package hospital.managemet.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Queue;

public class login extends JFrame  implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1,b2;

    login(){
                JLabel namelable = new JLabel("username");
                namelable.setBounds(40,20,100,30);
                namelable.setFont(new Font("Tahome",Font.BOLD,16));
                namelable.setForeground(Color.MAGENTA);
                add(namelable);

                JLabel password = new JLabel("password ");
                password .setBounds(40,70,100,30);
                password .setFont(new Font("Tahome",Font.BOLD,16));
                password .setForeground(Color.MAGENTA);
                add(password );

                textField = new JTextField();
                textField.setBounds(150,20,150,30);
                textField.setFont(new Font("Tahoma",Font.PLAIN,15));
                textField.setBackground(new Color(255,179,0));
                add(textField);

                jPasswordField = new JPasswordField();
                jPasswordField.setBounds(150,70,150,30);
                jPasswordField.setFont(new Font("Tahoma",Font.PLAIN,15));
                jPasswordField.setBackground(new Color(255, 221, 0));
                add(jPasswordField);

//                    ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("hospital/icon/login.png"));
//                    Image i1 = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
//                    ImageIcon imageIcon1 = new ImageIcon(i1);
//                    JLabel label = new JLabel(imageIcon1);
//                    label.setBounds(250,30,300,250);
//                    add(label);

                b1 = new JButton("login");
                b1.setBounds(40,140,120,30);
                b1.setFont(new Font("serif",Font.BOLD,15));
                b1.setBackground(Color.black);
                b1.setForeground(Color.white);
                b1.addActionListener(this);
                add(b1);

                b2 = new JButton("Cancel");
                b2.setBounds(180,140,120,30);
                b2.setFont(new Font("serif",Font.BOLD,15));
                b2.setBackground(Color.black);
                b2.setForeground(Color.white);
                b2.addActionListener(this);
                add(b2);
       //  setUndecorated(true);
        getContentPane().setBackground(new Color(0, 174, 255));
        setSize(850,550);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);


    }


    public static void main(String[] args) {
        new login();
    }
@Override
public void actionPerformed(ActionEvent e) {

    if (e.getSource() == b1) {
        try {
            conn c = new conn();
            String user = textField.getText();
            String pass = jPasswordField.getText();

            String q = "select * from login where ID = '" + user + "' and Pw = '" + pass + "' ";
            ResultSet resultSet = c.statement.executeQuery(q);

            if (resultSet.next()) {
                new Reception();
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "invalid");

            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    } else {
        System.exit(10);
    }
}

}
