package solutions;

import equation.Equation;

public class SimpleIterationSolution implements Solution {
    @Override
    public String getName() {
        return "Метод простой итерации.";
    }

    @Override
    public double findRootEquation(Equation equation, double a, double b, double accuracy) {
        double lambda = -1 / Math.max(equation.calcDerivativeFirstValue(a), equation.calcDerivativeFirstValue(b));
        double previousX = a;
        double infelicity = accuracy + 1.0;
        while (infelicity > accuracy) {
            double currentX = previousX + lambda * equation.calcValue(previousX);
            infelicity = Math.abs(currentX - previousX);
            previousX = currentX;
        }
        System.out.println(previousX); //todo вывод
        return 0;
    }
}
