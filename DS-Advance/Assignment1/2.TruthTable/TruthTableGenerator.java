import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class TruthTableGenerator {

	public int truthTableGenerator(String input) {

		try {

			if (input == null || input.length() == 0) {
				return 0;
			}
			if (Validation.isExpression(input)) {
				input = furnish(input);

				if (Validation.isExpression(input)) {
					String inputPostfix = postfixConvertor(input);
					System.out.println("Postfix Equivalent : " + inputPostfix);

					evalPostfix(inputPostfix);
				} else {
					return -1;
				}
				return 1;
			} else
				return -1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -2;
		}
	}

	private String furnish(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '~') {
				if (input.charAt(i + 1) == '~') {
					if (i == 0) {
						input = input.substring(i + 2, input.length());
						i = -1;
					} else
						input = input.substring(0, i)
								+ input.substring(i + 2, input.length());
				}
			}
		}
		System.out.println("Furnished Expression : " + input);
		return input;
	}

	private Set<Character> countletters(String inputPostfix) {

		Set<Character> letterSet = new TreeSet<Character>();

		char[] chars = inputPostfix.toCharArray();

		for (char c : chars) {
			if (Character.isLetter(c))
				letterSet.add(c);
		}

		return letterSet;
	}

	private void evalPostfix(String inputPostfix) {

		Set<Character> letterSet = countletters(inputPostfix);
		char res = ' ';

		char[][] chars = binaryCombinations(letterSet.size());

		Iterator<Character> letterSetIterator1 = letterSet.iterator();

		while (letterSetIterator1.hasNext()) {
			char c = letterSetIterator1.next();
			System.out.print(c + "\t");
		}
		System.out.print("Output");
		System.out.println();
		for (int i = 0; i < chars.length; i++) {

			String inputUpdate = inputPostfix;
			int j = 0;
			Iterator<Character> letterSetIterator = letterSet.iterator();

			while (letterSetIterator.hasNext()) {

				char c = letterSetIterator.next();

				inputUpdate = inputUpdate.replace(c, chars[i][j]);
				j++;
			}

			Stack<Character> list = new Stack<Character>();
			char c1;
			char c2;

			for (j = 0; j < inputUpdate.length(); j++) {
				char ch = inputUpdate.charAt(j);
				if (ch == ' ') {
				} else {
					if (Character.isLetter(ch)) {
						list.push(ch);
					} else {

						if (ch == '~') {
							c1 = list.pop();
							list.push(operationPerform(c1, ch));
						} else {

							c1 = list.pop();
							c2 = list.pop();

							switch (ch) {

							case '&':
								list.push(operationPerform(c1, c2, '&'));
								break;

							case '|':
								list.push(operationPerform(c1, c2, '|'));
								break;

							default:
								System.out.println("Invalid operator order!");
							}
						}
					}
				}
			}
			res = list.pop();
			for (int count = 0; count < chars[0].length; count++) {
				System.out.print(chars[i][count] + "\t");
			}
			System.out.println(res);
		}
	}

	private Character operationPerform(char c1, char c2, char op) {

		if (op == '&') {

			if (c1 == 'F' || c2 == 'F') {
				return 'F';
			} else
				return 'T';
		}

		else {

			if (c1 == 'T' || c2 == 'T') {
				return 'T';
			} else
				return 'F';
		}
	}

	private Character operationPerform(char c1, char op) {

		if (c1 == 'F')
			return 'T';
		else
			return 'F';
	}

	private String postfixConvertor(String input) {
		Stack<Character> stackObj = new Stack<Character>();

		int inputLength = input.length();
		String postfixExpression = "";
		Object poppedItem;
		int countBraces = 0;

		for (int i = 0; i < inputLength; i++) {
			Character temp = new Character(input.charAt(i));

			if (Character.isLetter(temp)) {
				postfixExpression = postfixExpression + temp;
			}

			else if (input.charAt(i) == '(') {
				stackObj.push(temp);
				countBraces++;
			}

			else if (temp == ')') {
				if (countBraces == 0) {
					System.out.println("Invalid Expression");
					return null;
				}

				while (!((char) stackObj.peek() == '(')) {
					poppedItem = stackObj.pop();
					postfixExpression = postfixExpression + poppedItem;
				}
				stackObj.pop();
				countBraces--;
			}

			else if (temp == '&' || temp == '|' || temp == '~') {
				if (stackObj.size() == 0) {
					stackObj.push(temp);
				} else {
					if (input.charAt(i) == '~') {
						if ((char) stackObj.peek() == '~') {
							poppedItem = stackObj.pop();
							postfixExpression = postfixExpression + poppedItem;
						}
					} else if (input.charAt(i) == '&') {
						while (stackObj.peek() != '|' && stackObj.peek() != '(') {
							poppedItem = stackObj.pop();
							postfixExpression = postfixExpression + poppedItem;
							if (stackObj.size() == 0)
								break;
						}
					} else if (input.charAt(i) == '|') {
						while (stackObj.size() != 0 && stackObj.peek() != '(') {
							poppedItem = stackObj.pop();
							postfixExpression = postfixExpression + poppedItem;
						}
					}

					stackObj.push(temp);
				}
			}
		}

		while (stackObj.size() != 0) {
			poppedItem = stackObj.pop();
			postfixExpression = postfixExpression + poppedItem;
		}

		return postfixExpression;
	}

	private char[][] binaryCombinations(int numberOfCharacters) {

		if (numberOfCharacters == 0)
			return null;

		int numberOfRows = (int) Math.pow(2, numberOfCharacters);

		boolean[][] bools = new boolean[numberOfRows][numberOfCharacters];
		char[][] chars = new char[numberOfRows][numberOfCharacters];

		for (int i = 0; i < bools.length; i++) {
			for (int j = 0; j < bools[i].length; j++) {
				int val = bools.length * j + i;
				int ret = (1 & (val >>> j));
				bools[i][j] = ret != 0;
				if (bools[i][j]) {
					chars[i][j] = 'T';
				} else {
					chars[i][j] = 'F';
				}
			}
		}

		return chars;
	}
}
