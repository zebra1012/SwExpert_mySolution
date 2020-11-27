import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_2805 {
	/*
	 * [제약 사항]
	 * 
	 * 농장의 크기 N은 1 이상 49 이하의 홀수이다. (1 ≤ N ≤ 49)
	 * 
	 * 농작물의 가치는 0~5이다.
	 * 
	 * 
	 * [입력]
	 * 
	 * 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
	 * 
	 * 각 테스트 케이스에는 농장의 크기 N과 농장 내 농작물의 가치가 주어진다.
	 * 
	 * 
	 * [출력]
	 * 
	 * 각 줄은 '#t'로 시작하고, 공백으로 농장의 규칙에 따라 얻을 수 있는 수익을 출력한다.
	 * 
	 * (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			char a = '1';
			int N = sc.nextInt(); // 농장의 크기
			char[][] farm = new char[N][N];
			for (int i = 0; i < N; i++) {
				farm[i] = sc.next().toCharArray();
			}
			int value = getValue(farm, N);
			System.out.printf("#%d %d\n", test_case, value);
		}
	}

	public static int getValue(char[][] farm, int N) { // 농지의 가치 합을 구함
		int sum = 0;
		int baseline = N / 2; // 중간 기준선
		int start = 0;
		int end = N - 1;
		for (; start <= end;) {
			for (int i = start; i <= end; i++) { // 각 행의 해당 원소 덧셈 기준선 위
				sum += farm[baseline][i] - 48;
			}
			baseline--;
			start++;
			end--;
		}

		baseline = N / 2 + 1;
		start = 1;
		end = N - 2;
		for (; start <= end;) {
			for (int i = start; i <= end; i++) { // 각 행의 해당 원소 덧셈 기준선 아래
				sum += farm[baseline][i] - 48;
			}
			baseline++;
			start++;
			end--;
		}
		return sum;
	}
}