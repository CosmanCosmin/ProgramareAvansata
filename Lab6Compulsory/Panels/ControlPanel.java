package Panels;

import Base.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveButton = new JButton("Save");
    JButton loadButton = new JButton("Load");
    JButton resetButton = new JButton("Reset");
    JButton exitButton = new JButton("Exit");
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init(){
        setLayout(new GridLayout(1, 4));
        add(saveButton);
        add(loadButton);
        add(resetButton);
        add(exitButton);
        saveButton.addActionListener(this::save);
        loadButton.addActionListener(this::load);
        resetButton.addActionListener(this::reset);
        exitButton.addActionListener(this::exit);
    }
    private void save(ActionEvent e){
        JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int result = jFileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(frame.canvas.image, "PNG", jFileChooser.getSelectedFile());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    private void load(ActionEvent e){
        //todo fix : can't draw after loading an image
        JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int result = jFileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            try {
                frame.canvas.image = ImageIO.read(jFileChooser.getSelectedFile());
                frame.canvas.updateUI();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
    private void reset(ActionEvent e){
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0,0, frame.getWidth(), frame.getHeight());
        frame.canvas.updateUI();
    }
    private void exit(ActionEvent e){
        System.exit(0);
    }
}
