import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for StarRating class
 * @author andrew cullinane
 */

public class StarRatingTest {

    @Rule public final ExpectedException exception = ExpectedException.none();

	//test "crap"
	@Test
	public void test1() {
		double rating = 2.0;
		String actual = StarRating.interpret(rating);
		assertEquals("CRAP", actual);
	}
	
	//test "OK" at upper bounds
	@Test
	public void test2() {
		double rating = 4.499999;
		String actual = StarRating.interpret(rating);
		assertEquals("OK", actual);
	}
	
	//test "excellent"
	@Test
	public void test3() {
		double rating = 4.5;
		String actual = StarRating.interpret(rating);
		assertEquals("EXCELLENT", actual);
	}	
	
	//test "[HAS ONLY ONE REVIEW]"
	@Test
	public void test4() {
		double rating = 5.0;
		String actual = StarRating.interpret(rating);
		assertEquals("[HAS ONLY ONE REVIEW]", actual);
	}	
	
	//test exception case (<1)
	@Test
	public void test5() {
		double rating = 0.99999;
        exception.expect(IllegalArgumentException.class);
        StarRating.interpret(rating);
	}
	
	//test exception case (>5)
	@Test
	public void test6() {
		double rating = 5.000000000000001;
        exception.expect(IllegalArgumentException.class);
        StarRating.interpret(rating);
	}
}
