package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static mallang.missionutils.Console.readLine;

public class Cars {
    List<String> carNames = new ArrayList<>();
    List<Car> cars = new ArrayList<>();
    int gameCnt;
    final int MAX_NAME_LENGTH = 5;

    public void getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String[] nameLine = readLine().split(",");
            this.carNames = Arrays.stream(nameLine).toList();
            checkNameLength(MAX_NAME_LENGTH);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차 값 입력오류");
            getCarName();
        }
    }

    public void checkNameLength(int length) {
        for (String name : carNames) {
            if (name.length() > length) {
                System.out.println("[ERROR] 자동차 이름은 5글자 이하여야한다.");
                getCarName();
            }
        }
    }

    public void getGameCnt() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            this.gameCnt = Integer.parseInt(readLine());
        } catch (Exception e){
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            getGameCnt();
        }
    }

    public void makeCars() {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void moveAllCars(List<Car> cars) {
        for (Car c: cars) {
            c.move();
        }
    }

    public void getAllCarsStatus(List<Car> cars) {
        for (Car c : cars) {
            c.status();
        }

    }
}

