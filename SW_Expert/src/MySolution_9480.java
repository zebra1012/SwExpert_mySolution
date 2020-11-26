import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
 * [�Է�]
ù ��° �ٿ� �׽�Ʈ ���̽��� �� TC�� �־�����.
���� TC���� �׽�Ʈ ���̽��� ���� ������ ���� ������ ������ ������.

        > ù ��° �ٿ� �־����� ������ ���� N �� �־�����. (1 �� N �� 1000)

        > �� ��° �ٿ� N���� ���� ������ �־�����. �� �������� ���� 1 �̻� 10000 �����̴�. �� �������� ��� ���� �ٸ���.
        
[���]

�� �׽�Ʈ ���̽����� ��#x��(x�� �׽�Ʈ���̽� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�)�� ����ϰ�,

�� �׽�Ʈ ���̽����� �ְ��� ���� �� ���� ���� ����Ѵ�.
����, ���� ������ �����ϴ� ���� �������� �ʴ� ���� -1�� ����Ѵ�.

 
 */
public class MySolution_9480 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = -1;
			int[] arr = new int[sc.nextInt()]; // �迭 ũ��
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
