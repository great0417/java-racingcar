package racingWinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunOrStop {
	private final static int RUN = 4;
	
	//���� Ŭ������ �ѹ��� ����ϰ� ����
	public static void racing(List<Car> cars, int reps) {
		Random random = new Random();
		for(int i = 1; i <= reps; i++) {
			cars =  runOrStopWithRandom(cars, random);
			System.out.println(i + "��°");
			printCars(cars);
			System.out.println();
			System.out.println();
		}
	}
	
	//�����ϴ� ������ ���� 4�̻��� ����̴�.
	public static boolean runOrStopCondition(int num) {
		if(RUN <= num) {
			return true;
		}
		return false;
	}
	
	//�ڵ����� ���ǿ� ���� ���� �Ǵ� ���� �� �ִ�.
	//Car Ŭ������ ����
	public static Car runOrStop(int condition, Car car) {
		if(runOrStopCondition(condition)) {
			car.setLocation(car.getLocation() + 1);
		}
		return car;
	}
	
	// 0���� 9 ���̿��� random ���� ���� �� ���ǿ� ���� ����
	//Car Ŭ������ ����
	public static List<Car> runOrStopWithRandom(List<Car> cars, Random random) {
		for(int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			car = runOrStop(random.nextInt(10), cars.get(i));
			cars.set(i, car);
		}
		return cars;
	}
	
	//�ڵ����� ���¸� ȭ�鿡 ����Ѵ�. ��� ������ ����� �������� ���� ������ ����.
	//Car Ŭ������ ����
	public static void printCars(List<Car> cars) {
		for(int i = 0; i < cars.size(); i++) {
			printCar(cars.get(i));
			System.out.println();
		}
	}
	
	//Car Ŭ������ ����
	public static void printCar(Car car) {
		System.out.print(car.getCarName() + " : ");
		for(int i = 0; i < car.getLocation(); i++) {
			System.out.print("-");
		}
	}

	//max�� ���� �ִ� �̵��Ÿ� ��
	public static int getMaxLocation(int max, Car car) {
		if(max < car.getLocation()) {
			max = car.getLocation();
		}
		return max;
	}
	
	//�� �ִ� �̵� �Ÿ� ���ϱ�
	public static int getMaxLocationWithList(List<Car> cars) {
		int max = 0;
		for(int i = 0; i < cars.size(); i++) {
			max = getMaxLocation(max, cars.get(i));
		}
		return max;
	}
	
	//����� �� Ŭ���� ���ϱ�
	public static List<Car> getWinnerName(int max, Car car, List<Car> winner) {
		if(max == car.getLocation()) {
			winner.add(car);
		}
		return winner;
	}
	
	public static void getWinner(List<Car> cars) {
		int max = getMaxLocationWithList(cars);
		List<Car> winner = new ArrayList<Car>();
		for(int i = 0; i < cars.size(); i++) {
			winner = getWinnerName(max, cars.get(i), winner);
		}
		printWinner(winner);
	}
	
	public static void printWinner(List<Car> winner) {
		for(int i = 0; i < winner.size(); i++) {
			System.out.print(winner.get(i).getCarName() + seperator(winner.size(), i + 1));
		}
		System.out.print("�� ���� ����߽��ϴ�.");
	}
	
	public static String seperator(int size, int compare) {
		if(size > compare) {
			return ", ";
		}
		return "";
	}
	
	
	
}
