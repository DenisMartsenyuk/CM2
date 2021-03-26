import auxiliary.Checkable;
import auxiliary.RootsChecker;
import drawing.Painter;
import equation.Equation;
import equation.EquationFirst;
import equation.EquationSecond;
import equation.EquationThird;
import exceptions.SolutionException;
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
        equations.add(new EquationThird());

        List<Solution> solutions = new ArrayList<>();
        solutions.add(new HalfDivisionSolution());
        solutions.add(new SecantSolution());
        solutions.add(new SimpleIterationSolution());

        Checkable rootsChecker = new RootsChecker();

        Painter painter = new Painter();

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Доступные уравнения: ");
            for (int i = 0; i < equations.size(); ++i) {
                System.out.println(i + 1 + ": " + equations.get(i).getName());
            }

            System.out.println("Введите номер нужного уравнения:");
            int equationsIndex = scanner.nextInt() - 1;
            if (equationsIndex < 0 || equationsIndex >= equations.size()) {
                System.out.println("Неверно введен номер уравнения.");
                return;
            }

            painter.drawEquation(equations.get(equationsIndex));

            System.out.println("Доступные методы поиска корня: ");
            for (int i = 0; i < solutions.size(); ++i) {
                System.out.println(i + 1 + ": " + solutions.get(i).getName());
            }

            System.out.println("Введите номер нужного метода поиска:");
            int solutionIndex = scanner.nextInt() - 1;
            if (solutionIndex < 0 || solutionIndex >= solutions.size()) {
                System.out.println("Неверно введен номер метода.");
                return;
            }

            System.out.println("ОБРАТИТЕ ВНИМАНИЕ! ВСЕ ДРОБНЫЕ ЧИСЛА ВВОДЯТСЯ ЧЕРЕЗ ЗАПЯТУЮ!");
            System.out.println("Введите a:");
            double a = scanner.nextDouble();

            System.out.println("Введите b:");
            double b = scanner.nextDouble();

            System.out.println("Введите точность из промежутка (0, 1):");
            double accuracy = scanner.nextDouble();
            if (accuracy >= 1 || accuracy <= 0) {
                System.out.println("Некорректное значение точности.");
                return;
            }

            if (!rootsChecker.check(equations.get(equationsIndex), a, b)) {
                System.out.println("Корней в этом промежутке нет или их несколько.");
                return;
            }

            double x = solutions.get(solutionIndex).findRootEquation(equations.get(equationsIndex), a, b, accuracy);
            System.out.println("x = " + x);
        } catch (SolutionException e) {
            System.out.println(e.getMessage());
        } catch (Exception e1) {
            System.out.println("Произошел сбой при чтении данных.");
        }

    }
}
