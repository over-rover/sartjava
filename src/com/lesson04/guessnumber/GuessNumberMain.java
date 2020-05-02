package com.lesson04.guessnumber;
/*TODO
Модифицируйте программу Угадай число, используя массивы для хранения названных игроками чисел.
Перед началом игры выведите сообщение: У вас 10 попыток.
По окончанию игры отобразите в две строки через пробел, все названные игроками числа (в первой строке -
варианты первого игрока, во второй - второго).
Если массив полностью не заполнен, т.е. пользователь угадал число менее чем за 10 попыток, то выводить
весь массив не нужно.
В конце игры выведите сообщение "Игрок " + имя + " угадал число " + число + " с " + номер + " попытки"
Если игроки не угадали число за 10 попыток, то отобразите сообщение: "У " + имя + " закончились попытки"
Создайте дополнительное поле в классе Player, которое будет хранить введенные пользователем числа.
Для считывания части массива используйте метод Arrays.copyOf.
Для обнуления массивов игроков, при повторном запуске игры, используйте метод Arrays.fill().
При этом обнуляйте только те ячейки, где хранятся, названные игроками числа*/

import java.util.Scanner;

public class GuessNumberMain {
    public static void main(String[] args) {
        int rangeBegin = 1; // начало отрезка
        int rangeEnd = 100; // конец отрезка
        int totalPlayers = 2; // Количество игроков
        int maxAttempt = 5; // Максимальное число попыток

        Player[] players = new Player[totalPlayers];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < totalPlayers; i++) {
            System.out.print("Введите имя игрока №" + (i + 1) +": ");
            players[i] = new Player(sc.next(), maxAttempt);
        }

        // Процесс игры
        GuessNumber game = new GuessNumber(rangeBegin, rangeEnd, players, maxAttempt);
        System.out.println("Отгадайте число за " + maxAttempt + " попыток");
        char choice = 'y'; // желание продолжить игру [y/n]
        int plIndex; // указатель игрока (он же индекс в массиве players[])
        do {
            game.playGame();
            System.out.println("Уважаемые игроки, можно повторить игру... хотите? [y/n]");
            // Проверяем желание каждого игрока повторить игру. При первом же отрицательном ответе завершаем программу.
            plIndex = 0;
            while (choice == 'y' && plIndex < totalPlayers) {
                System.out.print(players[plIndex].getName() + "?\t");
                choice = sc.next().charAt(0);
                while (choice != 'y' && choice != 'n') {
                    System.out.println(players[plIndex].getName() + " !!!Ошибка!!! Используйте [y/n]: ");
                    choice = sc.next().charAt(0);
                }
                plIndex++;
            }
        } while (choice == 'y');

        System.out.println("Игра окончена");
    }
}