package stackImplementation;

import org.junit.Test;

public class BracketsValidation {

	@Test
	public void positive() {
		String str="[[{}]()]";
		validateBrackets(str);
	}
	@Test
	public void negative() {
		String str="[{}])";
		validateBrackets(str);
	}
	
	@Test
	public void edge() {
		String str="[({}])";
		validateBrackets(str);
	}
	
	@Test
	public void edge1() {
		String str="}[({}])";
		validateBrackets(str);
	}
	
	@Test
	public void positive1() {
		String str="[[]]";
		validateBrackets(str);
	}
	
	/*Using stack
	 * loop form 0 till the string length
	 * check if character is open brackets--> If yes, push it into the stack
	 * else if check if the characters are closed brackets --> If yes, pop and compare the ] == [
	 * 
	 */
	private void validateBrackets(String str) {
		Stack st= new Stack();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='['||str.charAt(i)=='('||str.charAt(i)=='{') {
				//System.out.println(st.push(str.charAt(i)));
				st.push(str.charAt(i));
			}
			else if(str.charAt(i)==']'||str.charAt(i)==')'||str.charAt(i)=='}') {
				Character pop = st.pop();
				//System.out.println(pop);
				if(pop!=null) {
				if((str.charAt(i)==']' && pop=='[') || (str.charAt(i)==')' && pop=='(') || str.charAt(i)=='}' && pop=='{') {
					//System.out.println(str.charAt(i)+"removed");
				}
				else {
					System.out.println("Condition not satisfied");
					break;
				}
				}
				/*
				 * if(str.charAt(i)==')' && pop=='(') {
				 * System.out.println(str.charAt(i)+"removed"); } if(str.charAt(i)=='}' &&
				 * pop=='{') { System.out.println(str.charAt(i)+"removed"); }
				 */
				else {
					System.out.println("Condition not satisfied");
					break;
				}
			}
		}
		
	}

}
