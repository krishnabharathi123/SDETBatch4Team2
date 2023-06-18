package week3.day4;
import java.util.*;
import org.apache.commons.lang3.StringUtils;

import org.junit.Test;

public class LC_1859_SortingTheSentence {

	@Test
	public void example1() {
		String s="is2 sentence4 This1 a3";
		sortSenetence1(s);
	}

	@Test
	public void example2() {
		String s="Myself2 Me1 I4 and3";
		sortSenetence1(s);
	}
	
	//Time Taken - 20m
		// Using TreeMap
	 	//split the value using " " and store it in the string array
    		//get the last character and store it as a key and remaining characters as a value in TreeMap
		//get the value and append in the input string except last value of each character
	
	//Time Complexity --> O(n*m)
	//Space Complexity --> O(n)
	private void sortSenetence(String s) {
		
		String[] split = s.split(" ");
		
		TreeMap<Integer,String> map=new TreeMap<Integer,String>();
		for(int i=0;i<split.length;i++) { //O(n)
		map.put((int) split[i].charAt(split[i].length()-1), split[i]);
		}
		
		
		s="";
		
		for(Map.Entry<Integer, String> i : map.entrySet()) {//O(n)
			char[] ch=i.getValue().toCharArray();
			for(int j=0;j<=ch.length-2;j++) {//O(m)
				s=s+ch[j];
			}
			s=s+" ";
		}
		
		System.out.println(s.trim());
	}
	
	//Time Complexity --> O(n)
	//Space Complexity --> O(n)
	private void sortSenetence1(String s) {
		
		String[] split = s.split(" ");
		
		TreeMap<Integer,String> map=new TreeMap<Integer,String>();//O(logn)
		for(int i=0;i<split.length;i++) { //O(n)
		map.put((int) split[i].charAt(split[i].length()-1), split[i]);
		}
		
		s="";
		
		for(Map.Entry<Integer, String> i : map.entrySet()) {//O(n)
			s=s+i.getValue().substring(0, i.getValue().length()-1);
			s=s+" ";
		}
		
		System.out.println(s.trim());
		
	}
}
