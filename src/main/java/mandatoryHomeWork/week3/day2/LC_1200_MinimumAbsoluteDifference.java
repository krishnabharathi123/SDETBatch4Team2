package week3.day2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LC_1200_MinimumAbsoluteDifference {

	@Test
	public void example1() {
		int[] arr= {4,2,1,3};
		minAbsDiff(arr);
	}

	public void example2() {
		int[] arr= {1,3,6,10,15};
	}
	
	public void example3() {
		int[] arr= {3,8,-10,23,19,-4,-14,27};
	}
	/*
	 * Brute Force:
	 * Assign Integer.Max to min variable
	 * Outer loop i --> from 0 to arr.length-1
	 * Inner loop j --> from i+1 to arr.length-1
	 * Get the absolute difference between i and j
	 * If the absolute value is lesser than min val, remove the previously added list and add the current i and j to the list
	 * If the absolute value is equal to the min value, add the i and j to existing list 
	 * Add this list in main list
	 * 
	 */
	private void minAbsDiff(int[] arr) {
		int min=Integer.MAX_VALUE;
		int diff=0;
		
		List<Integer> ls=new ArrayList<Integer>();
		List<List<Integer>> lst=new ArrayList<List<Integer>>();
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				diff=Math.abs(arr[i]-arr[j]);
				//4,2,1,3
				if(diff<min) {
					min=diff;
					System.out.println(diff);
					
					if(lst.size()!=0) {
						lst.remove(lst.size()-1);
						ls.clear();
					}
						ls.add(arr[i]);
						ls.add(arr[j]);
						lst.add(ls);
						//System.out.println(ls);
						//System.out.println(lst);
					}
				
				
				else if(diff==min) {
					min=diff;
					System.out.println(diff);
					//lst.remove(lst.size()-1);
					ls.clear();
					ls.add(arr[i]);
					ls.add(arr[j]);
					//System.out.println(lst);
					lst.add(ls);
					//ls.clear();
					//System.out.println(ls);
					//System.out.println(lst);
				}
				System.out.println(ls);
				System.out.println(lst);
				}
			System.out.println(lst);
			}
		
			
		}

		
	}

