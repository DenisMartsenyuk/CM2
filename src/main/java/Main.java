import auxiliary.Checkable;
import auxiliary.RootChecker;
import auxiliary.SingleRootChecker;
import equation.Equation;
import equation.EquationFirst;
import equation.EquationSecond;
import solutions.HalfDivisionSolution;
import solutions.SecantSolution;
import solutions.SimpleIterationSolution;
import solutions.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Equation> equations = new ArrayList<>();
        equations.add(new EquationFirst());
        equations.add(new EquationSecond());

        List<Solution> solutions = new ArrayList<>();
        solutions.add(new HalfDivisionSolution());
        solutions.add(new SecantSolution());
        solutions.add(new SimpleIterationSolution());

        Checkable rootChecker = new RootChecker();
        Checkable singleRootChecker = new SingleRootChecker();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Доступные уравнения: "); //todo мб переназвать
        for (int i = 0; i < equations.size(); ++i) {
            System.out.println(i + 1 + ": " + equations.get(i).getName());
        }

        System.out.println("Введите номер нужного уравнения:");
        int equationsIndex = scanner.nextInt() - 1;
        //todo нарисовать

        System.out.println("Доступные методы поиска корня: "); //todo мб переназвать
        for (int i = 0; i < solutions.size(); ++i) {
            System.out.println(i + 1 + ": " + solutions.get(i).getName());
        }

        System.out.println("Введите номер нужного метода поиска:");
        int solutionIndex = scanner.nextInt() - 1;

        System.out.println("ОБРАТИТЕ ВНИМАНИЕ! ВСЕ ДРОБНЫЕ ЧИСЛА ВВОДЯТСЯ ЧЕРЕЗ ЗАПЯТУЮ!"); //todo мб перенести это
        System.out.println("Введите a:");
        double a = scanner.nextDouble();

        System.out.println("Введите b:");
        double b = scanner.nextDouble();

        System.out.println("Введите точность из промежутка (0, 1):");
        double accuracy = scanner.nextDouble();

        if (!rootChecker.check(equations.get(equationsIndex), a, b)) {
            System.out.println("Корней в этом промежутке нет.");
            return;
        }
        if (!singleRootChecker.check(equations.get(equationsIndex), a, b)) {
            System.out.println("Корней в этом промежутке несколько.");
            return;
        }
        solutions.get(solutionIndex).findRootEquation(equations.get(equationsIndex), a, b, accuracy);
    }
}
