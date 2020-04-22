package com.lesson02.guessnumber;
import java.util.Scanner;

public class GuessNumber {

	private int guessedNumber;

	GuessNumber(int rangeBegin, int rangeEnd) {
		guessedNumber = (int) (Math.random() * rangeEnd + rangeBegin);
		System.out.println("Сервисное сообщение: Загаданное число: " + guessedNumber);
	}
		
	// Играем.
	// Если Игрок1 не угадал, то ход переходит к Игроку2, если Игрок 2 также не угадал,
	// ход переходит к Игроку1 и так далее по кругу, пока число не будет угадано
	public void playGame(Player[] players) {
		Scanner sc = new Scanner(System.in);
		
		int i = 0; 
		do {
			System.out.print(players[i].getName() + ", введите число: ");
			players[i].setNumber(sc.nextInt()); // Игрок вводит число с консоли
			if (players[i].getNumber() == guessedNumber) {
				System.out.println(players[i].getName() + "! Вы угадали!");
				break; // выходим из цикла - останавливаем процесс угадывания
			} else if (players[i].getNumber() < guessedNumber) {
				System.out.println(players[i].getName() + ", ваше число меньше загаданного");
			} else {
				System.out.println(players[i].getName() + ", ваше число больше загаданного");
			}
			
			// Передача хода следующему игроку
			if (i == players.length - 1) {
				i = 0;
			} else {
				i++;
			}
		} while (true);
	}
}



			