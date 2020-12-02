import java.util.Arrays;
import java.util.Scanner;

public class MySolution_7985 {
	/*
	 * [입력]
	 * 
	 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
	 * 
	 * 각 테스트 케이스의 첫 번째 줄에는 완전 이진 트리의 깊이 K(1 ≤ K ≤ 10) 이 주어진다.
	 * 
	 * 두 번째 줄에는 [1,2^K-1] 사이의 자연수들이 한 번씩 모두 나타난다.
	 * 
	 * 
	 * [출력]
	 * 
	 * 각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
	 * 
	 * 각 테스트 케이스마다 레벨 별로 왼쪽부터 정점 번호를 출력하라.
	 */
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int index = 0;
			int K = sc.nextInt();
			String[] answer = new String[K]; // 최대 K단계까지 존재
			// 입력
			sc.nextLine();
			String s = sc.nextLine();
			// 답 도출
			String[] s_arr = s.split(" ");
			answer = getLevel(answer, s_arr, 0);
			// 출력
			System.out.printf("#%d ", test_case);
			for (int i = 0; i < answer.length; i++) {
				System.out.printf("%s\n", answer[i]);
			}
		}
	}

	public static String[] getLevel(String[] answer, String[] s_arr, int index) {
		// s_arr의 가운데 값은 index레벨의 정점이므로 index번째 answer에 저장한다.
		if (answer[index] == null)
			answer[index] = s_arr[s_arr.length / 2]; // null이면(최초저장이면) 바로 저장
		else
			answer[index] += " " + s_arr[s_arr.length / 2]; // 이미 있으면 공백 추가
		String[] s1 = Arrays.copyOfRange(s_arr, 0, s_arr.length / 2); // 가운데값 기준 왼쪽 배열
		String[] s2 = Arrays.copyOfRange(s_arr, s_arr.length / 2 + 1, s_arr.length); // 오른쪽 배열
		if (index == answer.length - 1) {
		} // 마지막 단계까지 봤으면 answer 리턴
		else { // 아니면 다음 단계
			answer = getLevel(answer, s1, index + 1);
			answer = getLevel(answer, s2, index + 1);
		}
		return answer;
	}
}