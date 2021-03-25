package solutions;

import equation.Equation;

public class SecantSolution implements Solution{
    @Override
    public String getName() {
        return "Метод секущих.";
    }

    @Override
    public double findRootEquation(Equation equation, double a, double b, double accuracy) {
        return 0;
    }
}
