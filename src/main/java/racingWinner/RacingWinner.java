package racingWinner;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class RacingWinner {
	
	public static void main(String[] args) {
		System.out.println("������ �ڵ��� �̸��� �Է��ϼ���(�̸��� ��ǥ(,)�� �������� ����).");
		Scanner scanner = new Scanner(System.in);
		String carsName = scanner.nextLine();
		
		String[] carsNameArray = carsName.split(",");
		if(!MakeCar.makeCarsCondition(carsNameArray)) {
			System.out.println("������ �ڵ��� �̸��� 5�ڸ� �ʰ��� �� �����ϵ�.");
			return;
		}
		
		List<Car> cars = MakeCar.makeCars(carsNameArray);
		System.out.println(cars.size());
		System.out.println("�õ��� ȸ���� �� ȸ �ΰ���?");
		int reps = scanner.nextInt();
		RunOrStop.racing(cars, reps);
		RunOrStop.getWinner(cars);
		
	}
	
}




	