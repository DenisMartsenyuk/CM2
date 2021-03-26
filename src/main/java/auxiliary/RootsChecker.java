package auxiliary;

import equation.Equation;

public class RootsChecker implements Checkable{
    @Override
    public boolean check(Equation equation, double a, double b) {
        Checkable signChecker = new SignChecker();
        int counter = 0;
        for (double i = a + 0.1; i <= b; i += 0.1) {
            if (signChecker.check(equation, i - 0.1, i)) {
                counter++;
            }
        }
        return counter == 1;
    }
}
