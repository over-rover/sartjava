package com.lesson04.guessnumber;
import java.util.Scanner;

public class GuessNumber {
    private Player[] players;
    private int maxAttempt;
    private int rangeBegin;
    private int rangeEnd;
    private int hiddenNumber; // загаданное число
    private int plIndex; // порядковый номер игрока
    private Scanner sc = new Scanner(System.in); // лучше наверное здесь создать, чем плодить в inputNumber и забирать ресурсы?
   // в данном случае ввод только в одном методе. А если в нескольких - принятно ли sc делать глобальной?

    GuessNumber(int rangeBegin, int rangeEnd, Player[] players, int maxAttempt) {
        this.players = players;
        this.maxAttempt = maxAttempt;
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
    }

    public void generateNumber() {
        hiddenNumber = (int) (Math.random() * rangeEnd + rangeBegin);
        System.out.println("Отгадайте число за " + maxAttempt + " попыток");
        System.out.println("Сервисное сообщение: Загаданное число: " + hiddenNumber);
    }

    /* Процесс угадывания.
    Внутренний цикл:  Ввод числа. Проверка числа и номера попытки. Возврат true в случае угадывания. Вывод сообщений.
    Внешний цикл - итерируются попытки угадывания*/
    public void playGame() {
        boolean guessed = false;
        do {
            do {
                inputNumber();
                guessed = checkNumber(); // Проверка числа и номера попытки. Вывод сообщений.
                 /* Не понял, длwhile (!guessed && currentAttempt < maxAttempt - 1);я чего от checkNumber() требуется возвращать булеан. Я изменил, конечно, но принципиально
                ничего не поменялось - просто флаг стал локальным. Даже нет возможности использовать if (checkNumber()) и
                while (!checkNumber() && players[plIndex].getAttemptIndex() < maxAttempt - 1), так в методе
                используется вывод на экран, который дублируется. И опять же - лишний раз обращаться к методу*/
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
        plIndex = 0;
    }

    public void inputNumber() {
        //Scanner sc = new Scanner(System.in);
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