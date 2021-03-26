package solutions;

import equation.Equation;

public class SimpleIterationSolution implements Solution {

    private double findX0(Equation equation, double a, double b) {
        for (double i = a; i <= b; i += 0.01) {
            if (equation.calcValue(i) * equation.calcDerivativeSecondValue(i) > 0) {
                return i;
            }
        }
        return b;
    }

    @Override
    public String getName() {
        return "Метод простой итерации.";
    }

    @Override
    public double findRootEquation(Equation equation, double a, double b, double accuracy) { //todo не всегда робит
        double lambda = -1 / Math.max(equation.calcDerivativeFirstValue(a), equation.calcDerivativeFirstValue(b));
        double previousX = findX0(equation, a, b);
        double infelicity = accuracy + 0.1;
        while (infelicity > accuracy) {
            double currentX = previousX + lambda * equation.calcValue(previousX);
            infelicity = Math.abs(currentX - previousX);
            previousX = currentX;
        }
        return previousX;
    }
}
