import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_7102 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// ī�� ����
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr_N = makeCard(N);
			int[] arr_M = makeCard(M);
			// ������ �迭�� ����
			int[] N_add_M = combination(arr_N, arr_M);
			// ��
			String answer = getAnswer(N_add_M);
			// ���
			System.out.printf("#%d %s\n", test_case, answer);

		}
	}

	// ī�����
	public static int[] makeCard(int N) {
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		return arr;
	}

	// ������ �迭�� ����
	public static int[] combination(int[] A, int[] B) {
		int[] A_add_B = new int[A.length + B.length];
		int max = 0; // ù ��° �ε������� N+M�����ε������� ��� 0�� �ε����� �ִ밪 ����
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