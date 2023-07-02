package week6.day2;

import java.util.Arrays;

import org.junit.Test;

public class HC_CaesarCipher1 {

	@Test
	public void example1() {
		String s="middle-Outz";
		int k=2;
		caesarCipher1(s,k);
	}
	public static String caesarCipher1(String s, int k) {
    String output="";
    char ch1;
    int n=k;
    for(int i=0;i<s.length();i++){
        if(Character.isLetter(s.charAt(i))){
        int ch=s.charAt(i);//120
        while(n>0){
                 ch = ch+1;//122
        
        if(ch==123 || ch==91) {
            ch=ch-26;
        }
        n--;
        }
            n=k; 
           ch1=(char)ch;
            output=output+ch1;   
        }
        else{
            output=output+s.charAt(i);
        }
        
    }
        return output;
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
