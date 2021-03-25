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
        double currentX;
        do {
            currentX = previousX + lambda * equation.calcValue(previousX);
            previousX = currentX;
        } while (Math.abs(currentX - previousX) > accuracy);
        System.out.println(currentX); //todo вывод
        return 0;
    }
}
