import java.util.Scanner;

public class ScannerApp {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		try {
			System.out.println("Enter Employee Name:");
			String empName = input.nextLine();
			System.out.println("Enter ID:");
			Integer empId = input.nextInt();
			
			System.out.println(String.format("%s has the id %d", empName, empId));
		} finally {
			input.close();
		}
	}
}

