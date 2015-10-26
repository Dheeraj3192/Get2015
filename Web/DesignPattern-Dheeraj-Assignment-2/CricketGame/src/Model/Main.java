package Model;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		int choice;
		boolean flag;
		Scanner scanner = new Scanner(System.in);
		do {
			flag = false;
			System.out
					.println("Enter Choice\n1. One Day\n2. Test\n3. 20-20\n4. Exit");

			while (!scanner.hasNextInt()) {
				System.out.println("Enter Valid Integer");
				scanner.next();
			}
			choice = scanner.nextInt();

			Game game = null;
			switch (choice) {
			case 1:
				game = new OneDay();
				break;

			case 2:
				game = new Test();
				break;

			case 3:
				game = new TwentyTwenty();
				break;

			case 4:
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Enter Correct Choice");
				flag = true;
			}
			if (flag) {
				continue;
			}

			game.play();
		} while (true);

	}
}
