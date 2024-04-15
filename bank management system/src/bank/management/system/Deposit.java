/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

/**
 *
 * @author akshay
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;
     
     Deposit(String pin)
     {   
        this.pin = pin;
        
        setLayout(null);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg4.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(-40, -50, 1500, 900);
        add(l3);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(550,350,400,35);
        l3.add(l1);
        
        t1.setBounds(550,420,320,25);
        l3.add(t1);
        
        b1.setBounds(650,488,150,35);
        l3.add(b1);
        
        b2.setBounds(650,533,150,35);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
       
        
        setSize(1500,900);
        setLocation(270,100);
        setVisible(true);

     }
     
    
    public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==b1){
                String amount = t1.getText();
                Date date = new Date();
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }
                else{
                    try{
                        Conn c1 = new Conn();
                        String query = "insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')";
                        c1.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    
                }
            }
          else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
    }
    public static void main(String args[])
    {
        new Deposit("");
    }
}
