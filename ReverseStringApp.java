import java.util.Scanner;

public class ReverseStringApp {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String input;
		
		try {
			System.out.println("Input string:");
			input = in.nextLine();
		} finally {
			in.close();
		}
		
		int size = input.length();
		if (size < 1) {
			System.out.println("Empty string provided!\n");
		}
		
		ReverseString str = new ReverseString(input, size);
		System.out.println(String.format("Reverse string: %s", str.reverseString()));
	}
}

class ReverseString {
	private String inputString = "";
	private int inputStringSize = 0;
	
	public ReverseString(String input, int size) {
		this.inputString = input;
		this.inputStringSize = size;
	}
	
	public String reverseString () {
		
		// initialize char array with size of input string
		char[] c = new char[inputStringSize];
		System.out.println(String.format("Initialized char array of size %d", inputStringSize));
		
		System.out.println("inputStringSize/2d = " + inputStringSize/2d);
		double until = Math.ceil(inputStringSize/2d);
		System.out.println("until = " + until);
		// reverse chars		 
		for (int i=0; i<until; i++) {
			System.out.println(String.format("i=%d, reverse=%d", i, inputStringSize-1-i));
			
			char charAtReverseLoc = inputString.charAt(inputStringSize - 1 - i);			
			c[inputStringSize - 1 - i] = inputString.charAt(i);
			c[i] = charAtReverseLoc;
		}

		String reverse = String.valueOf(c);
		return reverse;
	}

}
