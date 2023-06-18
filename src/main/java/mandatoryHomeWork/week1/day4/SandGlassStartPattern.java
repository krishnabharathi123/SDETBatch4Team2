package week1.day4;

public class SandGlassStartPattern {

	public static void main(String[] args) {
	
		int n=5;

		for (int i = n; i >=1; i--) {
			for (int j = 1; j <= n + 1 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i <= n; i++) {
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
