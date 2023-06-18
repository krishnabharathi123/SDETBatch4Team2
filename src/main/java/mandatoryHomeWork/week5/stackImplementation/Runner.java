package stackImplementation;

public class Runner {

	public static void main(String[] args) {
		Stack st= new Stack();
		System.out.println(st.push('a'));
		System.out.println(st.push('b'));
		System.out.println(st.push('c'));

		//System.out.println(st.pop());
		//System.out.println(st.pop());
		//System.out.println(st.pop());
		//System.out.println(st.pop());
		
		//System.out.println(st.peek());
		
		System.out.println(st.peekUsingIndex(4));
	}

}
