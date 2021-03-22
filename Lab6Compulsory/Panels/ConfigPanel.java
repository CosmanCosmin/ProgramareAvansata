package Panels;

import Base.MainFrame;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sides;
    JLabel sizeLabel;
    JSpinner size;
    JComboBox<String> colors;
    private void init(){
        sidesLabel = new JLabel("Number of sides:");
        sides = new JSpinner(new SpinnerNumberModel(6, 0, 100, 1));
        sizeLabel = new JLabel("Size:");
        size = new JSpinner(new SpinnerNumberModel(10, 10, 200,1));
        colors = new JComboBox<>(new String[]{"Black", "Random"});
        add(sizeLabel);
        add(size);
        add(sidesLabel);
        add(sides);
        add(colors);
    }
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
}
