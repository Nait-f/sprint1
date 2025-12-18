import java.util.Random;
import java.util.Scanner;


public class Dragon extends Monster {

    private int x, y;
    Random r = new Random();

    static String[] questions = new String[]{"ЗИМОЙ И ЛЕТОМ ОДНИМ ЦВЕТОМ?",
            "КРАСНА ДЕВИЦА СИДИТ В ТЕМНИЦЕ А КОСА НА УЛИЦЕ?",
            "НИ В ОГНЕ НЕ ГОРИТ, НИ В ВОДЕ НЕ ТОНЕТ?",
            "КТО Я, ЕСЛИ ПРЯМОТА ГЛАВНАЯ МОЯ ЧЕРТА?",
            "БЕЛЫЙ КАМУШЕК РАСТАЯЛ, НА ДОСКЕ СЛЕДЫ ОСТАВИЛ?"};
    static String[] answers = new String[]{"ЁЛКА", "МОРКОВЬ", "ЛЁД", "ЛИНЕЙКА", "МЕЛ"};


    Dragon(int size) {
        super(size);
        this.image = "\uD83D\uDC09";

    }


    public boolean taskMonster(int dif) {
        //from desk

        int x = r.nextInt(5);
        System.out.println("ВЫ встречаете Мудрого ДРАКОНА. Лиш отгадав его загадки вы продйдёте дальше! Реши пример:");
        String q = questions[x];
        String a = answers[x];

        System.out.println("Реши пример: " + q);
        Scanner sc = new Scanner(System.in);
        String ans = sc.nextLine();
        if (a.equals(ans)) {
            System.out.println("Верно! Ты победил Мудрого ДРАКОНА!");
            return true;
        } else System.out.println("Ты проиграл эту битву!");
        return false;
    }


}
