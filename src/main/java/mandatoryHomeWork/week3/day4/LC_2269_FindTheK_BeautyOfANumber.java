package week3.day4;

import org.junit.Test;

public class LC_2269_FindTheK_BeautyOfANumber {

	@Test
	public void example1() {
		int num = 240;
		int k = 2;
		kBeautyOfNums(num,k);
	}

	@Test
	public void example2() {
		int num = 430043;
		int k = 2;
		kBeautyOfNums(num,k);
	}

	@Test
	public void example3() {
		int num = 430043;
		int k = 3;
		kBeautyOfNums(num,k);
	}

	@Test
	public void example4() {
		int num = 430043;
		int k = 4;
		kBeautyOfNums(num,k);
	}
	
	//Understanding the Problem --> 15mins
	//Time Taken --> 25mins
	/*
	 * nums.toString()
	 * loop till the length of nums
     * get the k index and convert it into the integer
     * check the divisibility and increment the counter
     * grow the window to next subsequent area and repeat the same
     */ 
	
	//Time Complexity --> O(n)
	//Space Complexity --> O(n)
	
	//Time Taken --> 15mins
	private void kBeautyOfNums(int num, int k) {
		
		String str=String.valueOf(num);
		
		StringBuilder val=new StringBuilder("");
		
		int count=0;
		
		for(int i=0;i<str.length();i++) {
			
			val=val.append(str.charAt(i));
			
			if(val.length()==k) {
				
				int div=Integer.parseInt(val.toString());
				
				if(div!=0) {
					if(num%div==0) count++;
				}
				
				val.deleteCharAt(0);
				
				
			}
		}
		System.out.println(count);
		
		
	}
}
