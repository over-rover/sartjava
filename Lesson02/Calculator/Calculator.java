
public class Calculator {

	void calculate(int a, char operator, int b) {
		switch(operator) {
			case '+': 
				System.out.println("Сумма чисел a и b равна " + (a + b));
				break;
			case '-':
				System.out.println("Разница чисел a и b равна " + (a - b));
				break;
			case '*':
				System.out.println("Произведение чисел a и b равно " + (a * b));
				break;
			case '/':
				if (b != 0) {
					System.out.println("Частное чисел a и b равно " + (double) a / b);
					// Без явного приведения операция совершается как int
				} else {
					System.out.println("Некорретный ввод. b не должно быть равным 0 ");
				}
				break;
			case '%':
				System.out.println("Остаток от деления чисел a и b равно " + (a % b));
				break;
			case '^':
				int k = 1;
				for (int i = 0; i < b; i++) {
					k *= a;
				}
				System.out.println(a + " в степени " + b + " равно " + k);
				break;
			default:
				System.out.println("Некорректная операция: " + operator);
		}
	}		
}