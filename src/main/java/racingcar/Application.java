package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = inputCarNames();
        int attempts = inputAttemptCount();

    }
    private static List<Car> inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();

        for(String carName : carNames){
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static int inputAttemptCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    //차 움직이기
    private static void playGames(List<Car> cars, int attempts){
        for(int i = 0; i < attempts; i++){
            for(Car car : cars){
                car.move();
            }
        }
    }

}
class Car{
    private final String carName;
    private int position;

    public Car(String carName){
        this.carName = carName;
        this.position = 0;
    }

    public void move(){
        if(Randoms.pickNumberInRange(0,9)>=4)
            position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return carName;
    }
}


