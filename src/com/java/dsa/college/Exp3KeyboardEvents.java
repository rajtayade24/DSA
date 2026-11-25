package com.java.dsa.college;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Exp3KeyboardEvents extends Frame implements KeyListener {

    Label label;

    Exp3KeyboardEvents() {
        label = new Label("Press any key...");
        label.setBounds(100, 100, 250, 30);

        add(label);
        addKeyListener(this);

        setSize(500, 400);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        label.setText("Key Typed: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        label.setText("Key Pressed: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        label.setText("Key Released: " + e.getKeyChar());
    }

    public static void main(String[] args) {
        new Exp3KeyboardEvents();
    }
}