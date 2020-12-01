import java.io.FileInputStream;
import java.util.Scanner;

/*
 * [입력]

가장 첫줄은 전체 테스트 케이스의 수이다.

각 테스트 케이스의 첫 줄에 두 자연수가 주어지는데 각각 배열의 세로 크기 N, 배열의 가로크기 M이다 (1≤N<50, 1≤M<100).

그 다음 N개의 줄에는 M개의 배열의 값이 주어진다.

[출력]

각 테스트 케이스의 답을 순서대로 표준출력으로 출력하며, 각 케이스마다 줄의 시작에 “#C”를 출력하여야 한다.

이때 C는 케이스의 번호이다. 같은 줄에 빈칸을 하나 두고, 입력에 주어진 배열에서 정상적인 암호코드들에 포함된 숫자들의 합을 출력한다.
 */
public class MySolution_1240 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int m = sc.nextInt();
			// 암호문이 포함된 문자열 찾기
			String s = "";
			for (int i = 0; i < N; i++) {
				String ss = sc.next();
				if (ss.contains("1"))
					s = ss;
			}
			// 암호문 찾기
			char[] arr = s.toCharArray();
			String password = "";
			boolean flag = false;
			int count = 0;
			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[i] == '1') {
					flag = true;
				}
				if (flag && count < 56) {
					count++;
					password = arr[i] + password;
				}
			}
			// System.out.println(password);
			// 암호문 판정
			int[] nums = new int[8];
			int index = 0;
			for (int i = 0; i < password.length(); i += 7) {
				String temp = "";
				if (i + 8 >= password.length())
					temp = password.substring(i);
				else
					temp = password.substring(i, i + 7);
				int num = getnum(temp);
				nums[index] = num;
				index++;

			}
			if (((nums[0] + nums[2] + nums[4] + nums[6]) * 3 + nums[1] + nums[3] + nums[5] + nums[7]) % 10 == 0) {
				System.out.printf("#%d %d\n", test_case,
						nums[0] + nums[1] + nums[2] + nums[3] + nums[4] + nums[5] + nums[6] + nums[7]);
			} else
				System.out.printf("#%d %d\n", test_case, 0);
		}
	}

	public static int getnum(String temp) {
		int num = -1;
		if (temp.equals("0001101"))
			num = 0;
		else if (temp.equals("0011001"))
			num = 1;
		else if (temp.equals("0010011"))
			num = 2;
		else if (temp.equals("0111101"))
			num = 3;
		else if (temp.equals("0100011"))
			num = 4;
		else if (temp.equals("0110001"))
			num = 5;
		else if (temp.equals("0101111"))
			num = 6;		else if (temp.equals("0111011"))
			num = 7;
		else if (temp.equals("0110111"))
			num = 8;
		else if (temp.equals("0001011"))
			num = 9;
		return num;
	}
}