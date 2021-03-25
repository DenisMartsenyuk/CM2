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
    public double findRootEquation(Equation equation, double a, double b, double accuracy) {
        double currentA = a;
        double currentB = b;
        Checkable rootChecker = new RootChecker();
        while (Math.abs(currentB - currentA) > accuracy) {
            double currentX = (currentA + currentB) / 2;
            if (rootChecker.check(equation, currentA, currentX)) { //todo вывод всего этого дела
                currentB = currentX;
            } else {
                currentA = currentX;
            }
        }
        System.out.println((currentA + currentB) / 2);
        return 0;
    }
}
