package week1.day5;

public class DiamondCharacter {

	//Time Complexity ---> O(n)*O(m+k)==> O(n)*O(2n)==> O(n)*O(n)==> O(n^2) ---> Upper part of diamond 
	//Upper Part+Lower Part ==> O(n^2)+O(n^2)==> O(2n^2)==> O(n^2)
	
	public static void main(String[] args) {
		char ch=65;
		int m=0;
		int n=7;
		//to execute the 1st part from A to F..reverse loop
		 for(int i=n;i>=0;i--) { //O(n)
			// to print the initial empty space Ex: i=5-->empty space=5; i=4-->empty space=4 etc..
			for(int j=1;j<=i;j++) { //O(n-1)==> (k)
				System.out.print(" ");
			}
			//to print the character always after space
			System.out.print(ch);
			//to print the space in between 2 characters. 1st row no need space and second char
			//from 2nd row we need space.Ex: i=4 ==> space=1, i=3 ==> space=3, i=2 ==> space=5, i=1==> space=7, i=0==>space=9
			if(i!=n) {
				for(int k=0;k<=m;k++) { //O(m)
					System.out.print(" ");
				}
				//after space printing the character
				System.out.print(ch);
				//incrementing m to 2 in order to fullfil the in betwee space of characters
				m=m+2;
				
			}
			//next line for next row
			System.out.println();
			//incrementing ch++ to get next character in next line
			ch++;
			//System.out.println("888"+ch);
		}
		 
		m=m-3;//10-3=7
		ch-=2;//G-2=E
		//System.out.println(ch+"***");
		 for(int i=1;i<=n;i++) {
			
				for(int j=1;j<=i;j++) {
					System.out.print(" ");
				}

				System.out.print(ch);
				
				if(i!=n) {
					for(int k=0;k<m;k++) {
						System.out.print(" ");
					}

					System.out.print(ch);

					m=m-2;
				}

				System.out.println();
				 ch--;
				
			}
	}

}
