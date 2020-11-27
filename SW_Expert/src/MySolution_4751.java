import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_4751 {
	/*
	 * [입력]
	 * 
	 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
	 * 
	 * 각 테스트 케이스의 첫 번째 줄에는 길이가 1이상 50이하인 문자열이 주어진다.
	 * 
	 * [출력]
	 * 
	 * 각 테스트 케이스마다 다섯 줄에 걸쳐 장식된 문자열을 출력한다.
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.next(); // 표현하려는 문자열
			int width = 5 + 4 * (s.length() - 1);
			int index = 0;
			char[][] arr = new char[5][width];
			for (int i = 0; i < arr.length; i++) { // 배열 모든 원소를 '.'로 초기화
				for (int k = 0; k < arr[i].length; k++) {
					arr[i][k] = '.';
				}
			} // 배열 초기화 코드 종료

			for (int i = 0; i < arr.length; i++) { // 배열 채우기
				for (int k = 0; k < arr[i].length; k++) {
					if (i == 0 || i == 4) { // 1열 5열 2, 6, 10 ...
						if (4 * k + 2 < width)
							arr[i][4 * k + 2] = '#';
					} else if (i == 1 || i == 3) { // 2열 4열 1,3,5,7,9..
						if (2 * k + 1 < width)
							arr[i][2 * k + 1] = '#';
					} else { // 3열 0 2 4 6 8 ... 짝수번째에는 문자가 들어간다.
						if (2 * k < width) {
							arr[i][2 * k] = '#';
							if (k % 2 == 1) {
								arr[i][2 * k] = s.charAt(index);
								index++;
							}
						}
					}
				}
			} // 배열 채우기 코드 종료

			for (int i = 0; i < arr.length; i++) { // 출력 코드
				for (int k = 0; k < arr[i].length; k++) {
					System.out.print(arr[i][k]);
				}
				System.out.println();
			} // 출력 코드 종료
		} // 테스트 케이스 순회 종료
	}
}