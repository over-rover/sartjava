package com.lesson04.guessnumber;
import java.util.Arrays;

public class Player {
	private String name; // имя игрока
	private int[] numbers; // массив чисел
	private int[] numbersCopy; // усеченный массив чисел

	Player(String name, int maxAttempt) {
		this.name = name;
		numbers = new int[maxAttempt];
	}

	public String getName() {
		return name;
	}

	public void setNumber(int number, int attemptIndex) {
		this.numbers[attemptIndex] = number;
	}

	public int getNumber(int attemptIndex) {
		return numbers[attemptIndex];
	}

	public void setNumbersCopy(int dim) {
		numbersCopy = Arrays.copyOf(numbers, dim);
	}

	public int[] getNumbersCopy() {
		return numbersCopy;
	}

	public void clearArrays() {
		Arrays.fill(numbers, 0, numbersCopy.length-1, 0);
		Arrays.fill(numbersCopy,0);
	}
}