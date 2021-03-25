package equation;

public interface Equation {
    String getName();
    double calcDerivativeFirstValue(double x);
    double calcDerivativeSecondValue(double x);
    double calcValue(double x);
}
