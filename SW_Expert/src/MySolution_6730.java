import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;
/*
 * [입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 직사각형 블록의 개수를 나타내는 하나의 정수 N ( 2 ≤ N ≤ 100 )이 주어진다.

두 번째 줄에는 N개의 정수가 공백으로 구분되어 주어진다.

이는 직사각형 블록의 높이를 블록이 늘어선 순서대로 나타낸 것이다.

각 블록의 높이는 1이상 1,000이하이다.
 


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,

올라갈 때 가장 심한 높이 변화와 내려갈 때 가장 심한 높이 변화를 공백 하나로 구분하여 출력한다.

만약 올라가는 부분이나 내려가는 부분이 없다면, 0을 출력하면 된다.
 */
public class MySolution_6730 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int climb = 0;
			int down = 0;
			Stack<Integer> st = new <Integer>Stack();
			for (int i = 0; i < N; i++) {
				int k = sc.nextInt();
				if (!st.empty()) {
					int temp = st.peek();
					if (temp > k) { // 현재 있는 칸이 더 높음
						if (down < temp - k)
							down = temp - k;
					} else { // 현재 있는 칸이 더 낮음
						if (climb < k - temp)
							climb = k - temp;
					}
				}
				st.push(k);
			}
			System.out.printf("#%d %d %d\n", test_case, climb, down);
		}
	}
}