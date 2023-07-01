package week6.day2;

import java.util.Arrays;

import org.junit.Test;

public class HC_CaesarCipher1 {

	@Test
	public void example1() {
		String s="middle-Outz";
		int k=2;
		caesarCipher(s,k);
	}
	
	
	public static String caesarCipher(String s, int k) {
   
     String output="";
    char ch1;
    //int n=k;
    if(k>26){
    k=k%26;    
    }
    for(int i=0;i<s.length();i++){
        if(Character.isLetter(s.charAt(i))){
      
        char ch=(char)(s.charAt(i)+k);
        
        //System.out.println("char out1"+ch);
        if(ch>'Z' && ch<'a' || ch>'z'){
            ch=(char)((int)(ch-26));
             //System.out.println("char out2"+ch);
        }
         
           ch1=(char)ch;
            output=output+ch1;   
        }
        else{
            output=output+s.charAt(i);
        }
        
    }
        return output;
    }
}
