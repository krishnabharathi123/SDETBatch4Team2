package week5.day1;

import org.junit.Test;

public class LC_925_LongPressedName {

	@Test
	public void positive() {
		String name ="alex";
		String typed ="aaleex";
		System.out.println(isNameLongPressed1(name, typed));
	}

	//@Test
	public void edge() {
		String name ="alex";
		String typed ="aalllleeeex";
		System.out.println(isNameLongPressed(name, typed));

	}
	
	//@Test
	public void negative() {
		String name ="saeed";
		String typed ="ssaaedd";
		System.out.println(isNameLongPressed(name, typed));

	}
	
	@Test
	public void negative1() {
		String name ="alex";
		String typed ="alext";
		System.out.println(isNameLongPressed(name, typed));

	}
	
	private boolean isNameLongPressed(String name, String typed) {
		int left=0;
		int right=0;
		int count=0;
		while(right<typed.length() && left<name.length()) {
			
 		if(name.charAt(left)==typed.charAt(right)) {
			right++;
			count=0;
		}
		else if((name.charAt(left)!=typed.charAt(right))) {
			left++;
			count++;
			if(count<1) return false;
		}
		else {
			return false;
		}
		}
		return true;
		
		
	}
	
	private boolean isNameLongPressed1(String name, String typed) {
		int left=0;
		int right=0;
		int count=0;
		while(right<typed.length() && left<name.length()) {
			
 		if(name.charAt(left)==typed.charAt(right)) {
			right++;
			count=0;
		}
		else if((name.charAt(left)!=typed.charAt(right))) {
			left++;
			count++;
			if(count<1) return false;
			if(count==1 && left==typed.length()-1 && right==typed.length()-1) return false;
		}
		else {
			return false;
		}
		}
		return true;
		
		
	}
	
}

