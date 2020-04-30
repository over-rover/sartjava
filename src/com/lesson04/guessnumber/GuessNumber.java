package com.lesson04.guessnumber;
import java.util.Scanner;

public class GuessNumber {
    private Player[] players;
    private int maxAttempt;
    private int guessedNumber;
    private int plIndex; // порядковый номер игрока
    private int attemptIndex = 0; // индекс массива чисел, он же счетчик попыток
    private int winnerIndex = -1; // номер победившего игрока. -1 означает, что победителя нет
    private int winnerAttemptIndex = -1; // номер успешной попытки победителя
    private boolean guessed = false; // флаг: число угадано

    GuessNumber(int rangeBegin, int rangeEnd) {
        guessedNumber = (int) (Math.random() * rangeEnd + rangeBegin);
        System.out.println("Сервисное сообщение: Загаданное число: " + guessedNumber);
    }

    /* Процесс угадывания. Во внутреннем цикле игроки по очереди вводят числа и производится сравнение с загаданным числом.
    Во внешнем цикле итерируются попытки угадывания*/
    public void playGame(Player[] players, int maxAttempt) {
        this.players = players;
        this.maxAttempt = maxAttempt;
        Scanner sc = new Scanner(System.in);

        do {
            plIndex = 0;
            do {
                // Игрок вводит число с консоли. Число записывается в массив numbers с индексом attempt
                System.out.print(players[plIndex].getName() + ", введите число: ");
                players[plIndex].setNumber(sc.nextInt(), attemptIndex);
                if (players[plIndex].getNumber(attemptIndex) == guessedNumber) {
                    System.out.println(players[plIndex].getName() + " угадал число " + guessedNumber + " с " +
                            (attemptIndex + 1) + " попытки");
                    guessed = true;
                    winnerIndex = plIndex; // фиксируем, кто из игроков угадал число
                    winnerAttemptIndex = attemptIndex; // фиксируем номер успешной попытки
                    break; // выходим из цикла - останавливаем процесс угадывания
                } else if (players[plIndex].getNumber(attemptIndex) < guessedNumber) {
                    System.out.println(players[plIndex].getName() + ", ваше число меньше загаданного");
                } else {
                    System.out.println(players[plIndex].getName() + ", ваше число больше загаданного");
                }

                if (attemptIndex == maxAttempt - 1) {
                    System.out.println("У " + players[plIndex].getName() + " закончились попытки");
                }

                plIndex++; // Передача хода следующему игроку.
            } while (plIndex <= players.length - 1);

            attemptIndex++;
        } while (attemptIndex < maxAttempt & !guessed);

        for (plIndex = 0; plIndex < players.length; plIndex++) {
            setDimAndMakeNumbersCopy(); // создаем массив-копию, в котором хранятся числа, введенные игроками
            showHistory();
            players[plIndex].clearArrays(); // обнуляем заполненные элементы массивов
        }
    }

    /*Создание усеченного массива чисел. Он является копией основного массива, но может быть меньшего размера, в
    том случае, если один из игроков угадывает число и игра завершается досрочно.
    Размер усеченного массива устанавливается исходя из того было ли угадано число и в каком порядке выступали игроки.
    Если победил первый игрок, то он использовал на одну попытку больше (после его попытки игра прекратилась).
    При этом, возможен частный случай, когда первый игрок угадал с первой попытки.
    Это означает, что следующий в очереди игрок не получил даже шанса угадатьчисло.
    Чтобы отработать этот вариант создается усеченный массив состоящий из одного элемента-нуля.
    Если угадал последний игрок - то число использованных попыток одинаково у всех игроков.*/
    public void setDimAndMakeNumbersCopy() {
        if (plIndex <= winnerIndex & guessed) { // Игрок делает ход раньше победителя (или является победителем)
            players[plIndex].setNumbersCopy(winnerAttemptIndex + 1); // значит у игрока столько же использованных попыток, как у победителя
        } else if (plIndex > winnerIndex & winnerAttemptIndex == 0 & guessed) { // Игрок делает ход после победителя, но победитель угадал с первой попытки
            players[plIndex].setNumbersCopy(winnerAttemptIndex + 1); // Игрок не сделал ни одной попытки - создаем массив из одного элемента.
        } else if (plIndex > winnerIndex & guessed) { // Игрок делает ход после победителя, значит у него меньше использованных попыток
            players[plIndex].setNumbersCopy(winnerAttemptIndex);
        }
        else {
            players[plIndex].setNumbersCopy(maxAttempt);
        }
    }

    public void showHistory() {
        System.out.print(players[plIndex].getName() + " вводил: ");
        for (int i : players[plIndex].getNumbersCopy()) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}