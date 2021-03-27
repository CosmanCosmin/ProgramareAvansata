package Shapes;

import java.awt.*;

public class RegularPolygon extends Polygon {
    private int radius;
    private int sides;
    private Color color;
    public RegularPolygon(int x0, int y0, int radius, int sides, Color color){
        this.radius = radius;
        this.sides = sides;
        this.color = color;
        double alpha = 2 * Math.PI / sides;
        for (int i = 0; i < sides; i++){
            double x = x0 + radius * Math.cos(alpha * i);
            double y = y0 + radius * Math.sin(alpha * i);
            this.addPoint((int) x, (int) y);
        }
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public int getSides() {
        return sides;
    }
    public void setSides(int sides) {
        this.sides = sides;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}