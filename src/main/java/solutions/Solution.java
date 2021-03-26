package solutions;

import equation.Equation;
import exceptions.SolutionException;

public interface Solution {
    String getName();
    double findRootEquation(Equation equation, double a, double b, double accuracy) throws SolutionException;
}
