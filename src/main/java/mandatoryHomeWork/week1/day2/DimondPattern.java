package week1.day2;

public class DimondPattern {
/*
 * Combine the upper triangle and lower triangle
 * Reduce the length of outer loop in any one of the part
 * 
 */
	public static void main(String[] args) {
		int n=5;
		for (int i = 1; i <= n-1; i++) {
			for (int j = 1; j <= n + 1 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = n; i >=1; i--) {
			for (int j = 1; j <= n + 1 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
