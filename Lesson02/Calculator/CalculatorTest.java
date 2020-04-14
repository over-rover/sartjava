/*
Реализуйте Калькулятор, который должен уметь выполнять математические операции 
(+, -, *, /, ^, %) над целыми положительными числами.
Для проверки знака математической операции воспользуйтесь оператором if else.
Выведите на экран результат работы калькулятора с помощью System.out.println()

Ввод с клавиатуры и методы класса Math или Random пока не используйте
*/
public class CalculatorTest {
	public static void main(String[] args) {
		//  Задаем два числа и указываем тип математической операции
		int a = 2, b = 10;
		char operator = '^';

		Calculator myCalc = new Calculator();
		myCalc.calculate(a, operator, b);
	}		
}