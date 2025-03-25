package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
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

    public void printSlash(){
        for(int i=0; i < position ; i++) {
            System.out.print("- ");
        }
        System.out.println();
    }
}
