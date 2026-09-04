package handling.util;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // Optional<Car> optionalCar = carRepository.findById(id);
        Supplier<Car> defaultUser = () -> new Car(80, 10);
        // Car user = optionalCar.orElseGet(defaultCar);
    }
}