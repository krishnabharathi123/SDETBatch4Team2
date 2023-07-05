package week11.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HC_SherlockAndValidString {

	//@Test
	public void ex1() {
		String s="ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
		System.out.println(isValid(s));
	}
	@Test
	public void ex2() {
		String s="aabbcd";
		System.out.println(isValid(s));
	}
	//@Test
	public void ex3() {
		String s="abcdefghhgfedecba";
		System.out.println(isValid(s));
	}
	/*
	 * Create an Integer list to store the counts
	 * Convert the input string into the character array and sort the array
	 * Get the count of each character in a array and store it in a list.
	 * To add value for the 1st time--> Check whether the list size is 1. If yes, add the count in list
	 * else, if ur not adding the count for the 1st time, 
	 * --> Then check if the count already exist in map
	 * ----> if exist,add the count in the existing list
	 * ----> if count not exist in list, then check the abs difference between list.get(0)--> (since all the value are same) and count
	 * -----> if abs diff == 1 or count ==1 and flag==true add, then make the flag as false --> bcz this step should be done only once
	 * -----> else return "NO"
	 * return "YES"
	 */
	
	//Time Complexity --> O(n)
	//Space Complexity --> O(n)
	
	public static String isValid(String s) {
	    // Write your code here
	    List<Integer> ls = new ArrayList<Integer>();
	    char[] strArr=s.toCharArray();
	    Arrays.sort(strArr);
	    int left=0, right=0, count=0;
	    boolean flag=true;
	    
	    while(right<strArr.length){
	         if(strArr[left]==strArr[right]){
	            count++;
	            right++;
	    }
	         else{
	             //list is empty so adding for the 1st time
	             if(ls.size()==0){
	                 ls.add(count);
	             }
	             else{
	                 if(ls.contains(count)){
	                     ls.add(count);
	                 }
	                 else{
	                     int diff=Math.abs(ls.get(0)-count);
	                     //diff==1 means removing 1 elemnt is fine
	                     //count==1 means there is only 1 element so removal is fine
	                     //using flag, bcz only one time this step should happen
	                     if((diff==1 || count==1) && flag){
	                         //ls.add(ls.get(0));
	                         flag=false;
	                     }
	                     else return "No";
	                 }
	             }
	             left=right;
	             count=0;
	    }
	    }
	    
	     if(ls.contains(count)){
	                     ls.add(count);
	                 }
	        else{
	                     int diff=Math.abs(ls.get(0)-count);
	                     if((diff==1 || count==1) && flag){
	                       //  ls.add(count-diff);
	                         flag=false;
	                     }
	                     else return "NO";
	                 }
	                 
	   return "YES";
	    }
}
