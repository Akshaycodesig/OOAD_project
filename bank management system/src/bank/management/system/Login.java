
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;


public class Login extends JFrame implements ActionListener{
 
    JButton b1,b2,b3;
    JLabel text,cardno,pin;
    JTextField tf1;
    JPasswordField pf2;
    
    
    
    Login()
    {
    
        setTitle("Bank");
        
        setLayout(null);
        
        

        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,800,480);
        
        add(layeredPane);
        
        
        
        ImageIcon image = new ImageIcon(getClass().getResource("bg2.jpeg"));
        Image originalImage = image.getImage();
        Image resizedImage = originalImage.getScaledInstance(800, 480, Image.SCALE_SMOOTH); // Adjust the width and height as needed
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel displayField = new JLabel(resizedIcon);
        displayField.setBounds(0,0,800,480);
        add(displayField);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(170,10,100,100);
        add(label);
        
        
        text = new JLabel("Welcome to Bank");
        text.setBounds(300, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBorder(new EmptyBorder(10,12,15,12));
        text.setForeground(Color.white);
        add(text);
        
        cardno = new JLabel("Account No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(155,150,375,30);
        cardno.setForeground(Color.white);
        add(cardno);
        
        tf1 = new JTextField(15);
        tf1.setBounds(350,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);
        
        pin = new JLabel("Password:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(155,220,375,30);
        pin.setForeground(Color.white);
        add(pin);
        
        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(350,220,230,30);
        add(pf2);
        
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLACK);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.BLACK);
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.BLACK);
        
        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,300,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,300,100,30);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,350,230,30);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
     
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setVisible(true);
        setLocation(330,200);
        
        layeredPane.add(displayField,Integer.valueOf(0));
        layeredPane.add(label,Integer.valueOf(1));
        layeredPane.add(text,Integer.valueOf(1));
        layeredPane.add(cardno,Integer.valueOf(1));
        layeredPane.add(pin,Integer.valueOf(1));
        layeredPane.add(tf1,Integer.valueOf(1));
        layeredPane.add(pf2,Integer.valueOf(1));
        layeredPane.add(b1,Integer.valueOf(1));
        layeredPane.add(b2,Integer.valueOf(1));
        layeredPane.add(b3,Integer.valueOf(1));
        
        
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == b2)
        {
            tf1.setText("");
            pf2.setText("");
        }
        else if (ae.getSource() == b1)
        {
            Conn c1 = new Conn();
            String cardno  = tf1.getText();
            String pin  = pf2.getText();
            
            String query  = "select * from login where cardnumber = '"+cardno+"' and pin = '"+pin+"'";
            
            try{
                ResultSet rs = c1.s.executeQuery(query);
                if (rs.next())
                {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            

            
        }
        else if (ae.getSource() == b3)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new Login();
        
    }

}
 

