public class MainClass {

	public static void main(String[] args) {
		java.util.Scanner scanner = null;
		int result = -1;
		TruthTableGenerator truthTableGenerator = null;
		try {
			String choice;
			do {
				System.out.println("Enter a String");
				scanner = new java.util.Scanner(System.in);
				/* input will contain infix expression */
				String input = scanner.next();
				/* converting whole expression to lower case */
				input = input.toLowerCase();
				truthTableGenerator = new TruthTableGenerator();
				result = truthTableGenerator.truthTableGenerator(input);
				if(result == 1)
					System.out.println("Successfully created");
				else if(result == 0)
					System.out.println("String is empty or null");
				else if(result == -1)
					System.out.println("Invalid expression");
				else
					System.out.println("Some problem occcurred");
				System.out.println("Press Y ot y to continue and any other key to exit");
				choice = scanner.next();
				if(!(choice.charAt(0) == 'Y' || choice.charAt(0) == 'y')) {
					System.out.println("System Exit");
					System.exit(0);
				}
			} while(true);
		} catch(Exception e) {
			System.out.println("Problem Occured");
			scanner.close();
		}
	}
}
