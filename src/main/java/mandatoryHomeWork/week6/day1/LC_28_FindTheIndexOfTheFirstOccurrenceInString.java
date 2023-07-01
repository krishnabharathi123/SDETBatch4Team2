package week6.day2;

import java.util.Arrays;

import org.junit.Test;

public class LC_28_FindTheIndexOfTheFirstOccurrenceInString
 {

	@Test
	public void example1() {
		String haystack = "sadbutsad", needle = "sad";
		strStr( haystack,  needle);
	}
	
	@Test
	public void example2() {
		String haystack = "leetcode", needle = "leeto";
		strStr( haystack,  needle);
	}
	

	public int strStr(String haystack, String needle) {
    int i=0;
		int j=needle.length();
		while(j<=haystack.length()) {
			
			if(haystack.substring(i,j).equals(needle)) {
				System.out.println(haystack.substring(i,j));
				return i;
			}
			else if (!(haystack.substring(i,j-1).equals(needle))) {
			i++;
			j++;
		}
		
		}
		return -1;
		
    }

    //Time comp--> O(n)
    //Space Comp--> O(1)
    public int strStr1(String haystack, String needle) {
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }

}
