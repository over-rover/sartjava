package com.lesson04.guessnumber;
import java.util.Scanner;

public class GuessNumber {
    private Player[] players;
    private int maxAttempt;
    private int rangeBegin;
    private int rangeEnd;
    private int hiddenNumber; // загаданное число
    private int plIndex; // указатель игрока (он же индекс в массиве players[])
    private Scanner sc = new Scanner(System.in);

    GuessNumber(int rangeBegin, int rangeEnd, Player[] players, int maxAttempt) {
        this.players = players;
        this.maxAttempt = maxAttempt;
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
    }

    /** Процесс угадывания.
     * Внутренний цикл:  Ввод числа. Проверка числа и номера попытки. Возврат true в случае угадывания. Вывод сообщений.
     * Внешний цикл - итерируются попытки угадывания
     */
    public void playGame() {
        generateNumber();
        exitLabel:
        do {
            do {
                inputNumber();
                if (checkNumber()) break exitLabel;
                plIndex++;
            } while (plIndex < players.length);
            plIndex = 0;
        } while (players[plIndex].getAttemptIndex() < maxAttempt - 1);

        for (plIndex = 0; plIndex < players.length; plIndex++) {
            showHistory();
            players[plIndex].clear();
        }
        plIndex = 0;
    }

    public void generateNumber() {
        hiddenNumber = (int) (Math.random() * rangeEnd + rangeBegin);
        System.out.println("Отгадайте число за " + maxAttempt + " попыток");
        System.out.println("Сервисное сообщение: Загаданное число: " + hiddenNumber);
    }

    public void inputNumber() {
        System.out.print(players[plIndex].getName() + ", введите число: ");
        players[plIndex].setNumber(sc.nextInt());
    }

    public boolean checkNumber() {
        String currentName = players[plIndex].getName(); // сокращаем запись
        int currentAttempt = players[plIndex].getAttemptIndex(); // сокращаем запись
        int currentNumber = players[plIndex].getNumber(players[plIndex].getAttemptIndex()); // сокращаем запись

        if (currentNumber == hiddenNumber) {
            System.out.println(currentName + " угадал число " + hiddenNumber + " с " +
                    (currentAttempt + 1) + " попытки");
            return true;
        } else if (currentNumber < hiddenNumber) {
            System.out.println(currentName + ", ваше число меньше загаданного");
        } else {
            System.out.println(currentName + ", ваше число больше загаданного");
        }

        if (currentAttempt == maxAttempt - 1) {
            System.out.println("У " + currentName + " закончились попытки");
        }
        return false;
    }

    public void showHistory() {
        System.out.print(players[plIndex].getName() + " вводил: ");
        for (int i : players[plIndex].getNumbers()) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}