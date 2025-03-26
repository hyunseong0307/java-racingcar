package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final RacingResultPrinter printer = new RacingResultPrinter();
    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void play(int attempts) {
        for (int i = 0; i < attempts; i++) {
            cars.forEach(Car::move);
            printer.printCurrentCarPosition(cars);
        }
    }

    public List<String> findWinners() {
        int fastest = 0;
        for (Car car : cars) {
            if (car.getPosition() > fastest) {
                fastest = car.getPosition();
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == fastest) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
