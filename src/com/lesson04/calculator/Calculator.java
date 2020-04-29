package com.lesson04.calculator;

public class Calculator {
    private int firstNumber;
    private int secondNumber;
    private char mathOperator;
    private String[] resultHistory;
    private int i = 0;

    Calculator(int expressionMaxNumber) {
        resultHistory = new String[expressionMaxNumber];
    }

    /* Обрабатываем строку - раскладываем ее на части и инициализиируем поля.
       Проверку на корректность ввода не осуществляем - не требуется в рамках данной задачи.*/
    public void setExpression(String expression) {
        // Разбиваем строку по пробелам, сохраняем в виде массива из 3 элементов.
        String[] splitExpression = expression.split(" ", 3);
        firstNumber = Integer.parseInt(splitExpression[0]);
        mathOperator = splitExpression[1].charAt(0);
        secondNumber = Integer.parseInt(splitExpression[2]);
    }

    /*Результат вычислений может быть как целого типа, так и вещественного,
    * чтобы не плодить переменные, конвертируем результат к типу String*/
    public void calculate() {
        switch(mathOperator) {
            case '+':
                resultHistory[i] = String.valueOf(Math.addExact(firstNumber, secondNumber));
                System.out.println("Сумма чисел a и b равна " + resultHistory[i]);
                break;
            case '-':
                resultHistory[i] = String.valueOf(Math.subtractExact(firstNumber, secondNumber));
                System.out.println("Разница чисел a и b равна " + resultHistory[i]);
                break;
            case '*':
                resultHistory[i] = String.valueOf(Math.multiplyExact(firstNumber, secondNumber));
                System.out.println("Произведение чисел a и b равно " + resultHistory[i]);
                break;
            case '/':
                if (secondNumber != 0) {
                    resultHistory[i] = String.valueOf((double) firstNumber / secondNumber);
                    System.out.println("Частное чисел a и b равно " + resultHistory[i]);
                } else {
                    System.out.println("Некорретный ввод. b не должно быть равным 0 ");
                }
                break;
            case '%':
                resultHistory[i] = String.valueOf(firstNumber % secondNumber);
                System.out.println("Остаток от деления чисел a и b равно " + resultHistory[i]);
                break;
            case '^':
                resultHistory[i] = String.valueOf(Math.pow(firstNumber, secondNumber));
                System.out.println(firstNumber + " в степени " + secondNumber + " равно " + resultHistory[i]);
                break;
            default:
                System.out.println("Некорректная операция: " + mathOperator);
        }

        // При заполнении массива переключаемся на его нулеввой элемент
        if (i == resultHistory.length - 1) {
            i = 0;
        } else i++;
    }

    public String getResult(int i) {
        return resultHistory[i];
    }
}