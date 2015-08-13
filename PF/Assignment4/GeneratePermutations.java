/***
 * @author Dheeraj
 * Program to generate permutation of a given string
 */


import java.util.ArrayList;
import java.util.List;

/*Starting of GeneratePermutations class*/
public class GeneratePermutations {

	List<String> CombinationList = new ArrayList<String>();
//main function
	public static void main(String[] args) {
		GeneratePermutations generatePer = new GeneratePermutations();
		List<String> CombinationList = generatePer.generatePermutations("ABBA");
		
		for (int index = 0; index < CombinationList.size(); index++)
			System.out.println(CombinationList.get(index));

	}
//Method will return list of permutations
	List<String> generatePermutations(String input) {
		StringBuffer mutableInput = new StringBuffer(input);
		permute(mutableInput, 0, mutableInput.length() - 1);
		return CombinationList;
	}
//method to generate permutations
	void permute(StringBuffer input, int startIndex, int endIndex) {

		if (startIndex == endIndex) {
			String string = input.toString();
			boolean isDuplicate = false;
			for (int index = 0; index < CombinationList.size(); index++) {//it will check duplicate element 
				if (string.equals(CombinationList.get(index))) {
					isDuplicate = true;
					break;
				}

			}
			if (!isDuplicate)
				CombinationList.add(string);

		} else {
			for (int index = startIndex; index <= endIndex; index++) {
				swapCharacter(input, startIndex, index);
				permute(input, startIndex + 1, endIndex);
				swapCharacter(input, startIndex, index); // backtrack
			}
		}

	}
//	method to swap element/character
	void swapCharacter(StringBuffer input, int firstIndex, int secondIndex) {
		char firstChar = input.charAt(firstIndex);
		char secondChar = input.charAt(secondIndex);
		input.setCharAt(firstIndex, secondChar);
		input.setCharAt(secondIndex, firstChar);

	}

}
/*End of GeneratePermutation class*/
