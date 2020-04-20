import java.util.Scanner;

public class GuessNumber {

	private int guessedNumber;

	GuessNumber(int rangeBegin, int rangeEnd, int totalPlayers, Player[] player) {
		// генерим случайное число в заданном отрезке
		guessedNumber = (int) (Math.random()*rangeEnd+rangeBegin);
		System.out.println("Сервисное сообщение: Загаданное число: " + guessedNumber);
		Scanner sc = new Scanner(System.in);

		// Начинаем угадывания
		// Если Игрок1 не угадал, то ход переходит к Игроку2, если Игрок 2 также не угадал,
		// ход переходит к Игроку1 и так далее по кругу, пока число не будет угадано
		int i = 0; // 
		do {
			System.out.print(player[i].getName() + ", введите число: ");
			player[i].setNumber(sc.nextInt()); // Игрок вводит число с консоли
			if (player[i].getNumber() == guessedNumber) {
				System.out.println(player[i].getName()+"! Вы угадали!");
			} else if (player[i].getNumber() < guessedNumber) {
				System.out.println(player[i].getName() + ", ваше число меньше загаданного");
				i = nextPlayerTurn(i, totalPlayers); // передача хода
			} else {
				System.out.println(player[i].getName() + ", ваше число больше загаданного");
				i = nextPlayerTurn(i, totalPlayers); // передача хода
			}
		} while (player[i].getNumber() != guessedNumber);
	}

	public int getGuessedNumber() {
		return guessedNumber;
	}

	// Передача хода следующему игроку
	public static int nextPlayerTurn(int i, int totalPlayers) {
		if (i == totalPlayers-1) {
			return 0;
		} else {
			return ++i; // ВНИМАНИЕ! ПРАВИЛА АРИФМ ОПЕРАЦИЙ! i++ не годится
		}
	}
}



			