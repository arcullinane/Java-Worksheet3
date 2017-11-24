/**
 * Program to sort integers stored in an array using the selection sort
 * algorithm
 * 
 * @author andrew cullinane
 */
public class SelectionSort {

	/**
	 * Implementation of the selection sort algorithm
	 * 
	 * @param numbers as an int array
	 * @return an integer array of sorted numbers smallest to largest
	 */
	public static int[] selectionSort(int[] numbers) {

		// double for loop to iterate over next position in array to be sorted (i)
		// and to iterate over remaining numbers in the array (j)

		for (int i = 0; i < numbers.length; i++) {
			int index = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[index]) {
					index = j;
				}
			}

			// swap numbers if a smaller number is found
			int smallestNumber = numbers[index];
			numbers[index] = numbers[i];
			numbers[i] = smallestNumber;

		}

		return numbers;

	}

}
