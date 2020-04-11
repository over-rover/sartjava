public class Cycle {
	public static void main (String[] args) {
		// задача: вывести числа в отрезке 0:20 с помощью цикла for
		for (int i = 0; i <= 20; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		// Выведите на консоль с помощью цикла while 
		// все числа от [6, -6] (шаг итерации равен 2)
		int startPoint = 6, endPoint = -6, iteration = -2;
		int i = startPoint;
		while (i >= -6) {
			System.out.print(i + "\t");
			i += iteration;
		}
		System.out.println();

		//  Подсчитайте с помощью цикла do-while 
		//	сумму нечетных чисел от [10, 20], и выведите ее на консоль
		//  Ответ: 75
		startPoint = 10; endPoint = 20; iteration = 2;
		int resault = 0;
		i = startPoint + 1;
		do {
			System.out.print(i + "\t");
			resault += i;
			i += iteration;
			
		}
		while (i < endPoint);

		System.out.println("\nСумма нечетных чисел из отрезка [10, 20] равна " + resault);





	}
}