package equation;

public class EquationThird implements Equation {
    @Override
    public String getName() {
        return "2x^3+5x^2-10";
    }

    @Override
    public double calcDerivativeFirstValue(double x) {
        return 6 * x * x + 10 * x;
    }

    @Override
    public double calcDerivativeSecondValue(double x) {
        return 12 * x + 10;
    }

    @Override
    public double calcValue(double x) {
        return 2 * x * x * x +5 * x * x- 10;
    }
}
