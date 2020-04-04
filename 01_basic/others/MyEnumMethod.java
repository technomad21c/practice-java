// src: https://opentutorials.org/module/516/6091

enum Fruit {
    APPLE, PEACH, BANANA;
}

enum Company {
    GOOGLE, APPLE, ORACLE;
}

enum Fruit2 {
    APPLE("red"), PEACH("pink"), BANANA("yellow");
    public String color;
    Fruit2 (String color) {
        System.out.println("Call Constructor " + this);
        this.color = color;
    }
}

public class MyEnumMethod {
    public static void main(String[] args) {
        Fruit type = Fruit.APPLE;
        switch (type) {
            case APPLE:
                System.out.println(57 + " kcal");
                break;
            case PEACH:
                System.out.println(34 + " kcal");
                break;
            case BANANA:
                System.out.println(93 + " kcal");
                break;
        }

        Fruit2 type2 = Fruit2.APPLE;
        switch (type) {
            case APPLE:
                System.out.println(57 + " kcal, " + Fruit2.APPLE.color);
                break;
            case PEACH:
                System.out.println(34 + " kcal, " + Fruit2.PEACH.color);
                break;
            case BANANA:
                System.out.println(93 + " kcal, " + Fruit2.BANANA.color);
                break;
        }
    }
}
