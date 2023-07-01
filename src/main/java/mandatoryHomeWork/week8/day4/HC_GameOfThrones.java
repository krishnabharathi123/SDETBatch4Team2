package week6.day2;

import java.util.Arrays;

import org.junit.Test;

public class HC_GameOfThrones {

	@Test
	public void example1() {
		String s="abcddcba";
		gameOfThrones(s);
	}
	
	@Test
	public void example2() {
		String s="aaabbbb";
		gameOfThrones(s);
	}
	
	@Test
	public void example3() {
		String s="cdefghmnopqrstuvw";
		gameOfThrones(s);
	}
	
	public static String gameOfThrones(String s) {
   
       int size=s.length();
        int odd=0;
        //int even=0;

    HashMap<Character, Integer> map= new HashMap<Character,Integer>();
    
    for(int i=0;i<size;i++){
        
        map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);

    }

    for(Map.Entry<Character,Integer> i: map.entrySet()){

        if(i.getValue()%2!=0){
        
            odd++;
        
        }
    
    }

        //if size is even, then odd should be zero

        if(size%2==0 && odd==0){
            return "YES";
        }
    else if(size%2!=0 && odd==1){
         return "YES";
    }
    else return "NO";


    }
}
