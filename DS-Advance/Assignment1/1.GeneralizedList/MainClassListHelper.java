import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClassListHelper {
	@SuppressWarnings("rawtypes")
	public static void main(String args[]) {

		//String input = "(53,(8333,3),(62,(21,52),46),87)";
		System.out.println("Please enter string should contain in ( ) and seperated with , ");
		String input = readString();
		GeneralizedList<Integer> list = new GeneralizedList<Integer>(input);
		GeneralizedList temp = list;
		System.out.println("\n Output(To String)is  -----");
		GeneralizedList.traverse(temp);
		Integer sum = GeneralizedList.sum(temp);
		System.out.println("\nSum is " + sum);
		Integer max = GeneralizedList.max(temp);
		System.out.println("\nMax is " + max);
		System.out.println("Enter data to be search");
		Integer dataSearch = readData();
		boolean isFound = GeneralizedList.find(temp, dataSearch);
		String show = "Available";
		if (!isFound)
			show = "Not " + show;
		System.out.println("Data " + dataSearch + " is " + show);
	}

	private static int readData() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int data = 0;
		do {
			try {
				data = scanner.nextInt();
			} catch (InputMismatchException io) {
				System.out.println("Please enter correct no");
				continue;
			}
			if (data < 0) {
				System.out.println("Please enter correct no");
				continue;
			}
			break;
		} while (true);
		return data;
	}

	public static String readString() {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		String input = "";
		do {
			try {
				input = bufferedReader.readLine();
			} catch (IOException io) {
				System.out.println("Error occured please enter input again");
				continue;
			}

			break;
		} while (true);
		return input;
	}
}
