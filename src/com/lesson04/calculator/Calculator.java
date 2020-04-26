package com.lesson04.calculator;

public class Calculator {

    private int firstNumber;
    private int secondNumber;
    private char mathOperator;
    private String result;

    /*
    Обрабатываем строку - раскладываем ее на части и инициализиируем поля.
    Проверку на корректность ввода не осуществляем - не требуется в рамках данной задачи.
    */
    public void setData (String expression) {
        // Разбиваем строку по пробелам, сохраняем в виде массива из 3 элементов.
        String[] exprElements = expression.split(" ", 3);
        firstNumber = Integer.parseInt(exprElements[0]);
        mathOperator = exprElements[1].charAt(0);
        secondNumber = Integer.parseInt(exprElements[2]);
        }

    /*Результат вычислений может быть как целого типа, так и вещественного,
    * чтобы не плодить переменные, конвертируем результат к типу String*/
    public void calculate() {
        switch(mathOperator) {
            case '+':
                result = String.valueOf(Math.addExact(firstNumber, secondNumber));
                System.out.println("Сумма чисел a и b равна " + result);
                break;
            case '-':
                result = String.valueOf(Math.subtractExact(firstNumber, secondNumber));
                System.out.println("Разница чисел a и b равна " + result);
                break;
            case '*':
                result = String.valueOf(Math.multiplyExact(firstNumber, secondNumber));
                System.out.println("Произведение чисел a и b равно " + result);
                break;
            case '/':
                if (secondNumber != 0) {
                    result = String.valueOf((double) firstNumber / secondNumber);
                    System.out.println("Частное чисел a и b равно " + result);
                } else {
                    System.out.println("Некорретный ввод. b не должно быть равным 0 ");
                }
                break;
            case '%':
                result = String.valueOf(firstNumber % secondNumber);
                System.out.println("Остаток от деления чисел a и b равно " + result);
                break;
            case '^':
                result = String.valueOf(Math.pow(firstNumber, secondNumber));
                System.out.println(firstNumber + " в степени " + secondNumber + " равно " + result);
                break;
            default:
                System.out.println("Некорректная операция: " + mathOperator);
        }
    }

    public String toString() {
        return firstNumber + " " + mathOperator + " " + secondNumber + " = " + result;
    }
}