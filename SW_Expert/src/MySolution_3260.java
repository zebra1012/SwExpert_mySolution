import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Scanner;
/*
 * 입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스마다 첫 번째 줄에 두 양의 정수 A, B(1 ≤ A, B< 10^100)가 공백으로 구분되어 주어진다.

두 수는 0으로 시작되지 않는다.


[출력]

각 테스트 케이스마다 A+B값을 출력한다. 첫 번째 자리가 0으로 시작해서는 안 된다.
 */

public class MySolution_3260 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			{
	            BigInteger A = new BigInteger(sc.next());
	            BigInteger B = new BigInteger(sc.next());
	            A=A.add(B);
	            System.out.printf("#%d %d\n", test_case,A);
	            
			}
		}
	}
}