package solutions;

import equation.Equation;

public class SecantSolution implements Solution{

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
        return "Метод секущих.";
    }

    @Override
    public double findRootEquation(Equation equation, double a, double b, double accuracy) {
        double prePreviousX = findX0(equation, a, b);
        double previousX = prePreviousX - equation.calcValue(prePreviousX) / equation.calcDerivativeFirstValue(prePreviousX);
        while (Math.abs(previousX - prePreviousX) > accuracy) {
            double currentX = previousX - (previousX - prePreviousX) * equation.calcValue(previousX) / (equation.calcValue(previousX) - equation.calcValue(prePreviousX));
            prePreviousX = previousX;
            previousX = currentX;
        }
        System.out.println(previousX); //todo вывод
        return 0;
    }
}
