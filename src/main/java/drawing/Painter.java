package drawing;

import equation.Equation;

import javax.swing.*;
import java.awt.*;

public class Painter {

    public void drawEquation(Equation equation) {
        JFrame window = new JFrame("Function graph");
        Graph graph = new Graph(equation);
        window.setPreferredSize(new Dimension(graph.getWidth(), graph.getHeight()));
        window.getContentPane().add(graph);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }


}
