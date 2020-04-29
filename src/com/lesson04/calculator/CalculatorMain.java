package com.lesson04.calculator;
/*TODO
Модифицируйте Калькулятор, используя для хранения значений математического выражения массивы:
воспользуйтесь методами класса Math, какие только сможете найти, заменив ими ваши реализации,
связанные с вычислениями.
Ввод выражения осуществляется с консоли односй строкой, таким образом: 2 ^ 10
для разбиения математического выражения на составляющие и сохранения их в массив, используйте
метод String.split();
Для преобразования аргументов математического выражения из типа String в int используйте метод
Integer.parseInt
 */
import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        int expressionMaxNumber = 5; // величина массива для хранения результатов матем. операций
        Calculator myCalc = new Calculator(expressionMaxNumber);
        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Введите выражение вида: a + b Допускаются операции +, -, *, /, ^, %");
            myCalc.setExpression(sc.nextLine());
            myCalc.calculate(); // вычисляем результат, записываем его в массив

            System.out.println("Хотите продолжить? [да/нет]: ");
            choice = sc.nextLine();

            while (!choice.equals("да") && !choice.equals("нет")) {
                System.out.println("!!!Ошибка при вводе!!! Попробуйте еще раз [да/нет]: ");
                choice = sc.nextLine();
            }
        } while (choice.equals("да"));

        System.out.println("Значения математических выражений:");
        for (int i = 0; i < expressionMaxNumber; i++) {
            System.out.print(myCalc.getResult(i) + " ");
        }
        System.out.println("\nПрограмма окончена.");
    }
}