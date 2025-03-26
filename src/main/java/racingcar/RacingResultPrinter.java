package racingcar;

import java.util.List;

//출력관련 클래스
public class RacingResultPrinter {
    //경주 후 차위치 출력
    public void printCurrentCarPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
