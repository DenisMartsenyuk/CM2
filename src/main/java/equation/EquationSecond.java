package equation;

public class EquationSecond implements Equation{
    @Override
    public String getName() {
        return "sin(2x)";
    }

    @Override
    public double calcDerivativeFirstValue(double x) {
        return 2 * Math.cos(2 * x);
    }

    @Override
    public double calcDerivativeSecondValue(double x) {
        return -4 * Math.sin(2 * x);
    }

    @Override
    public double calcValue(double x) {
        return Math.sin(2 * x);
    }
}
