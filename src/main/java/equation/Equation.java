package equation;

public interface Equation {
    String getName();
    double calcDerivativeValue(double x);
    double calcValue(double x);
}
