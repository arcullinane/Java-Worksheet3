import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

/**
 * Tests for PGMImage class
 * @author andrew cullinane
 */
public class PGMImageTest {

	// test getters
	@Test
	public void test1() {
		PGMImage test1 = new PGMImage("gradient.pgm");

		int expectedWidth = 16;
		int expectedHeight = 16;
		int expectedMaxShade = 255;
		String expectedTypeOfFile = "P2";

		assertEquals(expectedWidth, test1.getWidth());
		assertEquals(expectedHeight, test1.getHeight());
		assertEquals(expectedMaxShade, test1.getMaxShade());
		assertEquals(expectedTypeOfFile, test1.getTypeOfFile());
	}

	// test crop method
	// can't use assertArrayEquals because the crop method given is a void return type.
	
	@Test
	public void test2() {
		PGMImage test2 = new PGMImage("gradient.pgm");
		int expectedWidth = test2.getWidth() /2;
		int expectedHeight = test2.getHeight() /2;
		
		test2.crop("gradientCropped.pgm");
		PGMImage cropTest = new PGMImage("gradientCropped.pgm");
		
		assertEquals(expectedWidth, cropTest.getWidth());
		assertEquals(expectedHeight, cropTest.getHeight());
			
	}

	// test quarter method
	@Test
	public void test3() {
		PGMImage test3 = new PGMImage("gradient.pgm");
		int expectedWidth = test3.getWidth() / 2;
		int expectedHeight = test3.getHeight() / 2;
		int [][] expectedArray = {{9, 11, 13, 15, 17, 19, 21, 23 },
										{41, 43, 45, 47, 49, 51, 53, 55 },
										{73, 75, 77, 79, 81, 83, 85, 87 },
										{105, 107, 109, 111, 113, 115, 117, 119 },
										{137, 139, 141, 143, 145, 147, 149, 151 },
										{169, 171, 173, 175, 177, 179, 181, 183 },
										{201, 203, 205, 207, 209, 211, 213, 215 },
										{233, 235, 237, 239, 241, 243, 245, 247 }};
	
        int[][] actualArray = test3.quarter("gradientQuartered.pgm");
		PGMImage quarterTest = new PGMImage("gradientQuartered.pgm");

		assertEquals(expectedWidth, quarterTest.getWidth());
		assertEquals(expectedHeight, quarterTest.getHeight());
        assertArrayEquals(expectedArray, actualArray);

	}

	// test rotate method
	@Test
	public void test4() {
		PGMImage test4 = new PGMImage("gradient.pgm");
		int[][] expectedArray = { {240, 224, 208, 192, 176, 160, 144, 128, 112, 96, 80, 64, 48, 32, 16, 0 },
										{241, 225, 209, 193, 177, 161, 145, 129, 113, 97, 81, 65, 49, 33, 17, 1 },
										{242, 226, 210, 194, 178, 162, 146, 130, 114, 98, 82, 66, 50, 34, 18, 2 },
										{243, 227, 211, 195, 179, 163, 147, 131, 115, 99, 83, 67, 51, 35, 19, 3 },
										{244, 228, 212, 196, 180, 164, 148, 132, 116, 100, 84, 68, 52, 36, 20, 4 },
										{245, 229, 213, 197, 181, 165, 149, 133, 117, 101, 85, 69, 53, 37, 21, 5 },
										{246, 230, 214, 198, 182, 166, 150, 134, 118, 102, 86, 70, 54, 38, 22, 6 },
										{247, 231, 215, 199, 183, 167, 151, 135, 119, 103, 87, 71, 55, 39, 23, 7 },
										{248, 232, 216, 200, 184, 168, 152, 136, 120, 104, 88, 72, 56, 40, 24, 8 },
										{249, 233, 217, 201, 185, 169, 153, 137, 121, 105, 89, 73, 57, 41, 25, 9 },
										{250, 234, 218, 202, 186, 170, 154, 138, 122, 106, 90, 74, 58, 42, 26, 10 },
										{251, 235, 219, 203, 187, 171, 155, 139, 123, 107, 91, 75, 59, 43, 27, 11 },
										{252, 236, 220, 204, 188, 172, 156, 140, 124, 108, 92, 76, 60, 44, 28, 12 },
										{253, 237, 221, 205, 189, 173, 157, 141, 125, 109, 93, 77, 61, 45, 29, 13 },
										{254, 238, 222, 206, 190, 174, 158, 142, 126, 110, 94, 78, 62, 46, 30, 14 },
										{255, 239, 223, 207, 191, 175, 159, 143, 127, 111, 95, 79, 63, 47, 31, 15 } };
		
		int[][] actualArray = test4.rotate("gradientRotated.pgm");
		
		assertArrayEquals(expectedArray, actualArray);

	}

	// test bw method
	@Test
	public void test5() {
		PGMImage test5 = new PGMImage("gradient.pgm");
		int [][] expectedArray = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
									{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
									{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
									{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
									{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
									{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
									{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
									{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
									{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
									{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
									{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
									{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
									{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
									{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
									{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
									{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
		
		int[][] actualArray = test5.bw("gradientBW.pgm");
		assertArrayEquals(expectedArray, actualArray);
	}

	// test file not found exception
	@Test
	public void test6() {
		// gets console text
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		// tries to open and crop not present file
		PGMImage test6 = new PGMImage("missing.pgm");
		test6.crop("missingCrop.pgm");

		// tests if console says "File not found." as expected
		assertEquals("File not found.\n", outContent.toString());
	}
}
