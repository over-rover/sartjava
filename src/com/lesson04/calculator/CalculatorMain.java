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
        Scanner sc = new Scanner(System.in);
        Scanner scExpr = new Scanner(System.in);
        int expressionMaxNumber = 6; // максимальное количество хранимых итераций

        /*Объявляем массив объектов.
        * Каждый объект будет содержать набор исходных данных и результат вычислений.*/
        Calculator[] myCalcs = new Calculator[expressionMaxNumber];

        String choice;
        int i = 0;
        do {
            System.out.println("Введите выражение вида: a + b Допускаются операции +, -, *, /, ^, %");
            myCalcs[i] = new Calculator();
            myCalcs[i].setData(scExpr.nextLine()); // Вводим с консоли и отдаем в метод - сетер.
            /* примечание к строке выше
            Пришлось создавать и использовать scExpr, так как обойтись только лишь sc не получилось.
            Если передавать sc.nextLine(), то на второй интерации не дает ввести выражение, а сразу
            передает в метод строку "y" - решение пользователя о желании продолжить.
            myCalcs[i].setData(sc.nextLine()) - ввели выражение, посчитали результат.
            далее choice = sc.next() - ввели "у" - хотим продолжить вычисления.
            далее myCalcs[i].setData(sc.nextLine()) - не ждет ввода с консоли, а передает "у" в метод
            Поясни, пожалуйста.
            */

            myCalcs[i].calculate(); // сохраняет результат в переменную и выводит на экран

            System.out.println("Хотите продолжить? [y/n]: ");
            choice = sc.next();

            while (!choice.equals("y") && !choice.equals("n")) {
                System.out.println("!!!Ошибка при вводе!!! Попробуйте еще раз [y/n]: ");
                choice = sc.next();
            }
            if (i == expressionMaxNumber - 1) {
                i = 0;
            } else {
                i++;
            }
        } while (choice.equals("y"));

        // Отрабатываю переопределение toString и использование for each
        System.out.println("История ваших операций (" + expressionMaxNumber + " последних:");
        for (Calculator var : myCalcs) {
            System.out.println(var);
        }
        System.out.println("Программа окончена.");
    }
}

