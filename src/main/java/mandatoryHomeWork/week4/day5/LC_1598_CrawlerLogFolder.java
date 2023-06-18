package week4.day5;

import java.util.Stack;



public class LC_1598_CrawlerLogFolder{

	
	  public int minOperations(String[] logs) {
       Stack st=new Stack();
		
		for(int i=0;i<logs.length;i++) {
		 
			if(logs[i].contains("./")) {
			System.out.println("do nothing");
			}
			else if(logs[i].contains("../") && st.isEmpty()) {
				System.out.println("pop");
				st.pop();
			}
			//can push anything
			else {
				st.push(1);
			}
		}
		
	//	System.out.println(st.size());
		return st.size();
	}
}
