package Base;

import Panels.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public ConfigPanel configPanel;
    public ControlPanel controlPanel;
    public DrawingPanel canvas;
    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        add(canvas, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        pack();
    }
    public MainFrame(){
        super("My Drawing Application");
        init();
    }
}
