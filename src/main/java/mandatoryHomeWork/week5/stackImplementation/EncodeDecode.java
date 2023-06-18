package stackImplementation;

import org.junit.Test;

public class EncodeDecode {

	@Test
	public void positive() {
		String str="3[a2[bc]]";
		decodeString(str);
	}

	private void decodeString(String str) {
		Stack st=new Stack();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)!=']') {
				st.push(str.charAt(i));
			}
			else if(str.charAt(i)==']') {
				int num=i;
				String temp="";
				int k;
				//cb
				while(str.charAt(num)!='[') {
					Character pop = st.pop();
					temp=pop+temp;//bc
					//num--;
				}
				//st.pop();
				k=st.pop()-48;//'0'
				System.out.println(temp);
				System.out.println(k);
			}
		}
		
	}
}
