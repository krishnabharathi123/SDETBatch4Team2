package week1.day1;

public class SquareRoot {

	public static void main(String[] args) {

		int num = 16;
		int i = 0;
		double j = 0.001;
		for (; i < num / 2; i++) {

			if ((i * i) == num) {
				System.out.println(i);
				break;
			}

			else if ((i * i) > num) {
				i--;

				while (((i * j) * (i * j)) != num) {
					j=j+0.001;

				}
				System.out.println(i * j);
				break;
			}

		}

	}

}
