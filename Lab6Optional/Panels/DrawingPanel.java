package Panels;

import Base.MainFrame;
import Shapes.RegularPolygon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    public BufferedImage image;
    public Graphics2D graphics;
    public List<Shape> shapes;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
        shapes = new ArrayList<>();
    }
    private void createOffscreenImage(){
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0, W, H);
    }
    private void init(){
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                if(!frame.delete) {
                    drawShape(e.getX(), e.getY());
                }
                else {
                    graphics.setColor(Color.WHITE);
                    for (int index = shapes.size() - 1; index >= 0; index--){
                        if (shapes.get(index).contains(e.getX(), e.getY())) {
                            graphics.fill(shapes.get(index));
                            shapes.remove(index);
                            break;
                        }
                    }
                    redrawShapes();
                }
                repaint();
            }
        });
    }
    private void redrawShapes(){
        for (Shape shape : shapes) {
            RegularPolygon regularPolygon = (RegularPolygon) shape;
            graphics.setColor(regularPolygon.getColor());
            graphics.fill(regularPolygon);
        }
    }
    private void drawShape(int x, int y){
        Random random = new Random();
        int radius = (int) frame.configPanel.size.getValue();
        int sides = (int) frame.configPanel.sides.getValue();
        if (frame.configPanel.colors.getSelectedItem().equals("Black")){
            graphics.setColor(Color.BLACK);
        }
        else {
            Color color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
            graphics.setColor(color);
        }
        RegularPolygon regularPolygon = new RegularPolygon(x, y, radius, sides, graphics.getColor());
        shapes.add(regularPolygon);
        graphics.fill(regularPolygon);
    }
    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, this);
    }
}