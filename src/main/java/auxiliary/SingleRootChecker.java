package auxiliary;

import equation.Equation;

public class SingleRootChecker implements Checkable{
    @Override
    public boolean check(Equation equation, double a, double b) {
        return equation.calcDerivativeValue(a) * equation.calcDerivativeValue(b) > 0; //todo чет не то
    }
}
