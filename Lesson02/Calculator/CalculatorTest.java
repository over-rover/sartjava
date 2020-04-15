/* TODO
Реализуйте Калькулятор, который должен уметь выполнять математические операции 
(+, -, *, /, ^, %) над целыми положительными числами.
Для проверки знака математической операции воспользуйтесь оператором switch().
Выведите на результат на экран
Используйте ввод с клавиатуры (класс Scanner)
Для продолжения/завершения работы программы выводите сообщение "Хотите продолжить? [да/нет]:". 
Если пользователь ввел ни "да" ни "нет", а что-то другое — снова выведите сообщение 
"Хотите продолжить? [да/нет]:". (Реализуйте эту логику в Test-классах)
*/
import java.util.Scanner;
public class CalculatorTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculator myCalc = new Calculator();
		String choice;	
			
		do {			
		System.out.print("Введите первое число (целое, положительное): ");
		int a = sc.nextInt();

		System.out.print("Введите операцию из перечня (+, -, *, /, ^, %): ");
		//char operator = sc.next(); // не прокатило. разные типы. придется sc.next().charAt(0);
								  	 // этого не было ни в видео, ни в ссылке на урок со Сканером	
		char operator = sc.next().charAt(0); // можно, наверное, передавать строку, тогда

		System.out.print("Введите второе число (целое, положительное): ");
		int b = sc.nextInt();		
		
		myCalc.calculate(a, operator, b);

		
		// Ввод кириллицей не понимает, поэтому вынужден запрашивать латинский ввод yes/no
		// как решить вопрос?
		System.out.println("Хотите продолжить? [yes/no]: ");
		choice = sc.next();

		while (!choice.equals("yes") && !choice.equals("no")) {
			System.out.println("!!!Ошибка при вводе!!! Попробуйте еще раз [yes/no]: ");
			choice = sc.next();
		}

		} while (choice.equals("yes"));

		sc.close();
	}		
}