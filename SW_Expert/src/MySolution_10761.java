import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_10761 {
	/*
	 * [입력]
	 * 
	 * 첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.
	 * 
	 * 각 테스트 케이스는 다음과 같이 구성되었다.
	 * 
	 * 1. 첫 번째 정수는 테스트에서 눌러야 하는 버튼의 개수 N 이다. (1 <= N <= 100)
	 * 
	 * 2. 이후 버튼 N개가 공백으로 구분되어 한 줄에 주어진다. 버튼이 “O x” 의 형태이면 오렌지가 버튼 x를 눌러야 하며, “B x”의
	 * 형태이면 블루가 버튼 x를 눌러야 한다. (1 <= x <= 100)
	 * 
	 * 
	 * [출력]
	 * 
	 * 각 테스트 케이스마다 최소 시간을 출력하라.
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();//다음 라인
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.nextLine(); // 주어진 순서
			String[] s_arr = s.split(" ");
			Robot Orange = new Robot(1, 0);
			Robot Blue = new Robot(1, 0);
			int second = 0;
			for (int i = 1; i < s_arr.length; i += 2) { // i번째는 버튼의 위치, i+1번째는 버튼을 누를 로봇
				if (s_arr[i].equals("O")) {
					if (second - Orange.last_action > Math.abs(Integer.parseInt(s_arr[i + 1]) - Orange.location)) {
						// s_arr[i]-location 이동해야 할 거리
						// second-last_action 마지막 행동 이후로 지난 시간
						// 이동해야 할 거리가 마지막 행동 이후로 지난 시간보다 짧으면 이미 해당 위치에 있다.
						second++; // 버튼 입력
						Orange.last_action = second;
						Orange.location = Integer.parseInt(s_arr[i + 1]);
					} else { // 길면 더 이동해야 한다.
						second = Math.abs(Integer.parseInt(s_arr[i + 1]) - Orange.location) + Orange.last_action + 1;
						// 시간=이동해야하는거리+마지막행동시간+버튼 입력 시간
						Orange.last_action = second;
						Orange.location = Integer.parseInt(s_arr[i + 1]);
					}
				} else {
					if (second - Blue.last_action > Math.abs(Integer.parseInt(s_arr[i + 1]) - Blue.location)) {
						second++;
						Blue.last_action = second;
						Blue.location = Integer.parseInt(s_arr[i + 1]);
					} else {
						second = Math.abs(Integer.parseInt(s_arr[i + 1]) - Blue.location) + Blue.last_action + 1;
						Blue.last_action = second;
						Blue.location = Integer.parseInt(s_arr[i + 1]);
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, second);
		}
	}
}

class Robot {
	int location;
	int last_action;

	public Robot(int location, int last_action) {
		this.location = location;
		this.last_action = last_action;
	}
}