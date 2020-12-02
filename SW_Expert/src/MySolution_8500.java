import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class MySolution_8500 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\Users\\pipyrus\\downloads\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int answer = 0;
			int[] arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr); // 최소값을 찾기 위해 정렬
			for (int i = 0; i < arr.length; i++) {
				if (i == 0) {
					answer += 2 * arr[i] + 1;
				} else {
					answer += 2 * arr[i] + 1 - arr[i - 1];
				}
			}

			System.out.printf("#%d %d\n", test_case, answer);

		}
	}
}