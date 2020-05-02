package com.lesson04.guessnumber;
import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {
    private Player[] players;
    private int maxAttempt;
    private int guessedNumber;
    private int plIndex; // порядковый номер игрока
    private boolean guessed; // флаг: число угадано

    GuessNumber(int rangeBegin, int rangeEnd, Player[] players, int maxAttempt) {
        this.players = players;
        this.maxAttempt = maxAttempt;
        guessedNumber = (int) (Math.random() * rangeEnd + rangeBegin);
        System.out.println("Сервисное сообщение: Загаданное число: " + guessedNumber);
    }

    /* Процесс угадывания.
    Внутренний цикл - ввод числа. Проверка числа и номера попытки. Поднятие флага guessed. Вывод сообщений.
    Внешний цикл - итерируются попытки угадывания*/
    public void playGame() {
        Scanner sc = new Scanner(System.in);
        do {
            do {
                System.out.print(players[plIndex].getName() + ", введите число: ");
                players[plIndex].setNumber(sc.nextInt());
                checkNumber(); // Проверка числа и номера попытки. Поднятие флага guessed. Вывод сообщений.
                if (guessed)  {
                    break;
                } else {
                    plIndex++;
                }
            } while (plIndex < players.length);
            plIndex = 0;
        } while (!guessed && players[plIndex].getAttemptIndex() < maxAttempt - 1);

        for (plIndex = 0; plIndex < players.length; plIndex++) {
            showHistory();
            players[plIndex].clear();
        }
    }

    public void checkNumber() {
        if (players[plIndex].getNumber(players[plIndex].getAttemptIndex()) == guessedNumber) {
            System.out.println(players[plIndex].getName() + " угадал число " + guessedNumber + " с " +
                    (players[plIndex].getAttemptIndex() + 1) + " попытки");
            guessed = true; // число угадано
        } else if (players[plIndex].getNumber(players[plIndex].getAttemptIndex()) < guessedNumber) {
            System.out.println(players[plIndex].getName() + ", ваше число меньше загаданного");
        } else {
            System.out.println(players[plIndex].getName() + ", ваше число больше загаданного");
        }

        if (players[plIndex].getAttemptIndex() == maxAttempt - 1) {
            System.out.println("У " + players[plIndex].getName() + " закончились попытки");
        }
    }

    public void showHistory() {
        System.out.print(players[plIndex].getName() + " вводил: ");
        for (int i : Arrays.copyOf(players[plIndex].getNumbers(), players[plIndex].getAttemptIndex() + 1)) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}