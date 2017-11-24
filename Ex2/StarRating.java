/**
 * Program to translate rating cartoon into text output
 * 
 * @author andrew cullinane
 */

public class StarRating {

	/**
	 * method to translate rating into text
	 * 
	 * @param rating start rating given as a double
	 * @return a string relating to star rating
	 * @throws IllegalArgumentException
	 */
	public static String interpret(double rating) {

		// declare output variable and initialise
		String textOutput = "";

		// if statements to translate rating
		// throws exception if out of bounds

		if (rating >= 1 && rating < 4) {
			textOutput = "CRAP";
		} else if (rating >= 4 && rating < 4.5) {
			textOutput = "OK";
		} else if (rating >= 4.5 && rating < 5) {
			textOutput = "EXCELLENT";
		} else if (rating == 5) {
			textOutput = "[HAS ONLY ONE REVIEW]";
		} else if (rating > 5 || rating < 1) {
			throw new IllegalArgumentException();
		}

		return textOutput;

	}

}
