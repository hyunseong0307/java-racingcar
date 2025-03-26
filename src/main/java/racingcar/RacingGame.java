package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void play(int attempts) {
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
            }
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
