package stackImplementation;


public class StackInt {

	public int size=50;
	
	public Integer stack[] = new Integer[size];
	
	public int top=0;
	
	//push
	public boolean push(Integer ele) {
		if(top<size) {
			stack[top]=ele;
			top++;
			return true;
		}
		return false;
	}
	
	//pop --> just moving the top pointer to one step down so that it can be overridden when push is done
	public Integer pop() {
		if(top!=0) {
			//top=top-1;
		//stack[top-1]=null;
			Integer ele= stack[top-1];
		top--;
		return ele;
		}
		return null;
	}
	
	//peek --> reading the top most element and returning back
	//written the peek method to read the value based on index, if we didn't give the argumant as index, we can get only last index value
	public Integer peek() {
		
		if(top!=0) {
			//top=top-1;
			return stack[top-1];
		}
		return null;
	}
	
	//To read all the element in the stack based on given input
	public Integer peek(int index) {
		
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
