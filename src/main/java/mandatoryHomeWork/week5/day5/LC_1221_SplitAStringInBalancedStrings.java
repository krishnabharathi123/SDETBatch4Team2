package week5.day5;

import org.junit.Test;

public class LC_1221_SplitAStringInBalancedStrings {

	@Test
	public void positive() {
		String s = "RLRRLLRLRL";
	}

	@Test
	public void positive1() {
		String s = "RLRRRLLRLL";
	}

	@Test
	public void edge1() {
		String s = "LLLLRRRR";
	}
	
	/*
	 * Initialize rCount, lCount and out
	 * loop till the length of the string
	 * if the character is 'R' then increment rCount;
	 * else increment lCount;
	 * if rCount==lCount --> increment o
	 */
	public int balancedStringSplit(String s) {
        int lCount=0;
        int rCount=0;
        int out=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            switch(ch){
                case 'R':
                rCount++;
                break;
                default: 
                lCount++;
            }
            if(rCount==lCount){
                out++;
                lCount=0;
                rCount=0;
            }
        }
        return out;
    }
}
