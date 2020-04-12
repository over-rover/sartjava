/*
Реализуйте Калькулятор, который должен уметь выполнять математические операции 
(+, -, *, /, ^, %) над целыми положительными числами.
Для проверки знака математической операции воспользуйтесь оператором if else.
Выведите на экран результат работы калькулятора с помощью System.out.println()

Ввод с клавиатуры и методы класса Math или Random пока не используйте
*/
public class Calculator {
	public static void main(String[] args) {
		//  Задаем два числа и указываем тип математической операции
		int a = 10, b = 3;
		char operator = '^';
		
		// выполняем программу
		double result;
		if (operator == '+') {
			result = a + b;
			System.out.println("Сумма чисел a и b равна " + (int)result);
		} else if (operator == '-') {
		  	result = a - b;
			System.out.println("Разница чисел a и b равна " + (int)result);
		} else if (operator == '*') {
			result = a * b;
			System.out.println("Произведение чисел a и b равно " + (int)result);
		} else if (operator == '/') {
			result = (double) a / b;
			System.out.println("Частное чисел a и b равно " + result);
		} else if (operator == '%') {
			result = a % b;
			System.out.println("Остаток от деления чисел a и b равно " + (int)result);
		} else if (operator == '^') {
			result = 1;
			for (int i = 0; i < b; i++) {
				result *= a; // java сам приводит int к double
			}
			System.out.println("Число a в степени b " + (int)result);
		} else {
			System.out.println("Некорректная операция: " + operator);
		}
	}
}