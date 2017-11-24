import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
 * Tests for Contains class
 * @author andrew cullinane
 */

public class ContainsTest {

	// test positive numbers
	@Test
	public void test1() {
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19));
		ArrayList<Integer> actual = Contains.allIntegersWith(0, 20, 1);
		assertEquals(expected, actual);
	}

	// test negative numbers
	@Test
	public void test2() {
		ArrayList<Integer> expected = new ArrayList<Integer>(	Arrays.asList(-19, -18, -17, -16, -15, -14, -13, -12, -11, -10, -1));
		ArrayList<Integer> actual = Contains.allIntegersWith(-20, 0, 1);
		assertEquals(expected, actual);
	}

	// test mixed negative and positive numbers
	@Test
	public void test3() {
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(-5, 5, 15, 25));
		ArrayList<Integer> actual = Contains.allIntegersWith(-6, 26, 5);
		assertEquals(expected, actual);
	}

	// test inclusive / exclusive bounds
	@Test
	public void test4() {
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(299, 302, 312));
		ArrayList<Integer> actual = Contains.allIntegersWith(299, 320, 2);
		assertEquals(expected, actual);
	}

	// test an output with no numbers
	@Test
	public void test5() {
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList());
		ArrayList<Integer> actual = Contains.allIntegersWith(2, 9, 1);
		assertEquals(expected, actual);
	}
	
	// test equal from and to values.
	@Test
	public void test6() {
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList());
		ArrayList<Integer> actual = Contains.allIntegersWith(1, 1, 1);
		assertEquals(expected, actual);
	}
	
}
