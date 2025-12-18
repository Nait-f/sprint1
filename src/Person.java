public class Person {
    int x, y; // координаты персонажа
    String image = "\uD83E\uDDD9\u200D"; // вид персонажа на поле
    int live = 3; // количество жизней

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }


    void move(int x, int y){
        this.x = x;//конструкцию this. мы рассмотрим немного позже
        this.y = y;
    }


    public boolean isMoveCorrect(int x, int y) {
        return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;
    }



}
