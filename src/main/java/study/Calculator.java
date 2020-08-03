package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Calculator {

	
	/***
	 * 
	 *  ����ڰ� �Է��� ���ڿ� ���� ���� ��Ģ������ ������ �� �ִ� ���⸦ �����ؾ� �Ѵ�.
		�Է� ���ڿ��� ���ڿ� ��Ģ ���� ���̿��� �ݵ�� �� ���� ���ڿ��� �ִٰ� �����Ѵ�.
		�������� ��� ��� ���� ������ �������� ������ �����Ѵ�.
		���ڿ� ����� ��Ģ������ ��� �켱������ �ƴ� �Է� ���� ���� ��� ������ �����ȴ�. ��, ���п����� ����, �������� ����, ���� ���� ���� ����ؾ� ������ �̸� �����Ѵ�.
		���� ��� 
		2 + 3 * 4 / 2
		�� ���� ���ڿ��� �Է��� ��� 2 + 3 * 4 / 2 ���� ����� 10�� ����ؾ� �Ѵ�.
		2+3*4/2
		
		��Ģ���� ��ȣ�� �ƴ� ��� IllegalArgumentException throw
		��Ģ ������ ��� �����ϴ� ��� ����
		�ݺ����� ������ ã�� �ݺ������� �����Ѵ�.
				
		
	 * 
	 */
	
	private static List<Integer> numbers;
	private static List<String> signs;
	
	public static void main(String[] args) {
		
		System.out.println("���ڿ��� �Է����ּ��� ���ڿ� ��Ģ���� ���̿��� �� ���� ���ڿ��� �־��ּ���");
		Scanner scanner = new Scanner(System.in);
		numbers = new ArrayList<>();
		signs = new ArrayList<>();
		String calculate = scanner.nextLine();
		String[] split = split(calculate);
		push(split);
		int result = calculate(numbers, signs);
		System.out.println("����� : " + result);
		
	}
	
	
	
	
	public static int calculate(List<Integer>numbers, List<String>signs)
	{
		int result = 0;
		for(int i = 0; i < signs.size(); i++)
		{
			switch (signs.get(i)) {
			case "+":
				result = add(numbers.get(0), numbers.get(1));
				break;
			case "-":
				result = substract(numbers.get(0), numbers.get(1));
				break;
			case "*":
				result = multiple(numbers.get(0), numbers.get(1));
				break;
			case "/":
				result = divide(numbers.get(0), numbers.get(1));
				break;
			default:
				break;
			}
			removeNumbers(numbers, result);
		}
		return result;
	}
	
	//���� �� ���� �����ϰ�, ������� �� ������ ����
	public static void removeNumbers(List<Integer> numbers, int result)
	{
		numbers.set(0, result);
		numbers.remove(1);
	}
	
	
	
	//������ ��� signs��, �ƴ� ��� numbers ����Ʈ�� ����
	public static void push(String[] values)
	{
		for(int i = 0; i < values.length; i++)
		{
			switch (values[i]) {
			case "+":
				signs.add(values[i]);
				break;
			case "-":
				signs.add(values[i]);
				break;
			case "*":
				signs.add(values[i]);
				break;
			case "/":
				signs.add(values[i]);
				break;
			default:
				if(checkNumbers(values[i]))
				{
					numbers.add(Integer.parseInt(values[i]));
				}
				break;
			}
		}
	}
		
	public static boolean checkNumbers(String value)
	{
		if(value == null)
		{
			return false;
		}
		
		try
		{
			@SuppressWarnings("unused")
			int check = Integer.parseInt(value);
			return true;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
	
	public static int add(int a, int b)
	{
		return a+b;
	}
	public static int substract(int a, int b)
	{
		return a-b;
	}
	public static int multiple(int a, int b)
	{
		return a*b;
	}
	public static int divide(int a, int b)
	{
		return a/b;
	}
	
	
	
	//�Է� ���� null�̰ų� �� ���� ������ ��� IllegalArgumentException throw
	//���� ���ڿ��� �� ���� ���ڷ� �и��Ϸ��� String Ŭ������ split(" ") �޼ҵ带 Ȱ���Ѵ�.
	public static String[] split(String question)
	{
		String[] values = null;
		try
		{
			values =question.split(" ");
			return values;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		return values;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
