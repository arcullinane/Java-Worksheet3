import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests for SelectionSort
 * @author andrew cullinane
 */
public class SelectionSortTest {

	// test positive numbers
	@Test
	public void test1() {
		int[] testArray1 = new int[] {5, 3, 16, 21, 1};
		String testString1 = "";
		for (int number : SelectionSort.selectionSort(testArray1)) {
			testString1 = testString1 + number + ", ";
		}
		assertEquals("1, 3, 5, 16, 21, ", testString1);
	}

	// test negative numbers
	@Test
	public void test2() {
		int[] testArray2 = new int[] {-5, -3, -16, -21, -1};
		String testString2 = "";
		for (int number : SelectionSort.selectionSort(testArray2)) {
			testString2 = testString2 + number + ", ";
		}
		assertEquals("-21, -16, -5, -3, -1, ", testString2);
	}

	//tests for mixed negative and positive numbers;
	@Test
	public void test3() {
		int[] testArray3 = new int[] {5, 3, 0, -3, -5};
		String testString3 = "";
		for (int number : SelectionSort.selectionSort(testArray3)) {
			testString3 = testString3 + number + ", ";
		}
		assertEquals("-5, -3, 0, 3, 5, ", testString3);
	}
	
	//test repeated numbers
	@Test
	public void test4() {
		int[] testArray4 = new int[] {-1, 1, 0, 4, -1, 1, 0};
		String testString4 = "";
		for (int number : SelectionSort.selectionSort(testArray4)) {
			testString4 = testString4 + number + ", ";
		}
		assertEquals("-1, -1, 0, 0, 1, 1, 4, ", testString4);
	}
	
	// test single number
	@Test
	public void test5() {
		int[] testArray5 = new int[] {1};
		String testString5 = "";
		for (int number : SelectionSort.selectionSort(testArray5)) {
			testString5 = testString5 + number + ", ";
		}
		assertEquals("1, ", testString5);
	}
	
	// test empty array
	@Test
	public void test6() {
		int[] testArray6 = new int[] {};
		String testString6 = "";
		for (int number : SelectionSort.selectionSort(testArray6)) {
			testString6 = testString6 + number + ", ";
		}
		assertEquals("", testString6);
	}
}
