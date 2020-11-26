import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MySolution_10580 {

	/*
	 * [입력]
	 * 
	 * 첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다. 각 테스트 케이스는 다음과
	 * 같이 구성되었다.
	 * 
	 * 첫 번째 줄에 주어지는 전선의 개수 N이 주어진다 (1 ≤ N ≤1000).
	 * 
	 * 이후 N개의 줄에 두 양의 정수 Ai, Bi 가 주어진다. (1 ≤ Ai, Bi ≤ 10000)이는 i번째 전선이, 첫번째 전봇대의 Ai
	 * cm 고도에 걸려 있고, 두 번째 전봇대의 Bi cm 고도에 걸려 있음을 뜻한다.
	 * 
	 * 모든 Ai는 서로 다르고, 모든 Bi 도 서로 다르다. (두 전선의 끝점이 같은 경우가 없기 때문이다.) 세 전선이 한 점에서 만나지 않게
	 * 입력이 주어진다.
	 * 
	 * 
	 * 
	 * [출력] 각 테스트 케이스마다 한 줄씩 교차점의 개수를 출력하라.
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int count = 0;
			String[] arr = new String[sc.nextInt()];
			Line[] line_arr = new Line[arr.length];
			sc.nextLine();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextLine();
				line_arr[i] = new Line(arr[i]);
			}
			for (int i = 0; i < line_arr.length; i++) {
				for (int k = i + 1; k < line_arr.length; k++) {
					count += line_arr[i].compare_line(line_arr[k]);
				}
			}
			System.out.printf("#%d %d\n", test_case, count);

		}
	}
}

class Line {
	int left;
	int right;

	public Line(String Raw) {
		String[] arr = Raw.split(" ");
		left = Integer.parseInt(arr[0]);
		right = Integer.parseInt(arr[1]);
	}

	public int compare_line(Line newOne) {
		if (left > newOne.left) {
			if (right < newOne.right) {// 범위안에 포함됨, 교점이 생성된다.
				return 1;
			}
		} else {
			if (right > newOne.right) { // 교점이 생성된다.
				return 1;
			}
		}
		return 0;
	}
}