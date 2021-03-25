package solutions;

import equation.Equation;

public class SimpleIterationSolution implements Solution{
    @Override
    public String getName() {
        return "Метод простой итерации.";
    }

    @Override
    public double findRootEquation(Equation equation, double a, double b, double accuracy) {
        return 0;
    }
}
