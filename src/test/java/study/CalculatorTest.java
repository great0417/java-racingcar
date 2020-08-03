package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
	
	private List<Integer> numbers;
	private List<String> signs;
	String calculateValue="2 + 3 * 4 / 2";
	String[] split;
	
	
	@BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(2);
    }
	
	@BeforeEach
	void setUpSign()
	{
		signs = new ArrayList<>();
		signs.add("+");
		signs.add("*");
		signs.add("/");
	}
	
	
	@Test
	public int calculate()
	{
		int result = 0;
		for(int i = 0; i < signs.size(); i++)
		{
			switch (signs.get(i)) {
			case "+":
				result = add(numbers.get(0), numbers.get(1));
				removeNumbers(numbers, result);
				break;
			case "-":
				result = substract(numbers.get(0), numbers.get(1));
				removeNumbers(numbers, result);
				break;
			case "*":
				result = multiple(numbers.get(0), numbers.get(1));
				removeNumbers(numbers, result);
				break;
			case "/":
				result = divide(numbers.get(0), numbers.get(1));
				removeNumbers(numbers, result);
				break;
			default:
				break;
			}
		}
		return result;
		
		
	}
	
	//���� �� ���� �����ϰ�, ������� �� ������ ����
	@Test
	public static void removeNumbers(List<Integer> numbers, int result)
	{
		numbers.set(0, result);
		numbers.remove(1);
	}
		
	
	
	@Test
	public int add(int a, int b)
	{
		return a+b;
	}
	
	@Test
	public int substract(int a, int b)
	{
		return a-b;
	}
	@Test
	public int multiple(int a, int b)
	{
		return a*b;
	}
	@Test
	public int divide(int a, int b)
	{
		return a/b;
	}
	
	
	@Test
	public void splitTest()
	{
		String values="2 + 3 * 4 / 2";
		//assertThatIllegalArgumentException ����� ������ ���ϴ�.. �׽�Ʈ �ڵ��ʿ��� ��� �ۼ��ؾ� �ϴ��� �𸣰ڽ��ϴ�.
//		assertThatIllegalArgumentException().isThrownBy(() -> {
			Calculator.split(values);
//		});
	}
	
	@Test
	public void checkNumbersTest()
	{
		String values="j";
		//assertThatIllegalArgumentException ����� ������ ���ϴ�.. �׽�Ʈ �ڵ��ʿ��� ��� �ۼ��ؾ� �ϴ��� �𸣰ڽ��ϴ�.
//		assertThatIllegalArgumentException().isThrownBy(() -> {
			Calculator.checkNumbers(values);
//		});
	}
	
	
    //java.lang.NullPointerException ���� �׽�Ʈ�� ���� �ʽ��ϴ�...
	//Null���� ���µ� ������ ������ ���� �𸣰ڽ��ϴ�.
	@Test
//	@ValueSource(strings = {"2","+","3","*","4","/","2"})
//	public void pushTest(String values)
	public void pushTest()
	{
		String[] values = {"2","+","3","*","4","/","2"};
//		assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> { 
		Calculator.push(values);
//		}).withMessageMatching("");

	}
	
}

