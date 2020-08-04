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
	public void calculateWithSign() {
		
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Calculator.calculateWithSign(1, 2, "}");
		});
		
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Calculator.calculateWithSign(3, 0, "/");
		});
	}
	
	@Test
	public void calculateWithList() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Calculator.calculateWithList(numbers, signs);
		});
	}
	
	//���� �� ���� �����ϰ�, ������� �� ������ ����
	@Test
	public static void removeNumbers(List<Integer> numbers, int result) {
		numbers.set(0, result);
		numbers.remove(1);
	}
		
	@Test
	public void splitTest() {
		String values="2 + 3 * 4 / 2";
		assertThatIllegalArgumentException().isThrownBy(() -> {
			Calculator.split(values);
		});
	}
	
	@Test
	public void pushTest() {
		String[] values = {"2","+","3","*","4","/","2"};
		assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> { 
			Calculator.seperatePush(values, numbers, signs);;
		}).withMessageMatching("");

	}
	
}

