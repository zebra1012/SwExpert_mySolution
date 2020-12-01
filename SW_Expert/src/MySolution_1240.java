import java.io.FileInputStream;
import java.util.Scanner;

/*
 * [�Է�]

���� ù���� ��ü �׽�Ʈ ���̽��� ���̴�.

�� �׽�Ʈ ���̽��� ù �ٿ� �� �ڿ����� �־����µ� ���� �迭�� ���� ũ�� N, �迭�� ����ũ�� M�̴� (1��N<50, 1��M<100).

�� ���� N���� �ٿ��� M���� �迭�� ���� �־�����.

[���]

�� �׽�Ʈ ���̽��� ���� ������� ǥ��������� ����ϸ�, �� ���̽����� ���� ���ۿ� ��#C���� ����Ͽ��� �Ѵ�.

�̶� C�� ���̽��� ��ȣ�̴�. ���� �ٿ� ��ĭ�� �ϳ� �ΰ�, �Է¿� �־��� �迭���� �������� ��ȣ�ڵ�鿡 ���Ե� ���ڵ��� ���� ����Ѵ�.
 */
public class MySolution_1240 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int m = sc.nextInt();
			// ��ȣ���� ���Ե� ���ڿ� ã��
			String s = "";
			for (int i = 0; i < N; i++) {
				String ss = sc.next();
				if (ss.contains("1"))
					s = ss;
			}
			// ��ȣ�� ã��
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
			// ��ȣ�� ����
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