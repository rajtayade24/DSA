package com.java.dsa.college;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exp6Frame extends JFrame implements ActionListener {

    JTextField t1, t2, t3;

    Exp6Frame() {
        setTitle("Previous and Next Number");
        setSize(400, 200);
        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel l1 = new JLabel("Enter Number:");
        JLabel l2 = new JLabel("Previous Number:");
        JLabel l3 = new JLabel("Next Number:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        t2.setEditable(false);
        t3.setEditable(false);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);

        t1.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num = Integer.parseInt(t1.getText());

            t2.setText(String.valueOf(num - 1));
            t3.setText(String.valueOf(num + 1));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this, "Please enter a valid integer."
            );
        }
    }

    public static void main(String[] args) {
        new Exp6Frame();
    }
}