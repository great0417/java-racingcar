package racingEasy;

import java.util.Random;
import java.util.Scanner;

public class RacingEasy {
	public static void main(String[] args) {
		System.out.println("�ڵ��� ����� �� �� �ΰ���?");
		Scanner scanner = new Scanner(System.in);
		int carQuantity = scanner.nextInt();
		int cars[] = new int[carQuantity];
		System.out.println("�õ��� ȸ���� �� ȸ �ΰ���?");
		int reps = scanner.nextInt();
		
		racing(cars, reps);
		
	}
	
	public static void racing(int[] cars, int reps) {
		for(int i = 1; i <= reps; i++) {
			cars = runOrStopWithRandom(cars);
			System.out.println(i + "��°");
			printCars(cars);
			System.out.println();
			System.out.println();
		}
	}
	
	//�����ϴ� ������ ���� 4�̻��� ����̴�.
	public static boolean runOrStopCondition(int num) {
		if(4 <= num && num <= 9) {
			return true;
		}
		return false;
	}
	
	//�ڵ����� ���ǿ� ���� ���� �Ǵ� ���� �� �ִ�.
	public static int runOrStop(int condition, int car) {
		if(runOrStopCondition(condition)) {
			return ++car;
		}
		return car;
	}
	
	// 0���� 9 ���̿��� random ���� ���� �� ���ǿ� ���� ����
	public static int[] runOrStopWithRandom(int[] cars) {
		Random random = new Random();
		for(int i = 0; i < cars.length; i++) {
			 cars[i] = runOrStop(random.nextInt(10), cars[i]);
		}
		return cars;
	}
	
	//�ڵ����� ���¸� ȭ�鿡 ����Ѵ�. ��� ������ ����� �������� ���� ������ ����.
	public static void printCars(int[] cars) {
		for(int i = 0; i < cars.length; i++) {
			printCar(cars[i]);
			System.out.println();
		}
	}
	
	public static void printCar(int car) {
		for(int i = 0; i < car; i++) {
			System.out.print("-");
		}
	}
	
}
