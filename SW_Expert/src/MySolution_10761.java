import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_10761 {
	/*
	 * [�Է�]
	 * 
	 * ù ��° �ٿ� �׽�Ʈ ���̽��� �� TC�� �־�����. ���� TC���� �׽�Ʈ ���̽��� �� �ٷ� ���еǾ� �־�����.
	 * 
	 * �� �׽�Ʈ ���̽��� ������ ���� �����Ǿ���.
	 * 
	 * 1. ù ��° ������ �׽�Ʈ���� ������ �ϴ� ��ư�� ���� N �̴�. (1 <= N <= 100)
	 * 
	 * 2. ���� ��ư N���� �������� ���еǾ� �� �ٿ� �־�����. ��ư�� ��O x�� �� �����̸� �������� ��ư x�� ������ �ϸ�, ��B x����
	 * �����̸� ��簡 ��ư x�� ������ �Ѵ�. (1 <= x <= 100)
	 * 
	 * 
	 * [���]
	 * 
	 * �� �׽�Ʈ ���̽����� �ּ� �ð��� ����϶�.
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();//���� ����
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.nextLine(); // �־��� ����
			String[] s_arr = s.split(" ");
			Robot Orange = new Robot(1, 0);
			Robot Blue = new Robot(1, 0);
			int second = 0;
			for (int i = 1; i < s_arr.length; i += 2) { // i��°�� ��ư�� ��ġ, i+1��°�� ��ư�� ���� �κ�
				if (s_arr[i].equals("O")) {
					if (second - Orange.last_action > Math.abs(Integer.parseInt(s_arr[i + 1]) - Orange.location)) {
						// s_arr[i]-location �̵��ؾ� �� �Ÿ�
						// second-last_action ������ �ൿ ���ķ� ���� �ð�
						// �̵��ؾ� �� �Ÿ��� ������ �ൿ ���ķ� ���� �ð����� ª���� �̹� �ش� ��ġ�� �ִ�.
						second++; // ��ư �Է�
						Orange.last_action = second;
						Orange.location = Integer.parseInt(s_arr[i + 1]);
					} else { // ��� �� �̵��ؾ� �Ѵ�.
						second = Math.abs(Integer.parseInt(s_arr[i + 1]) - Orange.location) + Orange.last_action + 1;
						// �ð�=�̵��ؾ��ϴ°Ÿ�+�������ൿ�ð�+��ư �Է� �ð�
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