import java.util.Random;
import java.util.Scanner;

public class Monster {

    protected String image = "\uD83E\uDDDF\u200D";
    private int x, y;
    Random r = new Random();




    Monster(int size) {
        this.x = r.nextInt(size);
        this.y = r.nextInt(size);
    }

    public String getImage() {
        return this.image;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean conflictPerson(int perX, int perY) {
        return perY - 1 == this.y && perX - 1 == this.x;
    }

    public boolean taskMonster(int difGame) {
        System.out.println("Решите задачу:");
        int x = r.nextInt(100);
        int y = r.nextInt(100);
        int true_ans = x + y;
        System.out.println("Реши пример: " + x + " + " + y + " = ?");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if (true_ans == ans) {
            System.out.println("Верно! Ты победил монстра");
            return true;
        }
        System.out.println("Ты проиграл эту битву!");
        return false;
    }
}

