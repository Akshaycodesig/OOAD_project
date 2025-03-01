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
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{
    
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    
    Transactions(String pin){
        
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg4.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(-40, -50, 1500, 900);
        add(l2);
        
        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
       
        b1 = new JButton("DEPOSIT");
        
   
        b2 = new JButton("CASH WITHDRAWL");
        b2.setSize(1000, 1000);
        b3 = new JButton("FAST CASH");
        b3.setSize(1000, 1000);
        b4 = new JButton("MINI STATEMENT");
        b4.setSize(1000, 1000);
        b5 = new JButton("PIN CHANGE");
        b5.setSize(1000, 1000);
        b6 = new JButton("BALANCE ENQUIRY");
        b6.setSize(1000, 1000);
        b7 = new JButton("EXIT");
        b7.setSize(1000, 600);
        b7.setForeground(Color.red);
        
        setLayout(null);
         
        l1.setBounds(635,200,700,35);
        l2.add(l1);
        
        b1.setBounds(110,200,200,100);
        l2.add(b1);
        
        b2.setBounds(1190,200,200,100);
        l2.add(b2);
        
        b3.setBounds(110,400,200,100);
        l2.add(b3);
        
        b4.setBounds(1190,400,200,100);
        l2.add(b4);
        
        b5.setBounds(110,600,200,100);
        l2.add(b5);
        
        b6.setBounds(1190,600,200,100);
        l2.add(b6);
        
        b7.setBounds(640,750,200,80);
        l2.add(b7);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        
        setSize(1500,900);
        setLocation(270,100);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b7)
        {
            System.exit(0);
        }
        else if (ae.getSource() == b1)
        {
            setVisible(false);
            new Deposit(pin).setVisible(true); 
        }
        else if (ae.getSource() == b2)
        {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }
        else if (ae.getSource() == b3)
        {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }
        else if (ae.getSource() == b5)
        {
            setVisible(false);
            new Pin(pin).setVisible(true);
        }
        else if (ae.getSource() == b6)
        {
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else if (ae.getSource() == b4)
        {
            new MiniStatement(pin).setVisible(true);
        }
        
    }
    
    public static void main(String[] args){
        new Transactions("").setVisible(true);;
    }
}
