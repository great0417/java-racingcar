package racingWinner;

import java.util.ArrayList;
import java.util.List;

public class MakeCar {
	
	private final static int STRING_MAX_LENGTH = 5;
	//ī ���ڼ� �׽�Ʈ
	public static boolean checkMaxLength(String name) {
		if(name.length() <= STRING_MAX_LENGTH) {
			return true;
		}
		return false;
	}
	
	//ī �迭 ���ڼ� �׽�Ʈ
	public static boolean makeCarsCondition(String[] carNamesArray) {
		boolean flag = true;
		for(int i = 0; i < carNamesArray.length; i++) {
			//��� true�� true, �ϳ��� false�� false
			flag = flag && checkMaxLength(carNamesArray[i]);
		}
		return flag;
	}
	
	//ī Ŭ���� ����
	public static Car makeCar(String name) {
		Car car = new Car();
		car.setCarName(name);
		return car;
	}
	
	//ī ����Ʈ ����
	public static List<Car> makeCars(String[] carNamesArray) {
		List<Car> cars = new ArrayList<Car>();
		for(int i = 0; i < carNamesArray.length; i++) {
			Car car = makeCar(carNamesArray[i]);
			cars.add(car);
		}
		return cars;
	}

}
