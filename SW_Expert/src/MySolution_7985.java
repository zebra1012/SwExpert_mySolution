import java.util.Arrays;
import java.util.Scanner;

public class MySolution_7985 {
	/*
	 * [�Է�]
	 * 
	 * ù ��° �ٿ� �׽�Ʈ ���̽��� �� T�� �־�����.
	 * 
	 * �� �׽�Ʈ ���̽��� ù ��° �ٿ��� ���� ���� Ʈ���� ���� K(1 �� K �� 10) �� �־�����.
	 * 
	 * �� ��° �ٿ��� [1,2^K-1] ������ �ڿ������� �� ���� ��� ��Ÿ����.
	 * 
	 * 
	 * [���]
	 * 
	 * �� �׽�Ʈ ���̽����� ��#x��(x�� �׽�Ʈ���̽� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�)�� ����ϰ�,
	 * 
	 * �� �׽�Ʈ ���̽����� ���� ���� ���ʺ��� ���� ��ȣ�� ����϶�.
	 */
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int index = 0;
			int K = sc.nextInt();
			String[] answer = new String[K]; // �ִ� K�ܰ���� ����
			// �Է�
			sc.nextLine();
			String s = sc.nextLine();
			// �� ����
			String[] s_arr = s.split(" ");
			answer = getLevel(answer, s_arr, 0);
			// ���
			System.out.printf("#%d ", test_case);
			for (int i = 0; i < answer.length; i++) {
				System.out.printf("%s\n", answer[i]);
			}
		}
	}

	public static String[] getLevel(String[] answer, String[] s_arr, int index) {
		// s_arr�� ��� ���� index������ �����̹Ƿ� index��° answer�� �����Ѵ�.
		if (answer[index] == null)
			answer[index] = s_arr[s_arr.length / 2]; // null�̸�(���������̸�) �ٷ� ����
		else
			answer[index] += " " + s_arr[s_arr.length / 2]; // �̹� ������ ���� �߰�
		String[] s1 = Arrays.copyOfRange(s_arr, 0, s_arr.length / 2); // ����� ���� ���� �迭
		String[] s2 = Arrays.copyOfRange(s_arr, s_arr.length / 2 + 1, s_arr.length); // ������ �迭
		if (index == answer.length - 1) {
		} // ������ �ܰ���� ������ answer ����
		else { // �ƴϸ� ���� �ܰ�
			answer = getLevel(answer, s1, index + 1);
			answer = getLevel(answer, s2, index + 1);
		}
		return answer;
	}
}