import java.util.Random;
import java.util.Scanner;


public class Cat extends Monster {

    private int x, y;
    Random r = new Random();



    static String[] questions = new String[]{"Усы помогают кошке ориентироваться в пространстве?",
            "У кошки 30 зубов?",
            "Кошка шипит когда радуется?",
            "При падении с высоты кошка может переворачиваться и приземляться на лапы?",
            "Кошки видят в полной темноте?"};
    static String[] answers = new String[]{"ДА", "ДА", "НЕТ", "ДА", "НЕТ"};


    Cat(int size) {
        super(size);
        this.image = "🐱";
        ////   this.image = "\uD83D\uDC09";

    }


    public boolean taskMonster(int dif) {
        //from desk

        int x = r.nextInt(5);
        System.out.println("ВЫ встречаете Котика 🐱 Скажите верны ли утверджения про котов ДА или НЕТ:");
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
