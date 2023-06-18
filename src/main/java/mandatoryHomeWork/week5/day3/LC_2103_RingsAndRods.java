package week5.day3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class LC_2103_RingsAndRods {

	
	@Test
	public void ex1() {
		String rings= "B0B6G0R6R0R6G9";
		RingsAndRods(rings);
	}
	
	@Test
	public void ex2() {
		String rings= "B0R0G0R9R0B0G0";
		RingsAndRods(rings);
	}
	
	@Test
	public void ex3() {
		String rings= "G4";
		RingsAndRods(rings);
	}

	private void RingsAndRods(String rings) {
		
		//Set<Character> setRef=new HashSet<Character>();
		
		HashMap<Integer,Set<Character>> map= new HashMap<Integer,Set<Character>>();
		//traverse only the numbers
		for(int i=0;i<rings.length();i+=2) {
			
			int rodNo=Character.getNumericValue(rings.charAt(i+1));
			//if the rod number is not available in map, then create a new set and add the previous character and put in map
			if(!map.containsKey(rodNo)) {
			Set<Character> val = new HashSet<Character>();
			val.add(rings.charAt(i));
			map.put(rodNo,val);
			}
			//if rod number is available in map already, then get the existing set value and add the new value and put it in map
			else {
				Set<Character> set = map.get(rodNo);
				set.add(rings.charAt(i));
				map.put(rodNo,set);
			}
		}
		System.out.println(map);
		int count=0;
		for(Map.Entry<Integer,Set<Character>> i: map.entrySet()) {
			Set<Character> value = i.getValue();
			if(value.size()==3) count++;
		}
		System.out.println(count);
	}
}
