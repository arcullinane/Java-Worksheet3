import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Program to give numbers within a given range that contain a specified number
 * @author andrew cullinane
 */
public class Contains {

	/**
	 * Method to give numbers in range containing a specified number
	 * @param from - given as int (inclusively)
	 * @param to  - given as an int (exclusively)
	 * @param containedDigit - given as an int is the number that must be contained within the result.
	 * @return an ArrayList of integers within the range and containing the specified digit
	 */
	public static ArrayList<Integer> allIntegersWith(int from, int to, int containedDigit) {

		// declare ArrayList
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		// iterate through all numbers in range
		for (int i = from; i < to; i++) {
			// convert int to string and store in temporary variable
			String tempString = Integer.toString(i);
			// define pattern to be tested
			Pattern p = Pattern.compile("[" + containedDigit + "]+");
			Matcher m = p.matcher(tempString);
			// if digit is found add it to ArrayList
			if (m.find()) {
				numbers.add(i);
			}
		}
		return numbers;
	}
}
