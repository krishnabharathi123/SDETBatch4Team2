package week4.day2;

import org.junit.Test;

public class ReverseAlphabets {

	@Test
	public void positive() {
		String s = "asd@#$@12efrdf312s*(^&*dsd";
		System.out.println(reversAlpha(s));
	}
	
	@Test
	public void negative() {
		String s = "&%^$&(()*";
		System.out.println(reversAlpha(s));
	}
	
    @Test
	public void edge() {
    	String s = "abcfh*jllll";
		System.out.println(reversAlpha(s));
	}
    /*
     * 2 pointer in opposite direction
     * Add the string in StringBuider
     * left=0 and right=str.length()-1
     * loop till left crosses right
     * check if the left and right index values are letter. If yes swap and increment left and decrement right
     * else check if left value is not a letter.If yes, increment left
     * else check if right value is not a letter.If yes, decrement right
     * return the StringBuider
     */
    //Time Complexity --> O(n/2)-->O(n)
    //Space Complexity --> O(n)
    private String reversAlpha(String s) {
		
    	StringBuilder sb= new StringBuilder(s);
    	int left=0;
    	int right=s.length()-1;
    	char temp;
    	while(left<=right) {
    		if(Character.isLetter(sb.charAt(left)) && Character.isLetter(sb.charAt(right))) {
    			temp=sb.charAt(right);
    			sb.setCharAt(right--, sb.charAt(left));
    			sb.setCharAt(left++, temp);
    		}
    		else if(!Character.isLetter(sb.charAt(left))) left++;
    		else if(!Character.isLetter(sb.charAt(right))) right--;
    	}
    	
		return sb.toString();
	}

}
