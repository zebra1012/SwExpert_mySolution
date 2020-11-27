import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_2805 {
	/*
	 * [���� ����]
	 * 
	 * ������ ũ�� N�� 1 �̻� 49 ������ Ȧ���̴�. (1 �� N �� 49)
	 * 
	 * ���۹��� ��ġ�� 0~5�̴�.
	 * 
	 * 
	 * [�Է�]
	 * 
	 * ���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.
	 * 
	 * �� �׽�Ʈ ���̽����� ������ ũ�� N�� ���� �� ���۹��� ��ġ�� �־�����.
	 * 
	 * 
	 * [���]
	 * 
	 * �� ���� '#t'�� �����ϰ�, �������� ������ ��Ģ�� ���� ���� �� �ִ� ������ ����Ѵ�.
	 * 
	 * (t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			char a = '1';
			int N = sc.nextInt(); // ������ ũ��
			char[][] farm = new char[N][N];
			for (int i = 0; i < N; i++) {
				farm[i] = sc.next().toCharArray();
			}
			int value = getValue(farm, N);
			System.out.printf("#%d %d\n", test_case, value);
		}
	}

	public static int getValue(char[][] farm, int N) { // ������ ��ġ ���� ����
		int sum = 0;
		int baseline = N / 2; // �߰� ���ؼ�
		int start = 0;
		int end = N - 1;
		for (; start <= end;) {
			for (int i = start; i <= end; i++) { // �� ���� �ش� ���� ���� ���ؼ� ��
				sum += farm[baseline][i] - 48;
			}
			baseline--;
			start++;
			end--;
		}

		baseline = N / 2 + 1;
		start = 1;
		end = N - 2;
		for (; start <= end;) {
			for (int i = start; i <= end; i++) { // �� ���� �ش� ���� ���� ���ؼ� �Ʒ�
				sum += farm[baseline][i] - 48;
			}
			baseline++;
			start++;
			end--;
		}
		return sum;
	}
}