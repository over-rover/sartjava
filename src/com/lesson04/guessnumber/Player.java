package com.lesson04.guessnumber;
import java.util.Arrays;

public class Player {
	private String name; // имя игрока
	private int[] numbers; // массив чисел
	private int attemptIndex = -1; // счетчик попыток (используется для индексации массива чисел)

	Player(String name, int maxAttempt) {
		this.name = name;
		numbers = new int[maxAttempt];
	}

	public String getName() {
		return name;
	}

	public void setNumber(int number) {
		attemptIndex++;
		numbers[attemptIndex] = number;
	}

	public int getNumber(int attemptIndex) {
		return numbers[attemptIndex];
	}

	public int[] getNumbers() {
		return Arrays.copyOf(numbers, attemptIndex + 1);
	}

	public int getAttemptIndex() {
		return attemptIndex;
	}

	public void clear() {
		Arrays.fill(numbers, 0, attemptIndex + 1, 0);
		attemptIndex = -1;
	}
}