package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = inputCarNames();
        int attempts = inputAttemptCount();
        System.out.println("\n실행 결과");
        playGames(cars, attempts);
        printWinners(cars);

    }

    private static List<Car> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            carName = carName.trim();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static int inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    //차 움직이기
    private static void playGames(List<Car> cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
            }
            printCurrentCarPosition(cars);
        }
    }

    //경주 후 차위치 출력
    private static void printCurrentCarPosition(List<Car> cars) {
        for(Car car : cars) {
            System.out.print(car.getName() + " : ");
            car.printSlash();
        }
        System.out.println();
    }

    //우승자 출력
    private static void printWinners(List<Car> cars) {
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

        System.out.print("최종 우승자 : ");
        for (int i=0; i<winners.size(); i++) {
            System.out.print(winners.get(i));
            if(i < winners.size()-1) {
                System.out.print(", ");
            }
        }
    }
}

class Car {
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



