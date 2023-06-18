package week4.day1;
import stackImplementation.StackInt;
import org.junit.Test;

public class LC_682_BaseBallGame1 {
	@Test
	public void example1() {
		String[] ops= {"5","2","C","D","+"};
		baseBallUsingStack1(ops);
	}
	@Test
	public void example2() {
		String[] ops= {"5","-2","4","C","D","9","+","+"};
		baseBallUsingStack1(ops);
	}

	@Test
	public void example3() {
		String[] ops= {"1","C"};
		baseBallUsingStack1(ops);
	}
	
	/*
	 * If u find the numbers, push it in the stack
	 * If u find C remove the pop element from stack
	 * If u find D peek the last element and multiply with 2 and push it to the stack
	 * If u find + peek last and last-1 element and add it together and push in to stack
	 */
	private void baseBallUsingStack(String[] ops) {
		StackInt st=new StackInt();
		int num;
		int val;
		int size=-1;
		int sum=0;
		for(int i=0;i<ops.length;i++) {
			try {
				num=Integer.parseInt(ops[i]);
				//System.out.println(num);
				st.push(num);
			}
			catch(Exception e){
				char charAt = ops[i].charAt(0);
				switch(charAt) {
				//If you find the character 'C', pop from the stack
				  case 'C':
					  st.pop();
						size--;
				    break;
				  //If you find the character 'D' peek the last value and multiply by 2 and push it into the stack
				  case 'D':
					  val=2*(st.peek(1));
					  st.push(val);
						size++;
				    break;
				  //If you find the character '+' peek the last and last-1 value and add it and push it into the stack
				  case '+':
						val= st.peek(1)+st.peek(2);
						
						 st.push(val);
							
							size++;
					}
			}
		}
		
		//System.out.println(st.size());
		for(int i=1;i<=st.size();i++) {
			sum=sum+st.peek(i);
		}
		System.out.println(sum);
		
	}
	private void baseBallUsingStack1(String[] ops) {
		StackInt st=new StackInt();
		int num;
		int val;
		int size=-1;
		int sum=0;
		for(int i=0;i<ops.length;i++) {
			try {
				num=Integer.parseInt(ops[i]);
				//System.out.println(num);
				st.push(num);
			}
			catch(Exception e){
				char charAt = ops[i].charAt(0);
				switch(charAt) {
				//If you find the character 'C', pop from the stack
				  case 'C':
					  st.pop();
						size--;
				    break;
				  //If you find the character 'D' peek the last value and multiply by 2 and push it into the stack
				  case 'D':
					  val=2*(st.peek());
					  st.push(val);
						size++;
				    break;
				  //If you find the character '+' pop the last and last-1 value,store in a variables and push it back to the stack
				    //add both the values and push it into the stack
				  case '+':
					  int last=st.pop();
					  int prev=st.pop();
					  st.push(prev);
					  st.push(last);
						val= last+prev;
						
						 st.push(val);
							
							size++;
					}
			}
		}
		
		//System.out.println(st.size());
		for(int i=1;i<=st.size();i++) {
			sum=sum+st.peek(i);
		}
		System.out.println(sum);
		
	}


}
