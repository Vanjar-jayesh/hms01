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












        setSize(1000,600);
        setLocation(350,230);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
     new  Employee_info();
    }
}
