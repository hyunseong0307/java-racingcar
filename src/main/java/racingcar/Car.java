package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    private int position = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4)
            position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return carName;
    }
}
