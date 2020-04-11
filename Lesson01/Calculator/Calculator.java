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
		int a = 10, b = 4;
		char operationType = '&';
		
		// выполняем программу
		double resault;
		if (operationType == '+') {
			resault = a + b;
			System.out.println("Сумма чисел a и b равна " + (int)resault);
		}

		else if (operationType == '-') {
			resault = a - b;
			System.out.println("Разница чисел a и b равна " + (int)resault);
		}
		else if (operationType == '*') {
			resault = a * b;
			System.out.println("Произведение чисел a и b равно " + (int)resault);
		}				
		else if (operationType == '/') {
			resault = (double) a / b;
			System.out.println("Частное чисел a и b равно " + resault);
		}
		else if (operationType == '%') {
			resault = a % b;
			System.out.println("Остаток от деления чисел a и b равно " + (int)resault);
		}
		else if (operationType == '^') {
			resault = 1;
			for (int i = 0; i < b; i++) {
			resault *= a; // java сам приводит int к double
			}	
		System.out.println("Число a в степени b " + (int)resault);
		}
		else {
			System.out.println("Некорректная операция: " + operationType);
		}
	}
}