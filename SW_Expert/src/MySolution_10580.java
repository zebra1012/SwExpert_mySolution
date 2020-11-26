import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MySolution_10580 {

	/*
	 * [�Է�]
	 * 
	 * ù ��° �ٿ� �׽�Ʈ ���̽��� �� TC�� �־�����. ���� TC���� �׽�Ʈ ���̽��� �� �ٷ� ���еǾ� �־�����. �� �׽�Ʈ ���̽��� ������
	 * ���� �����Ǿ���.
	 * 
	 * ù ��° �ٿ� �־����� ������ ���� N�� �־����� (1 �� N ��1000).
	 * 
	 * ���� N���� �ٿ� �� ���� ���� Ai, Bi �� �־�����. (1 �� Ai, Bi �� 10000)�̴� i��° ������, ù��° �������� Ai
	 * cm ���� �ɷ� �ְ�, �� ��° �������� Bi cm ���� �ɷ� ������ ���Ѵ�.
	 * 
	 * ��� Ai�� ���� �ٸ���, ��� Bi �� ���� �ٸ���. (�� ������ ������ ���� ��찡 ���� �����̴�.) �� ������ �� ������ ������ �ʰ�
	 * �Է��� �־�����.
	 * 
	 * 
	 * 
	 * [���] �� �׽�Ʈ ���̽����� �� �پ� �������� ������ ����϶�.
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int count = 0;
			String[] arr = new String[sc.nextInt()];
			Line[] line_arr = new Line[arr.length];
			sc.nextLine();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextLine();
				line_arr[i] = new Line(arr[i]);
			}
			for (int i = 0; i < line_arr.length; i++) {
				for (int k = i + 1; k < line_arr.length; k++) {
					count += line_arr[i].compare_line(line_arr[k]);
				}
			}
			System.out.printf("#%d %d\n", test_case, count);

		}
	}
}

class Line {
	int left;
	int right;

	public Line(String Raw) {
		String[] arr = Raw.split(" ");
		left = Integer.parseInt(arr[0]);
		right = Integer.parseInt(arr[1]);
	}

	public int compare_line(Line newOne) {
		if (left > newOne.left) {
			if (right < newOne.right) {// �����ȿ� ���Ե�, ������ �����ȴ�.
				return 1;
			}
		} else {
			if (right > newOne.right) { // ������ �����ȴ�.
				return 1;
			}
		}
		return 0;
	}
}