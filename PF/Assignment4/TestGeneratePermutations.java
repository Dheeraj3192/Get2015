import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestGeneratePermutations {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGeneratePermutation1() {
		GeneratePermutations generatePer = new GeneratePermutations();
		List<String> CombinationList = generatePer.generatePermutations("AAB");
		String expected[]={"AAB","ABA","BAA"};
		int index=0;
		for(String str:CombinationList)
		{
			assertEquals("hi", expected[index++], str);
			
		}
	}
		@Test
		public void testGeneratePermutation2() {
			GeneratePermutations generatePer = new GeneratePermutations();
			List<String> CombinationList = generatePer.generatePermutations("ABC");
			String expected[]={"ABC","ACB","BAC","BCA","CBA","CAB"};
			int index=0;
			for(String str:CombinationList)
			{
				assertEquals("hi", expected[index++], str);
				
			}
		}
			@Test
			public void testGeneratePermutation3() {
				GeneratePermutations generatePer = new GeneratePermutations();
				List<String> CombinationList = generatePer.generatePermutations("AAA");
				String expected[]={"AAA"};
				int index=0;
				for(String str:CombinationList)
				{
					assertEquals("hi", expected[index++], str);
					
				}

		
	}

}
