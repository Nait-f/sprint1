import java.util.Scanner;

public class BigMonster extends Monster {

;


    BigMonster(int size) {
        super(size);
        this.image = "\uD83D\uDC3A";
    }


    // переопредилим метод:
    public boolean taskMonster(int difficultGame){
        System.out.println("Решите задачу:");
        int x = r.nextInt(15);
        int y = r.nextInt(10);
        int z = r.nextInt(20);
        int trueAnswer = x * y - z;
        System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");
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
