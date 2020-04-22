package com.lesson01.unicode;
/*
Выведите в цикле символы кодировки Unicode в диапазоне [9398, 10178]. 
Если выводятся кракозябры, то в диапазоне [33, 126]
*/
public class Unicode {
	public static void main(String[] args) {
		int begin = 33, end = 126; // Задаем диапазон. Максимум - 65536, потом пойдет по кругу
		for (int i = begin; i <= end; i++) {
			System.out.println("Под DEC-номером " + i + " закодирован Юникод-символ " + (char) i);
		}
	}
}