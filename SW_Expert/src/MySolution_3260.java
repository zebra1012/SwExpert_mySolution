import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Scanner;
/*
 * �Է�]

ù ��° �ٿ� �׽�Ʈ ���̽��� �� T�� �־�����.

�� �׽�Ʈ ���̽����� ù ��° �ٿ� �� ���� ���� A, B(1 �� A, B< 10^100)�� �������� ���еǾ� �־�����.

�� ���� 0���� ���۵��� �ʴ´�.


[���]

�� �׽�Ʈ ���̽����� A+B���� ����Ѵ�. ù ��° �ڸ��� 0���� �����ؼ��� �� �ȴ�.
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