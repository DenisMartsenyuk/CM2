package drawing;

import equation.Equation;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Graph extends JPanel {
    private static final int WIDTH = 420;
    private static final int HEIGHT = 420;
    private static final int INDENT = 10;
    private static final int SERIFS_INDENT = 40; //=1 => 40px = 1 1px = 0,025 1px = 0.125 1/8

    private Equation equation;
    
    Graph(Equation equation) {
        this.equation = equation;
        setSize(WIDTH, HEIGHT);
        setBackground(new Color(255, 255, 255));
    }

    private void drawFunction(Graphics2D g2d) {
        g2d.setPaint(Color.green);
        double x = -4.0;
        int previousY = HEIGHT / 2 - (int) Math.floor(equation.calcValue(x) * 40);
        Point2D previousPoint = new Point2D.Double(INDENT + SERIFS_INDENT, previousY);
        for (int i = INDENT + SERIFS_INDENT + 1; i <= WIDTH - INDENT - SERIFS_INDENT; ++i) {
            x += 0.025;
            int currentY = HEIGHT / 2 -  (int) Math.floor(equation.calcValue(x) * 40);
            Point2D currentPoint = new Point2D.Double(i, currentY);
            Line2D line = new Line2D.Double(previousPoint, currentPoint);
            g2d.draw(line);
            previousPoint = currentPoint;
        }
    }

    private void drawSerifs(Graphics2D g2d) {
        g2d.setPaint(Color.black);
        for (int i = INDENT + SERIFS_INDENT; i < WIDTH - INDENT; i += SERIFS_INDENT) {
            Point2D serifStart = new Point2D.Double(i, HEIGHT / 2 - 5);
            Point2D serifEnd = new Point2D.Double(i, HEIGHT / 2 + 5);
            Line2D serif = new Line2D.Double(serifStart, serifEnd);
            g2d.draw(serif);
        }

        for (int i = INDENT + SERIFS_INDENT; i < HEIGHT - INDENT; i += SERIFS_INDENT) {
            Point2D serifStart = new Point2D.Double(WIDTH / 2 - 5, i);
            Point2D serifEnd = new Point2D.Double(WIDTH / 2 + 5, i);
            Line2D serif = new Line2D.Double(serifStart, serifEnd);
            g2d.draw(serif);
        }
    }

    private void drawLines(Graphics2D g2d) {
        g2d.setPaint(Color.black);
        Point2D xStart = new Point2D.Double(INDENT, HEIGHT / 2);
        Point2D xEnd = new Point2D.Double(WIDTH - INDENT, HEIGHT / 2);
        Line2D lineX = new Line2D.Double(xStart, xEnd);
        g2d.draw(lineX);
        g2d.drawString("x", (float) WIDTH - INDENT * 3,(float)(HEIGHT / 2 + INDENT));

        Point2D yStart = new Point2D.Double(WIDTH / 2, INDENT);
        Point2D yEnd = new Point2D.Double(WIDTH / 2, HEIGHT - INDENT);
        Line2D lineY = new Line2D.Double(yStart, yEnd);
        g2d.draw(lineY);
        g2d.drawString("y", (float) (WIDTH / 2 + INDENT),(float)(INDENT * 3));
    }

    private void drawAxes(Graphics2D g2d) {
        drawLines(g2d);
        drawSerifs(g2d);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawAxes(g2d);
        drawFunction(g2d);
    }
}
