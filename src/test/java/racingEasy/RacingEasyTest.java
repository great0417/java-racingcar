package racingEasy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import static racingEasy.RacingEasy.runOrStopCondition;
import static racingEasy.RacingEasy.runOrStop;
public class RacingEasyTest {

	@Test
	public void 전진또는멈춤() {
		assertThat(runOrStopCondition(3)).isEqualTo(false);
		assertThat(runOrStopCondition(9)).isEqualTo(true);
		assertThat(runOrStopCondition(10)).isEqualTo(false);
	}
	
	@Test
	public void 자동차전진()
	{
		assertThat(runOrStop(4, 1)).isEqualTo(2);
	}
	
	@Test
	public void 자동차멈춤()
	{
		assertThat(runOrStop(2, 3)).isEqualTo(3);
	}
	
}
