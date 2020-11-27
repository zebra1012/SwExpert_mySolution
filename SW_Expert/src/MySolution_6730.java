import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;
/*
 * [�Է�]

ù ��° �ٿ� �׽�Ʈ ���̽��� �� T�� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� ���簢�� ����� ������ ��Ÿ���� �ϳ��� ���� N ( 2 �� N �� 100 )�� �־�����.

�� ��° �ٿ��� N���� ������ �������� ���еǾ� �־�����.

�̴� ���簢�� ����� ���̸� ����� �þ ������� ��Ÿ�� ���̴�.

�� ����� ���̴� 1�̻� 1,000�����̴�.
 


[���]

�� �׽�Ʈ ���̽����� ��#x��(x�� �׽�Ʈ���̽� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�)�� ����ϰ� �� ĭ�� ��� ��,

�ö� �� ���� ���� ���� ��ȭ�� ������ �� ���� ���� ���� ��ȭ�� ���� �ϳ��� �����Ͽ� ����Ѵ�.

���� �ö󰡴� �κ��̳� �������� �κ��� ���ٸ�, 0�� ����ϸ� �ȴ�.
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
					if (temp > k) { // ���� �ִ� ĭ�� �� ����
						if (down < temp - k)
							down = temp - k;
					} else { // ���� �ִ� ĭ�� �� ����
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