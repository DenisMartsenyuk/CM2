package solutions;

import equation.Equation;
import exceptions.SolutionException;

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
    public double findRootEquation(Equation equation, double a, double b, double accuracy) throws SolutionException {
        double lambda = -1 / Math.max(equation.calcDerivativeFirstValue(a), equation.calcDerivativeFirstValue(b));
        double q = Math.max(Math.abs(1 + lambda * equation.calcDerivativeFirstValue(a)), Math.abs(1 + lambda * equation.calcDerivativeFirstValue(b)));
        if (q >= 1) {
            throw new SolutionException("Условие сходимости не выполнено. Выберите другой промежуток.");
        }
        double previousX = findX0(equation, a, b);
        double currentX = previousX;
        do {
            previousX = currentX;
            currentX = previousX + lambda * equation.calcValue(previousX);
            if (previousX > b || previousX < a) {
                throw new SolutionException("Выберите более узкий промежуток.");
            }
        } while (Math.abs(currentX - previousX) > accuracy);
        return previousX;
    }
}
