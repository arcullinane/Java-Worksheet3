import java.util.Arrays;

/**
 * Program to calculate minimum, maximum, mean, and median for an array of numbers.
 * findN method used to calculate the length of a 2D array and throw exception if array is empty.
 * makeSingleArray method used to make a single 1D array from a 2D array. Used for median method
 * 
 * @author andrew cullinane
 */

public class ArrayMethods {

	/**
	 * method to calculate the length of a 2d array
	 * tests if array is empty.
	 * @param a 2d array of doubles
	 * @return the length of a 2d array as an int
	 * @throws IllegalArgumentException if original array is empty
	 */
	public static int findN(double[][] a) {

		int n = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				n++;
			}
		}
			
		if (n == 0) {
			throw new IllegalArgumentException();
		}
		
		return n;

	}
	
	/**
	 * method to give minimum value form an array
	 * @param a 2d array of doubles
	 * @return minimum value in array given as a double
	 */
	public static double min(double[][] a) {

		//array length + test
		findN(a);
		
		double minValue = a[0][0];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] < minValue) {
					minValue = a[i][j];
				}
			}
		}

		return minValue;

	}

	/**
	 * method to give maximum value form an array
	 * @param a 2d array of doubles
	 * @return maximum value in array given as a double
	 */
	public static double max(double[][] a) {

		//array length + test
		findN(a);
		
		double maxValue = a[0][0];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] > maxValue) {
					maxValue = a[i][j];
				}
			}
		}

		return maxValue;

	}

	/**
	 * method to give the mean value from an array
	 * @param a a 2d array of doubles
	 * @return mean value of array given as a double
	 */
	public static double mean(double[][] a) {

		//array length + test
		int n = findN(a);
		
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				sum += a[i][j];
			}
		}

		return sum / n;

	}

	/**
	 * method to make a single ordered array from a 2d array
	 * used in median method
	 * @param a 2d array of doubles
	 * @return a 1d array of sorted doubles
	 */
	public static double[] makeSingleArray(double[][] a) {
		
		// array length + test
		int n = findN(a);
		
		// make new array and fill it with all values from original array
		double[] b = new double[n];
		int counter = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				b[counter] = a[i][j];
				counter++;
			}
		}
		
		// sort array from lowest to highest value
		Arrays.sort(b);
		
		return b;
		
	}
	
	/**
	 * method to give median value from an array
	 * 
	 * @param a 2d array of doubles
	 * @return median value of array given as a double
	 */
	public static double median(double[][] a) {

		//array length + test
		int n = findN(a);
		
		//make single array and sort.
		double [] c =  makeSingleArray(a);
		
		// calculate median 
		// - if not divisible by 2, find middle value
		// - else calculate mean of values around mid-point
		if (n % 2 != 0) {
			int middleIndex = (n / 2);
			return c[middleIndex];
		} else {
			int upperIndex = (n / 2);
			int lowerIndex = upperIndex-1;
			return ((c[lowerIndex] + c[upperIndex]) / 2);
		}
	}
}
