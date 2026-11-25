package com.java.dsa.college;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Exp4MouseEvents extends Frame implements MouseListener, MouseMotionListener {
    Label label;

    Exp4MouseEvents() {
        label = new Label("Perform mouse action");
        label.setBounds(100, 100, 250, 30);

        add(label);

        addMouseListener(this);
        addMouseMotionListener(this);

        setSize(500, 400);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        label.setText("Mouse Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setText("Mouse Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        label.setText("Mouse Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setText("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setText("Mouse Exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        label.setText("Mouse Dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        label.setText("Mouse Moved");
    }

    public static void main(String[] args) {
        new Exp4MouseEvents();
    }
}