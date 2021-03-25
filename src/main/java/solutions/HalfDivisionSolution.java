package solutions;

import auxiliary.Checkable;
import auxiliary.RootChecker;
import equation.Equation;

public class HalfDivisionSolution implements Solution{
    @Override
    public String getName() {
        return "Метод половинного деления.";
    }

    @Override
    public void findRootEquation(Equation equation, double a, double b, double accuracy) { //todo чет с выводом не так
        System.out.printf("%10s", "№ шага");
        System.out.printf("%10s", "a");
        System.out.printf("%10s", "b");
        System.out.printf("%10s", "x");
        System.out.printf("%10s", "f(a)");
        System.out.printf("%10s", "f(b)");
        System.out.printf("%10s", "f(x)");
        System.out.printf("%10s %n", "|a-b|");
        double currentA = a;
        double currentB = b;
        Checkable rootChecker = new RootChecker();
        int step = 1;
        while (Math.abs(currentB - currentA) > accuracy) {
            System.out.printf("%10d", step);
            System.out.printf("%10.3f", currentA);
            System.out.printf("%10.3f", currentB);
            double currentX = (currentA + currentB) / 2;
            System.out.printf("%10.3f", currentX);
            System.out.printf("%10.3f", equation.calcValue(currentA));
            System.out.printf("%10.3f", equation.calcValue(currentB));
            System.out.printf("%10.3f", equation.calcValue(currentX));
            System.out.printf("%10.3f %n", Math.abs(currentB - currentA));
            if (rootChecker.check(equation, currentA, currentX)) {
                currentB = currentX;
            } else {
                currentA = currentX;
            }
            step++;
        }
        System.out.printf("%10d", step);
        System.out.printf("%10.3f", currentA);
        System.out.printf("%10.3f", currentB);
        System.out.printf("%10.3f", (currentA + currentB) / 2);
        System.out.printf("%10.3f", equation.calcValue(currentA));
        System.out.printf("%10.3f", equation.calcValue(currentB));
        System.out.printf("%10.3f", equation.calcValue((currentA + currentB) / 2));
        System.out.printf("%10.3f %n", Math.abs(currentB - currentA));
        System.out.println("x = " + (currentA + currentB) / 2);
    }
}
