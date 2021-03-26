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
    public void findRootEquation(Equation equation, double a, double b, double accuracy) { //todo не всегда робит
        System.out.printf("%11s", "№ шага");
        System.out.printf("%11s", "x(k)");
        System.out.printf("%11s", "f(x(k))");
        System.out.printf("%11s", "x(k+1)");
        System.out.printf("%11s", "fi(x(k))");
        System.out.printf("%14s %n", "|x(k)-x(k+1)|");
        double lambda = -1 / Math.max(equation.calcDerivativeFirstValue(a), equation.calcDerivativeFirstValue(b));
        double previousX = findX0(equation, a, b);
        double infelicity = accuracy + 0.1;
        int step = 1;
        while (infelicity > accuracy) {
            System.out.printf("%11d", step);
            System.out.printf("%11.3f", previousX);
            System.out.printf("%11.3f", equation.calcValue(previousX));
            double currentX = previousX + lambda * equation.calcValue(previousX);
            System.out.printf("%11.3f", currentX);
            System.out.printf("%11.3f", previousX);
            infelicity = Math.abs(currentX - previousX);
            System.out.printf("%11.3f %n", equation.calcValue(infelicity));
            previousX = currentX;
            step++;
        }
        System.out.println(previousX);
    }
}
