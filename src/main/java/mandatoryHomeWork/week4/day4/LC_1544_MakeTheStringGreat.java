package week4.day4;
import stackImplementation.Stack;
import org.junit.Test;

public class LC_1544_MakeTheStringGreat extends Stack{

	//@Test
	public void example1() {
		String s="leEeetcode";
		greatString(s);
	}
	
	//@Test
	public void example2() {
		String s="abBAcC";
		greatString(s);
	}
	
	//@Test
	public void example3() {
		String s="aaaaaaa";
		greatString(s);
	}
	

	//@Test
	public void example4() {
		String s="bBCcdD";
		greatString(s);
	}
	

	//@Test
	public void example5() {
		String s="bBfghdDd";
		greatString(s);
	}
	
	@Test
	public void example6() {
		String s="jOlrqDxpiGzIHUznyXvfJTXnQwrnChZNVnAdyVgKeGwNfUijuc";
		          //jOlrqDxpiGzIHUznyXvfJTXnQwrnChZNVnAdyVgKeGwNfUijuc
		greatString(s);
	}
	
	private void greatString(String s) {
		
		Stack st=new Stack();
		
		for(int i=0;i<s.length();i++) {
			
			
			if(st.top==0) {
				st.push(s.charAt(i));
				//System.out.println(st.top);
			}
			
			else if((Character.isUpperCase(s.charAt(i)) && Character.isLowerCase(st.peek())) || (Character.isLowerCase(s.charAt(i)) && Character.isUpperCase(st.peek()))) {
				
				char ch1=s.charAt(i);
				char ch2=st.peek();
				
				if(Character.toUpperCase(ch1)==Character.toUpperCase(ch2)) {
					st.pop();
				}
				else {
					st.push(s.charAt(i));
				}
			}
			else {
				st.push(s.charAt(i));
			}
			
		}
		s="";
		while(st.top!=0) {
		
		s=st.pop()+s;
		System.out.println(s);
		}
		
	}

}
