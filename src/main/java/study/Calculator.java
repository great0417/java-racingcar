package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Calculator {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		List<String> signs = new ArrayList<>();

		System.out.println("���ڿ��� �Է����ּ��� ���ڿ� ��Ģ���� ���̿��� �� ���� ���ڿ��� �־��ּ���");
		Scanner scanner = new Scanner(System.in);

		String calculate = scanner.nextLine();
		String[] split = split(calculate);
		
		seperatePush(split, numbers, signs);
		int result = calculateWithList(numbers, signs);
		System.out.println("����� : " + result);
		
	}
	
	//��Ģ���� ������
	public static int calculateWithSign(int num1, int num2, String sign) {
		if("+".equals(sign))
			return num1 + num2;
		else if("-".equals(sign))
			return num1 - num2;
		else if("*".equals(sign))
			return num1 * num2;
		else 
			return num1 / num2;
	}
	
	public static int calculateWithList(List<Integer>numbers, List<String>signs) {
		int result = 0;
		for(int i =0; i < signs.size(); i++)
		{
			result = calculateWithSign(numbers.get(0), numbers.get(1), signs.get(i));
			removeNumbers(numbers, result);
		}
		return result;
	}
	
	//���� �� ���� �����ϰ�, ������� �� ������ ����
	public static void removeNumbers(List<Integer> numbers, int result) {
		numbers.set(0, result);
		numbers.remove(1);
	}
		
	//���ڿ� �������� �и��ؼ� ����
	public static void seperatePush(String[] values, List<Integer>numbers, List<String>signs) {
		for(int i = 0; i < values.length; i++) {
			pushSign(values[i], signs);
			pushNumber(values[i], numbers);
		}
	}
	
	//���������� ��� signs ����Ʈ�� �־���
	public static void pushSign(String values, List<String>signs){
		if("+".equals(values) || "-".equals(values) || "*".equals(values) || "/".equals(values))
			signs.add(values);
	}
	
	//��Ģ������ �ƴҰ�� numbers ����Ʈ�� �־���
	public static void pushNumber(String values, List<Integer>numbers)
	{
		if(!("+".equals(values) || "-".equals(values) || "*".equals(values) || "/".equals(values)))
			numbers.add(Integer.parseInt(values));
	}
	
	
	
	//���� ���ڿ��� �� ���� ���ڷ� �и��Ϸ��� String Ŭ������ split(" ") �޼ҵ带 Ȱ���Ѵ�.
	public static String[] split(String question) {
		return question.split(" ");
	}	
}
