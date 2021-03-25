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
    public void findRootEquation(Equation equation, double a, double b, double accuracy) {
        System.out.printf("%11s", "№ шага");
        System.out.printf("%11s", "x(k-1)");
        System.out.printf("%11s", "f(x(k-1))");
        System.out.printf("%11s", "x(k)");
        System.out.printf("%11s", "f(x(k))");
        System.out.printf("%11s", "x(k+1)");
        System.out.printf("%11s", "f(x(k+1))");
        System.out.printf("%14s %n", "|x(k)-x(k+1)|");
        double prePreviousX = findX0(equation, a, b);
        double previousX = prePreviousX - equation.calcValue(prePreviousX) / equation.calcDerivativeFirstValue(prePreviousX);
        int step = 1;
        while (Math.abs(previousX - prePreviousX) > accuracy) {
            System.out.printf("%11d", step);
            System.out.printf("%11.3f", prePreviousX);
            System.out.printf("%11.3f", equation.calcValue(prePreviousX));
            System.out.printf("%11.3f", previousX);
            System.out.printf("%11.3f", equation.calcValue(previousX));
            double currentX = previousX - (previousX - prePreviousX) * equation.calcValue(previousX) / (equation.calcValue(previousX) - equation.calcValue(prePreviousX));
            System.out.printf("%11.3f", currentX);
            System.out.printf("%11.3f", equation.calcValue(currentX));
            System.out.printf("%14.3f %n", Math.abs(currentX - previousX));
            prePreviousX = previousX;
            previousX = currentX;
            step++;
        }
        System.out.println("x = " + previousX);
    }
}
