import java.util.Random;
import java.util.Scanner;

import static com.sun.beans.introspect.PropertyInfo.Name.bound;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String person = "\uD83E\uDDD9\u200D";
        int personLive = 3;
        /* здесь необходимо рассказать про переполнение и про другие типы данных
            int personLive = 2147483649; // мало ли кто-то захочет сделать ооочень много жизней
         */

        String monster = "\uD83E\uDDDF\u200D";
        String castle = "\uD83C\uDFF0";
        int personX = 1;
        int personY = 3;
        int size = 5;
        int step = 0;

        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";


        String[][] board = new String[size][size];


        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                board[y - 1][x - 1] = "  ";
            }
        }

        Random random = new Random();


        int count_monster = size * size - size - 1;


        for (int i = 0; i <= count_monster; i++) {
            board[random.nextInt(size - 1)][random.nextInt(size)] = monster;
        }


        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println("Ваш ответ:\t" + answer);

        if (answer.equals("ДА")) {
            int castleY = 1;
            int castleX = 1 + random.nextInt(size);
            System.out.println("Начинаем играть");
            board[(castleY - 1)][castleX - 1] = castle;
            board[(personY - 1)][personX - 1] = person;

            System.out.println("Выбери сложность игры(от 1 до 5):");
            int difficultGame = scanner.nextInt();
            System.out.println("Выбранная сложность:\t" + difficultGame);


            while ((personLive > 0) && !(castleX == personX && castleY == personY)) {


                for (int y = 1; y <= size; y++) {
                    System.out.println(wall);
                    for (int x = 1; x <= size; x++) {
                        System.out.print(leftBlock);
                        System.out.print(board[(y - 1)][x - 1]);
                    }
                    System.out.println(rightBlock);
                }
                System.out.println(wall);
                System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;");
                System.out.println("Координаты персонажа - (x: " + personX + ", y: " + personY + "))");
                int x = scanner.nextInt();
                int y = scanner.nextInt();


                if (x != personX && y != personY) {
                    System.out.println("Неккоректный ход");
                } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {

                    if (board[y - 1][x - 1].equals("  ")) {
                        board[personY - 1][personX - 1] = "  ";
                        personX = x;
                        personY = y;

                        board[personY - 1][personX - 1] = person;
                        step++;
                        System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
                                "\\nХод номер: " + step);



                    } else if (board[y - 1][x - 1].equals(castle)) {
                        System.out.println("Вы прошли игру!");
                        board[personY - 1][personX - 1] = "  ";
                        personX = x;
                        personY = y;
                        board[personY - 1][personX - 1] = person;
                        break;
                    } else {
                        System.out.println("Реши задачу");
                        boolean success = taskMonster(300);
                        personLive--;
                        if (personLive == 0) {
                            success = taskMonster(400);
                            personLive--;
                        }
                        if (success){
                            board[personY - 1][personX - 1] = "  ";
                            personX = x;
                            personY = y;
                            board[personY - 1][personX - 1] = person;
                        }
                    }
                } else {
                    System.out.println("Координаты не изменены");
                }
            }

            //вывод поля


        } else {
            System.out.println("The end");
        }
    }

    static boolean taskMonster(int v) {
        Random r = new Random();
        int x = r.nextInt(v);
        int y = r.nextInt(v);
        int trueAnswer = x + y;
        System.out.println("Реши пример: " + x + " + " + y + " = ?");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if (trueAnswer == ans) {
            System.out.println("Верно! Ты победил монстра");
            return true;
        }
        System.out.println("Ты проиграл эту битву!");
        return false;
    }
}