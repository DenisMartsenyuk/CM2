package solutions;

import equation.Equation;

public interface Solution {
    String getName();
    void findRootEquation(Equation equation, double a, double b, double accuracy);
}
