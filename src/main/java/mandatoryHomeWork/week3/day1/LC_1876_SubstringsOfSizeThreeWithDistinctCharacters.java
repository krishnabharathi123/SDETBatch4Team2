package week3.day1;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

public class LC_1876_SubstringsOfSizeThreeWithDistinctCharacters {

	
	public void positive() {
		String str = "xyzzaz";
		int k = 3;
		distinctSubStrings(str, k);
	}

	@Test
	public void edge() {
		String str = "aababcabc";
		int k = 3;
		distinctSubStrings(str, k);

	}

	
	public void negative() {
		String str = "aaaaaaaa";
		int k = 3;
		distinctSubStrings(str, k);

	}

	/* Brute Force
	 * outer loop from 0 till str.length-k
	 * inner loop from i to k+i
	 * add the value in a set and check if the length of set is equal to k
	 * If yes, increment the count
	 * else clear the set
	 */
	//O(n-k)*k==>O(n*k)
	//O(n)
	private void distinctSubStrings(String str, int k) {
		HashSet<Character> set=new HashSet<Character>();
		int count=0;
		for(int i=0;i<=str.length()-k;i++) {
			for(int j=i;j<k+i;j++) {
				set.add(str.charAt(j));
			}
			if(set.size()==k) count++;
			set.clear();
		}
		System.out.println(count);
	}
	
	/*
	 * sliding window using set --> but not working
	 */
	//aababcabc
	private void distinctSubStrings_sw1(String str, int k) {
		HashSet<Character> set=new HashSet<Character>();
		int count=0;
		for(int j=0;j<k;j++) {
			set.add(str.charAt(j));	//aab
			//set.clear();
			
		}
		System.out.println(set);
		if(set.size()==k) count++;
		for(int i=1;i<=str.length()-k;i++) {
			
			set.remove(str.charAt(i-1));//ab
			set.add(str.charAt(k+i-1));	//ab
			if(set.size()==k) count++;
			System.out.println(set);
		}
		
		System.out.println(count);
	}
	
	//xyzzaz
	private void distinctSubStrings_sw(String str, int k) {
		//create a hashmap with character as key and count as integer
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		//forcefully add the 1st value into hashmap
		map.put(str.charAt(0), 1);
		//add the 2nd and 3rd character into the map
		for(int i=1;i<k;i++) {
			//check is the key is already available in map.If yes add the 1 to existing value
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}
			//else add the value  as 1
			else {
				map.put(str.charAt(i), 1);
			}
			System.out.println(map);

		}
		
		//abca
		for(int i=1;i<=str.length()-k;i++) {
			if(map.get(str.charAt(i-1))==1) {
				map.remove(str.charAt(i-1));
			}
			else {
				map.put(str.charAt(i-1), map.get(str.charAt(i-1))-1);
			}
			if(map.containsKey(str.charAt(i+1))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}
			
			else {
				map.put(str.charAt(i), 1);
			}
			System.out.println(map);

		}
	}
	
}
