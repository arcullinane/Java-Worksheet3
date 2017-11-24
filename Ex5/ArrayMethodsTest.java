import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for ArrayMethods
 * 
 * @author andrew cullinane
 */
public class ArrayMethodsTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	private final static double EPSILON = 1e-6;

	// test findN method
	@Test
	public void test1() {
		double[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
		int expectedN = 6;
		assertEquals(expectedN, ArrayMethods.findN(a));
	}

	// test empty array
	@Test
	public void test2() {
		double[][] a = { {} };
		exception.expect(IllegalArgumentException.class);
		ArrayMethods.findN(a);
	}

	// test makeSingleArray method
	@Test
	public void test3() {
		double[][] a = { { 6, 5, 1 }, { 4, 2, 3 } };
		double[] expected = new double[] { 1, 2, 3, 4, 5, 6 };
		assertArrayEquals(expected, ArrayMethods.makeSingleArray(a), EPSILON);
	}

	// Test positive numbers (even number of values)

	@Test
	public void test4() {
		double[][] a = new double[][] { { 10, 20, 30 }, { 40, 50, 60 } };

		int expectedN = 6;
		double expectedMin = 10;
		double expectedMax = 60;
		double expectedMean = 35;
		double expectedMedian = 35;

		assertEquals(expectedN, ArrayMethods.findN(a));
		assertEquals(expectedMin, ArrayMethods.min(a), EPSILON);
		assertEquals(expectedMax, ArrayMethods.max(a), EPSILON);
		assertEquals(expectedMean, ArrayMethods.mean(a), EPSILON);
		assertEquals(expectedMedian, ArrayMethods.median(a), EPSILON);
	}

	// Test negative numbers (odd number of values)
	@Test
	public void test5() {
		double[][] a = new double[][] { { -10, -20, -30 }, { -40, -50 } };

		int expectedN = 5;
		double expectedMin = -50;
		double expectedMax = -10;
		double expectedMean = -30;
		double expectedMedian = -30;

		assertEquals(expectedN, ArrayMethods.findN(a));
		assertEquals(expectedMin, ArrayMethods.min(a), EPSILON);
		assertEquals(expectedMax, ArrayMethods.max(a), EPSILON);
		assertEquals(expectedMean, ArrayMethods.mean(a), EPSILON);
		assertEquals(expectedMedian, ArrayMethods.median(a), EPSILON);
	}

	// test mixed negative and positive numbers (multiple "rows")
	@Test
	public void test6() {
		double[][] a = new double[][] { { 2.3, 4.5 }, { -4.1, -5.6 }, { 1.4, -4.0 } };

		int expectedN = 6;
		double expectedMin = -5.6;
		double expectedMax = 4.5;
		double expectedMean = -0.916666;
		double expectedMedian = -1.3;

		assertEquals(expectedN, ArrayMethods.findN(a));
		assertEquals(expectedMin, ArrayMethods.min(a), EPSILON);
		assertEquals(expectedMax, ArrayMethods.max(a), EPSILON);
		assertEquals(expectedMean, ArrayMethods.mean(a), EPSILON);
		assertEquals(expectedMedian, ArrayMethods.median(a), EPSILON);
	}

}
