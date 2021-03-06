import java.io.*;
import java.util.Scanner;

/**
 * The class creates an image in form of a greyscale image which is read in from
 * a file. It contains a method to crop the left upper half of the picture and
 * write it out again.
 * It also contains methods to quarter the resolution, rotate the image, and covert
 * the image into black and white. Each time a new picture file is created.
 *
 * @version 2015-10-19
 * @author Manfred Kerber and andrew cullinane
 */
public class PGMImage {
	private int width;
	private int height;
	private int maxShade;
	private String typeOfFile;
	private short[][] pixels;

	/**
	 * @param filename The name of a file that contains an image in pgm format of type P2.
	 * @throws IOException 
	 */
	public PGMImage(String filename) {
		// try since the file may not exist.
		try {
			// we read from the scanner s which is linked to the file filename.
			Scanner s = new Scanner(new File(filename));

			/*
			 * The field variables are assigned by reading in from a file. The file should
			 * start with something like P2 150 176 255
			 * 
			 * where P2 is the file type, 150 the width of the image, 176 the height, and
			 * 255 the maximal grey value. Then follow 150*176 grey values between 0 and
			 * 255.
			 */

			// We read the initial element that is in our case "P2"
			typeOfFile = s.next();
			// Next we read the width, the height, and the maxShade.
			width = s.nextInt();
			height = s.nextInt();
			maxShade = s.nextInt();
			// We initialize and read in the different pixels.
			pixels = new short[height][width];
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					pixels[i][j] = s.nextShort();
				}
			}
			// We finished reading and close the scanner s.
			s.close();
		} catch (IOException e) {
			// If the file is not found, an error message is printed,
			// and an empty image is created.
			System.out.println("File not found.");

			typeOfFile = "P2";
			width = 0;
			height = 0;
			maxShade = 0;
			pixels = new short[width][height];
		}
	}

	/**
	 * @return The width of the image.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return The height of the image.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return The maximal grey value of the image.
	 */
	public int getMaxShade() {
		return maxShade;
	}

	/**
	 * @return The file type of the image.
	 */
	public String getTypeOfFile() {
		return typeOfFile;
	}

	/**
	 * @return The matrix representing the pixels of the image.
	 */
	public short[][] getPixels() {
		return pixels;
	}

	/**
	 * The method crops the left upper half of an image.
	 * 
	 * @param filename
	 *            The filename of the file in which the cropped image should be
	 *            saved.
	 * @throws IOException 
	 */
	public void crop(String filename) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			// We write the file type to out.
			out.write(getTypeOfFile() + "\n");

			// We write the dimensions to out.
			out.write((getWidth() / 2) + " " + (getHeight() / 2) + "\n");

			// We write maximal number.
			out.write(getMaxShade() + "\n");

			byte counter = 0;
			for (int i = 0; i < getHeight() / 2; i++) {
				for (int j = 0; j < getWidth() / 2; j++) {
					out.write(getPixels()[i][j] + " ");
					counter++;
					if (counter == 15) {
						out.write("\n");
						counter = 0;
					}
				}
			}
			out.write("\n");
			// We close the file.
			out.close();
		} catch (IOException e) {
			// Errors are caught.
			System.out.println("File not found.");
		}
	}

	/**
	 * method to reduce the resolution of the image by a quarter
	 * @param filename of file to be generated by method
	 * @return int array of pixels and lower resolution image
	 * @throws IOException 
	 */
	
	public int[][] quarter(String filename) {

		//reduce height and width by 2 and make a new 2D array
		
		int newWidth = width / 2;
		int newHeight = height / 2;
		int[][] quarter = new int[newHeight][newWidth];

		try {
			//create file and write first lines (type of file, width, height, maximum shade)
			BufferedWriter outQuarter = new BufferedWriter(new FileWriter(filename));
			outQuarter.write(getTypeOfFile() + "\n");
			outQuarter.write(newWidth + " " + newHeight + "\n");
			outQuarter.write(getMaxShade() + "\n");

			//for loop to average 4x4 grid to reduce resolution
			//counter to keep track of image width
			//row and column used to make new array
			byte counter = 0;
			byte row = 0;
			byte column = 0;
			for (int i = 0; i < pixels.length - 1; i+=2) {
				for (int j = 0; j < pixels[i].length - 1; j+=2) {
					//add average value to new array
					quarter[row][column] = (int)Math.round((pixels[i][j] + pixels[i][j + 1] + pixels[i + 1][j] + pixels[i + 1][j + 1]) / 4.0);
					//add value to image file
					outQuarter.write(quarter[row][column] + " ");
					counter++;
					column++;
					//make new line when width has been reached
					if (counter == newWidth) {
						outQuarter.write("\n");
						counter = 0;
						column = 0;
					}
				}
				row++;
			}
			//add a new line and close file
			outQuarter.write("\n");
			outQuarter.close();

		//exception if file cannot be found
		} catch (IOException e) {
			System.out.println("File not found.");
		}
		return quarter;

	}
	
/**
 * method to rotate image right by 90 degrees
 * @param filename of file to be generated by method
 * @return int array of pixels and rotated image
 * @throws IOException 
 */
	public int[][] rotate(String filename) {

		//swap width with height values and create new array
		int newWidth = getHeight();
		int newHeight = getWidth();
		int[][] rotate = new int[newHeight][newWidth];

		try {
			//create file and write first lines (type of file, width, height, maximum shade)
			BufferedWriter outRotate = new BufferedWriter(new FileWriter(filename));
			outRotate.write(getTypeOfFile() + "\n");
			outRotate.write(newWidth + " " + newHeight + "\n");
			outRotate.write(getMaxShade() + "\n");
			
			// for loop to reassign pixels to rotated position
			//counter to keep track of image width
			byte counter = 0;
			for (int i = 0; i < newHeight; i++) {
				for (int j = 0; j < newWidth; j++) {
					//add value to new array
					rotate[i][j] = pixels[height - 1 - j][i];
					//add value to image file
					outRotate.write(rotate[i][j] + " ");
					counter++;
					//make new line when width has been reached
					if (counter == newWidth) {
						outRotate.write("\n");
						counter = 0;
					}
				}
			}
			
			//add a new line and close file
			outRotate.write("\n");
			outRotate.close();
		
		//exception if file cannot be found
		} catch (IOException e) {
			System.out.println("File not found.");
		}
		return rotate;

	}
	
/**
 * method to convert image to black and white (bw)
 * @param filename of file to be generated by method
 * @return int array of pixels and black and white image
 * @throws IOException 
 */
	public int[][] bw(String filename) {

		//create new array
		int[][] bwArray = new int[getHeight()][getWidth()];
		
		// find average grey value
		double sum = 0;
		int n = 0;
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				sum = sum + pixels[i][j];
				n++;
			}
		}

		double average = (sum / n);

		try {
			//create file and write first lines (type of file, width, height, maximum shade)
			BufferedWriter outBW = new BufferedWriter(new FileWriter(filename));
			outBW.write("P1 \n");
			outBW.write(getWidth() + " " + getHeight() + "\n");
			outBW.write("1" + "\n");

			//change pixel value according to average value;
			//counter to keep track of image width
			int counter = 0;
			for (int x = 0; x < pixels.length; x++) {
				for (int y = 0; y < pixels[x].length; y++) {
					counter++;
					//add value to new array
					//add value to image file
					if (pixels[x][y] <= average) {
						bwArray[x][y] = 1;
						outBW.write(bwArray[x][y] + " ");
					} else {
						bwArray[x][y] = 0;
						outBW.write(bwArray[x][y] + " ");
					}
					//make new line when width has been reached
					if (counter == width) {
						outBW.write("\n");
						counter = 0;
					}
				}
			}
			
			//add a new line and close file
			outBW.write("\n");
			outBW.close();

		//exception if file cannot be found
		} catch (IOException e) {
			System.out.println("File not found.");
		}
		return bwArray;
	}

	/*
	 * An example.
	 */
	public static void main(String[] args) {
		
	}
}
