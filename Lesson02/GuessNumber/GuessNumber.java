// правильнее было бы назвать класс CheckNumber
import java.util.Scanner;

public class GuessNumber {

	private int guessedNumber;

	GuessNumber(int segmentBegin, int segmentEnd, int totalPlayers) {
		// генерим случайное число в заданном отрезке
		guessedNumber = (int) (Math.random()*segmentEnd+segmentBegin);
		System.out.println("Сервисное сообщение: Загаданное число: " + guessedNumber);

		Player[] player = new Player[totalPlayers];
		// ввод данных игроков.
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < totalPlayers; i++) {
			System.out.print("Введите имя игрока №" + (i+1) +": ");
			player[i] = new Player(sc.next());
		}
		 

		// Начинаем угадывания
		int i = 0; // переключатель игроков
		do {
			System.out.print(player[i].getName() + ", Введите целое число: ");
			player[i].setNumber(sc.nextInt()); // Игрок вводит число с консоли
			if (player[i].getNumber() == guessedNumber) {
				System.out.println(player[i].getName()+"! Вы угадали!");
			} else if (player[i].getNumber() < guessedNumber) {
				System.out.println(player[i].getName() + ", ваше число меньше загаданного");
				i = changePlayer(i, totalPlayers); // передача хода по кругу
			} else {
				System.out.println(player[i].getName() + ", ваше число больше загаданного");
				i = changePlayer(i, totalPlayers); // передача хода по кругу
			}
		} while (player[i].getNumber() != guessedNumber);


		//---------------------------------------------------------------------------------------
	}

	public int getGuessedNumber() {
		return guessedNumber;
	}

	public static int changePlayer(int i, int totalPlayers) {
		if (i == totalPlayers-1) {
			return 0;
		} else {
			return ++i; // ВНИМАНИЕ! ПРАВИЛА АРИФМ ОПЕРАЦИЙ! i++ не годится
		}
	}

	public boolean wantMore(int totalPlayers) {
		char choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Уважаемые игроки, можно повторить игру... хотите? [y/n]");
		for (int i = 0; i < totalPlayers; i++) {
			// System.out.print(player[i].getName() + "?\t"); // доступа к объекту нет. Как так-то?	
			choice = sc.next().charAt(0);
			while (choice != 'y' && choice != 'n') {
				System.out.println("!!!Ошибка при вводе!!! Попробуйте еще раз [y/n]: ");
				choice = sc.next().charAt(0);
			}
			if (choice == 'n') {
				return false;
			}
		}
		return true;
	}
}



			