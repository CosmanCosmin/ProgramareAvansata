package Panels;

import Base.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ShapePanel extends Panel {
    final MainFrame frame;
    JButton freeButton = new JButton("Free");
    JButton diamondButton = new JButton("Diamond");
    JButton circleButton = new JButton("Circle");
    JButton deleteButton = new JButton("Delete");
    public ShapePanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init(){
        setLayout(new GridLayout(4, 1));
        add(freeButton);
        add(diamondButton);
        add(circleButton);
        add(deleteButton);
        freeButton.addActionListener(this::free);
        diamondButton.addActionListener(this::diamond);
        circleButton.addActionListener(this::circle);
        deleteButton.addActionListener(this::delete);
        deleteButton.setBackground(Color.RED);
    }
    private void free(ActionEvent e){}
    private void diamond(ActionEvent e){
        if(frame.delete){
            frame.delete = false;
        }
        frame.configPanel.sides.setValue(4);
    }
    private void circle(ActionEvent e){
        if(frame.delete){
            frame.delete = false;
        }
        frame.configPanel.sides.setValue(100);
    }
    private void delete(ActionEvent e){
        frame.delete = !frame.delete;
        if (deleteButton.getBackground().equals(Color.RED)){
            deleteButton.setBackground(Color.GREEN);
        }
        else{
            deleteButton.setBackground(Color.RED);
        }
    }
}
