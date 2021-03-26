package solutions;

import equation.Equation;

public interface Solution {
    String getName();
    double findRootEquation(Equation equation, double a, double b, double accuracy);
}
