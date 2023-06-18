package week5.day2;

import org.junit.Test;

public class LC_1678_GoalParserInterpretation {

	@Test
	public void example1() {
		String s="G()(al)";
		
		System.out.println(goalInterpretation(s));
	}
	
	@Test
	public void example2() {
		String s="G()()()()(al)";
		
		System.out.println(goalInterpretation(s));
	}
	
	@Test
	public void example3() {
		String s="(al)G(al)()()G";
		
		System.out.println(goalInterpretation(s));
	}

	/*
	 * loop till i is lesser than s.length
	 * check if the ith char is 'G' --> If yes, add it in a new string
	 * else check if ith char is '('-->If yes, increment i
	 * -->  check whether next value is ')' --> If yes, add 'O' to new string
	 * -->  else add 'al' to the new string and increment i+2
	 * return new string 
	 * 
	 */
	//Time Complexity ---> O(n)
	//Space Complexity --->O(n)
	private String goalInterpretation(String s) {
		String out="";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='G') {
				out=out+'G';
			}
			else if(s.charAt(i)=='(') {
				i++;
				if(s.charAt(i)==')') {
					out=out+'o';
				}
				else {
					out=out+"al";
					i+=2;
					}
				}
				
				}
		return out;
		}
		
		
	
}
