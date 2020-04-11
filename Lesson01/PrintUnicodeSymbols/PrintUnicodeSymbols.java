/*
Выведите в цикле символы кодировки Unicode в диапазоне [9398, 10178]. 
Если выводятся кракозябры, то в диапазоне [33, 126]
*/
public class PrintUnicodeSymbols {
	public static void main(String[] args) {
		int begin = 33, end = 126; // Задаем диапазон
		char symbol;
		for (int i = begin; i <= 126; i++) {
			symbol = (char) i; // корректно отработает до 65536
			System.out.println("Под DEC-номером " + i + " закодирован Юникод-символ " + symbol);
		}
	}
}