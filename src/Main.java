import java.util.Random;
import java.util.Scanner;

import static com.sun.beans.introspect.PropertyInfo.Name.bound;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int size = 5;
        int step = 0;
        Person person = new Person();
        person.x = 1;
        person.y = 3;
        int count = 0;
        
        
        /* здесь необходимо рассказать про переполнение и про другие типы данных
            int personLive = 2147483649; // мало ли кто-то захочет сделать ооочень много жизней
         */

    ///    String monster = "\uD83E\uDDDF\u200D";

        String castle = "\uD83C\uDFF0";
        ///


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

//////////////////    НУЖНО
        Monster[] arrMonster = new Monster[count_monster + 1];
        Monster test;
        while (count <= count_monster) {
            int z = (random.nextInt(3));
            if (z == 0) {
                test = new Monster(size);
            } else if (z ==1){
                test = new BigMonster(size);
            } else {
                test = new Dragon(size);
            }


            if (board[test.getY()][test.getX()].equals("  ")) {
                board[test.getY()][test.getX()] = test.getImage();
                arrMonster[count] = test;
                count++;
            }
        }


        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println("Ваш ответ:\t" + answer);

        if (answer.equals("ДА")) {
            int castleY = 1;
            int castleX = 1 + random.nextInt(size);

            int DragonY = 2;
            int DragonX = 1 + random.nextInt(size);

            System.out.println("Начинаем играть. Твоя цель дойти до замка, побеждая монстров на пути \uD83D\uDCA5 ПОЕХАЛИ \uD83C\uDF89");
            board[(castleY - 1)][castleX - 1] = castle;
            board[(person.getY() - 1)][person.getX() - 1] = person.image;

            System.out.println("Выбери сложность игры(от 1 до 5):");
            int difficultGame = scanner.nextInt();
            System.out.println("Выбранная сложность:\t" + difficultGame);


            while ((person.live > 0) && !(castleX == person.getX() && castleY == person.getY())) {


                for (int y = 1; y <= size; y++) {
                    System.out.println(wall);
                    for (int x = 1; x <= size; x++) {
                        System.out.print(leftBlock);
                        System.out.print(board[(y - 1)][x - 1]);
                    }
                    System.out.println(rightBlock);
                }
                System.out.println(wall);
                System.out.println("Введите куда будет ходить персонаж(Ход возможен только по вертикали и горизонтали на одну клетку [например 1 'enter' 3 'enter']);");
                System.out.println("Координаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + "))");
                int x = scanner.nextInt();
                int y = scanner.nextInt();


                if (x != person.getX() && y != person.getY()) {
                    System.out.println("Неккоректный ход");
                } else if (Math.abs(x - person.getX()) == 1 || Math.abs(y - person.getY()) == 1) {

                    if (board[y - 1][x - 1].equals("  ")) {
                        board[person.getY() - 1][person.getX() - 1] = "  ";
                        person.move(x,y);
                        board[person.getY() - 1][person.getX() - 1] = person.image;
                        step++;
                        System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() +
                                "\\nХод номер: " + step);



                    } else if (board[y - 1][x - 1].equals(castle)) {
                        System.out.println("\uD83C\uDF86ВЫ ПРОШЛИ ИГРУ! ПОЗДРАВЛЯЮ^^\uD83C\uDF20");
                        board[person.getY() - 1][person.getX() - 1] = "  ";
                        person.x = x;
                        person.y = y;
                        board[person.getY() - 1][person.getX() - 1] = person.image;
                        break;
                    } else {
                        //// НУЖНО
                        for (Monster monster2 : arrMonster) {
                            if (monster2.conflictPerson(x, y)) {
                                if (monster2.taskMonster(difficultGame)) {
                                    board[person.getY() - 1][person.getX() - 1] = "  ";
                                    person.move(x, y);

                                    board[person.getY() - 1][person.getX() - 1] = person.image;
                                } else {
                                    person.live --;
                                }
                                break;
                            }
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
}