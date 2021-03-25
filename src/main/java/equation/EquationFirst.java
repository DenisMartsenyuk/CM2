package equation;

public class EquationFirst implements Equation {
    @Override
    public String getName() {
        return "2,3x^3+5,75x^2−7,41x−10,6";
    }

    @Override
    public double calcDerivativeValue(double x) {
        return 6.9 * x * x + 11.5 * x - 7.41;
    }

    @Override
    public double calcValue(double x) {
        return 2.3 * x * x * x + 5.75 * x * x - 7.41 * x - 10.6;
    }
}
