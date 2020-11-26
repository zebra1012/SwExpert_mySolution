import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
 * [입력]
첫 번째 줄에 테스트 케이스의 수 TC가 주어진다.
이후 TC개의 테스트 케이스는 각각 다음과 같은 구성과 조건을 따른다.

        > 첫 번째 줄에 주어지는 정수의 개수 N 이 주어진다. (1 ≤ N ≤ 1000)

        > 두 번째 줄에 N개의 양의 정수가 주어진다. 이 정수들은 각각 1 이상 10000 이하이다. 이 정수들은 모두 서로 다르다.
        
[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

각 테스트 케이스마다 최고의 쌍의 두 수의 곱을 출력한다.
만약, 제약 조건을 만족하는 쌍이 존재하지 않는 경우는 -1을 출력한다.

 
 */
public class MySolution_9480 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = -1;
			int[] arr = new int[sc.nextInt()]; // 배열 크기
			for (int i = 0; i < arr.length; i++) {
				arr[i] = -sc.nextInt();
			}
			Arrays.sort(arr);
			for (int i = 0; i < arr.length; i++) {
				for (int k = i + 1; k < arr.length; k++) {
					int x = arr[i] * arr[k];
					if (x > 123456789)
						continue;
					char[] s_arr = String.valueOf(x).toCharArray();
					boolean flag = judge(s_arr);
					if (flag && x > answer) {
						answer = x;
						break;
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	public static boolean judge(char[] s_arr) {
		for (int i = 1; i < s_arr.length; i++) {
			int num = s_arr[i - 1];
			if (num + 1 == s_arr[i])
				continue;
			else
				return false;

		}
		return true;
	}
}
