package auxiliary;

import equation.Equation;

public class RootChecker implements Checkable{
    @Override
    public boolean check(Equation equation, double a, double b) {
        return equation.calcValue(a) * equation.calcValue(b) < 0; //todo чет не то
    }
}
