package week11.day3;

import org.junit.Test;

public class HC_SaveThePrisoner {

	
	@Test
	public void test1() {
		int n=352926151;
		int m=380324688;
		int s=94730870;
		System.out.println(saveThePrisoner1(n,m,s));
		
		//Expected output->122129406
	}
	
	@Test
	public void test2() {
		int n=7;
		int m=615562705;
		int s=2;
		System.out.println(saveThePrisoner1(n,m,s));
	}
	
	@Test
	public void test3() {
		int n=8;
		int m=117991680;
		int s=2;
		System.out.println(saveThePrisoner1(n,m,s));
	}
	
	@Test
	public void test4() {
		int n=7;
		int m=122129406;
		int s=7;
		System.out.println(saveThePrisoner1(n,m,s));
	}
	
	
	public static int saveThePrisoner(int n, int m, int s) {
        int i=0;
       
        int count=1;
        i=s;
        
        if(n<m){
             m=m%n;
        }
         while(count!=m){
            
                i++;
                if(i>n){
                     i=1;
                }
                count++;
           
           
        }
    return i;
    }
	
	public static int saveThePrisoner1(int n, int m, int s) {
        int i=0;
       
        int count=1;
        i=s;
        
        if(n<m){
             m=m%n;
        }
        int out=s+m-1;
        
        if(out>n) {
        	out=out-n;
        }
        return out;
         /*while(count!=m){
            
                i++;
                if(i>n){
                     i=1;
                }
                count++;
           
           
        }*/
    //return i;
    }
	
	public static int saveThePrisoner2(int n, int m, int s) {
		 int i=s;
	        
	       /* if(n<m){
	             m=m%n;
	        }*/
	        int out=s+m-1;
	        
	        if(out%n==0) {
	            return n;
	        }
	        return out%n;
    }
}
