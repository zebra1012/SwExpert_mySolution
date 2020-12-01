import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_7102 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 카드 생성
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr_N = makeCard(N);
			int[] arr_M = makeCard(M);
			// 조합을 배열에 저장
			int[] N_add_M = combination(arr_N, arr_M);
			// 답
			String answer = getAnswer(N_add_M);
			// 출력
			System.out.printf("#%d %s\n", test_case, answer);

		}
	}

	// 카드생성
	public static int[] makeCard(int N) {
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		return arr;
	}

	// 조합을 배열에 저장
	public static int[] combination(int[] A, int[] B) {
		int[] A_add_B = new int[A.length + B.length];
		int max = 0; // 첫 번째 인덱스부터 N+M번쨰인덱스까지 사용 0번 인덱스는 최대값 저장
		for (int i = 0; i < A.length; i++) {
			for (int k = 0; k < B.length; k++) {
				A_add_B[i + k + 1]++;
				if (max < A_add_B[i + k + 1])
					max = A_add_B[i + k + 1];
			}
		}
		A_add_B[0] = max;
		return A_add_B;
	}

	public static String getAnswer(int[] A_add_B) {
		int max = A_add_B[0];
		String s = "";
		for (int i = 1; i < A_add_B.length; i++) {
			if (A_add_B[i] == max) {
				s = s + (i + 1) + " ";
			}
		}
		return s;
	}
}