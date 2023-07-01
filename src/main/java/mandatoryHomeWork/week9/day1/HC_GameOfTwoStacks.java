package week6.day2;

import java.util.Arrays;

import org.junit.Test;

public class HC_GameOfTwoStacks {

	@Test
	public void example1() {
	   int maxSum=10;
       List<Integer> a=Arrays.asList(4, 2, 4, 6, 1);
       List<Integer> b=Arrays.asList(2, 1, 8, 5);
       twoStacks(maxSum,a,b);
	}

	
	public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        int val=0, left=0, right=0,count=0;
        while(left<a.size() && right<a.size()){
            if(val<maxSum){
                val=val+a.get(left);
                left++;
                count++;
            }
            if(val<maxSum){
                val=val+b.get(right);
                right++;
                count++;
            }
            else{
                return count-1;
            }
            
        }
        while(left<a.size()){
            if(val<maxSum){
                val=val+a.get(left);
                left++;
                count++;
            }
            else return count-1;
        }
        while(right<b.size()){
            if(val<maxSum){
                val=val+b.get(right);
                right++;
                count++;
            }
            else{
                return count-1;
            }
        }
        return count;
    }
}
