package com.java.dsa.college;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Exp5AWT extends Frame  {

    public Exp5AWT() {
        setTitle("All the best- Five colors");
        setSize(400, 500);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 24));

        g.setColor(Color.RED);
        g.drawString("All The Best", 100, 100);

        g.setColor(Color.BLUE);
        g.drawString("All The Best", 100, 100);

        g.setColor(Color.GREEN);
        g.drawString("All The Best", 100, 100);

        g.setColor(Color.ORANGE);
        g.drawString("All The Best", 100, 100);

        g.setColor(Color.MAGENTA);
        g.drawString("All The Best", 100, 100);
    }

    public static void main(String[] args) {
        new Exp5AWT();
    }
}