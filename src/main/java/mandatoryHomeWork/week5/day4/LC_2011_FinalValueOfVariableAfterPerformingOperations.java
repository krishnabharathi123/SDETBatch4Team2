package week5.day4;

import org.junit.Test;

public class LC_2011_FinalValueOfVariableAfterPerformingOperations {

	@Test
	public void example1() {
		String[] operations = {"--X","X++","X++"};
		finalValue(operations);
	}
	
	@Test
	public void example2() {
		String[] operations = {"++X","++X","X++"};
		finalValue(operations);
	}
	
	@Test
	public void example3() {
		String[] operations = {"X++","++X","--X","X--"};
		finalValue(operations);
	}
	
	private void finalValue(String[] operations) {
		int x=0;
		for(String i:operations) {
			if(i.contains("-")) {
				x+=-1;
			}
			else {
				x+=1;
			}
		}
		System.out.println(x);
		
	}

}
