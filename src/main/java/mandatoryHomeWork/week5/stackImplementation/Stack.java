package stackImplementation;

public class Stack {

	private int size=100;
	
	private Character stack[] = new Character[size];
	
	public int top=0;
	
	//push
	public boolean push(Character ele) {
		if(top<size) {
			stack[top]=ele;
			top++;
			return true;
		}
		return false;
	}
	
	//pop --> just moving the top pointer to one step down so that it can be overridden when push is done
	public Character pop() {
		if(top!=0) {
			//top=top-1;
		//stack[top-1]=null;
		Character ele= stack[--top];
		//top--;
		return ele;
		}
		return null;
	}
	
	//peek --> reading the top most element and returning back
	public Character peek() {
		
		if(top!=0) {
			//top=top-1;
			return stack[top-1];
		}
		return null;
	}
	public Character peekUsingIndex(int index) {
		
		if(top!=0) {
			top=top-index;
			return stack[top];
		}
		return null;
	}
	
	public Character read(int index) {
		
		if(top!=0) {
			//top=top-1;
			return stack[top-index];
		}
		return null;
	}
	
	public Character peek(int index) {
		
		if(top!=0) {
			//top=top-1;
			return stack[top-
			             index];
		}
		return null;
	}
	public Integer size() {
		/*int count=0;
		StackInt st=new StackInt();
		while(top!=0) {
			st.pop();
			count++;
		}
		return count;*/
		return top;
	}
	
	
}
