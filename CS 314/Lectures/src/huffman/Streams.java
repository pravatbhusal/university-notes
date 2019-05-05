package huffman;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * A lecture on Input and Output streams.
 * 
 * BitInputStream and BitOutputStream are used for .hf (Huffman) files.
 */
public class Streams {

	/* Definitions:
	 * 1. Byte: 8 bits of data
	 * 2. InputStream: Reads input data from a stream.
	 * 		- Ex: ByteArrayInputStream reads in an Array of Bytes 
	 * 		- Ex: BitInputStream reads individual Bits from a file
	 * 3. OutputStream: Outputs data into a stream (file).
	 * 		- Ex: BitOutputStream writes individual Bits into a file
	 */

	// a method to handle the input and output streams
	public static void main(String[] args) throws IOException {
		byteArrayInputStream();
		outputStream();
		bitInputStream();
		bitOutputStream();
	}

	// create a byte input stream for a String, using its Byte Array
	private static void byteArrayInputStream() throws IOException {
		String testData = "This is test data.";
		InputStream inStream = new ByteArrayInputStream(testData.getBytes());
		while(inStream.available() > 0) {
			/* read each byte of data, and each ASCII character takes 1 byte,
				so the entire output will be: This is test data. */
			System.out.print((char) inStream.read());
		}
		System.out.println();
	}

	// create an output stream for a custom file-type
	private static void outputStream() throws IOException {
		// we can create custom file types using OutputStream
		final String FILE_TYPE = "sy";
		OutputStream outStream = new FileOutputStream("test." + FILE_TYPE);

		// write "This is test data." to the file
		String testData = "This is test data.";
		outStream.write(testData.getBytes());

		// close output stream
		outStream.close();
	}

	// create a bit input stream for a file
	private static void bitInputStream() throws IOException {
		// read the test.sy file
		File inputFile = new File("test.sy");
		BitInputStream inputStream = new BitInputStream(inputFile);

		// read every bit of the file at a time
		System.out.print("The test.sy file as bits: ");
		int currentBit = inputStream.readBits(1);
		final int FINISHED_READING = -1;
		while(currentBit != FINISHED_READING) {
			// read each individual bit of the file
			System.out.print(currentBit);
			currentBit = inputStream.readBits(1);
		}
		// close the input stream
		inputStream.close();
	}

	// create a bit output stream for a file
	private static void bitOutputStream() throws IOException {
		// we can create custom file types using OutputStream
		final String FILE_TYPE = "sy";
		BitOutputStream outStream = new BitOutputStream("test." + FILE_TYPE);

		// write "This is test data." to the file
		String testData = "This is test data.";
		final int BITS_PER_ASCII_CHAR = 8;
		for(int charIndex = 0; charIndex < testData.length(); charIndex++) {
			/* the 2nd parameter of writeBits() is a base 10 integer, which
				writeBits will convert into bits when writing into the file */
			outStream.writeBits(BITS_PER_ASCII_CHAR, testData.charAt(charIndex));
		}
		// close output stream
		outStream.close();
	}
}
