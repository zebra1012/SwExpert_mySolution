import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_10965 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\Users\\pipyrus\\downloads\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int A = sc.nextInt();
			int answer = 0;
			double d = Math.sqrt(A);
			if (d % 1 == 0)
				answer = 1;
			else {
				for (int i = 2; Math.pow(10, 7) > Math.pow(i, 2); i++) {
					if (A % (int) Math.pow(i, 2) == 0) {
						A /= (int) Math.pow(i, 2);
					}
				}
			}
			answer = A;
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}
