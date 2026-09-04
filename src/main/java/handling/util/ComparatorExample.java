package handling.util;

import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        Car car1 = new Car(120,5);
        Car car2 = new Car(130, 7);

        System.out.println(car1.speed());
        System.out.println(car2.speed());

        Comparator<Car> bySpeed = (c1, c2) -> Integer.compare(c1.speed(), c2.speed());
    }
}
