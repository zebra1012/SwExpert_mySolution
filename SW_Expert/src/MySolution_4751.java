import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_4751 {
	/*
	 * [�Է�]
	 * 
	 * ù ��° �ٿ� �׽�Ʈ ���̽��� �� T�� �־�����.
	 * 
	 * �� �׽�Ʈ ���̽��� ù ��° �ٿ��� ���̰� 1�̻� 50������ ���ڿ��� �־�����.
	 * 
	 * [���]
	 * 
	 * �� �׽�Ʈ ���̽����� �ټ� �ٿ� ���� ��ĵ� ���ڿ��� ����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.next(); // ǥ���Ϸ��� ���ڿ�
			int width = 5 + 4 * (s.length() - 1);
			int index = 0;
			char[][] arr = new char[5][width];
			for (int i = 0; i < arr.length; i++) { // �迭 ��� ���Ҹ� '.'�� �ʱ�ȭ
				for (int k = 0; k < arr[i].length; k++) {
					arr[i][k] = '.';
				}
			} // �迭 �ʱ�ȭ �ڵ� ����

			for (int i = 0; i < arr.length; i++) { // �迭 ä���
				for (int k = 0; k < arr[i].length; k++) {
					if (i == 0 || i == 4) { // 1�� 5�� 2, 6, 10 ...
						if (4 * k + 2 < width)
							arr[i][4 * k + 2] = '#';
					} else if (i == 1 || i == 3) { // 2�� 4�� 1,3,5,7,9..
						if (2 * k + 1 < width)
							arr[i][2 * k + 1] = '#';
					} else { // 3�� 0 2 4 6 8 ... ¦����°���� ���ڰ� ����.
						if (2 * k < width) {
							arr[i][2 * k] = '#';
							if (k % 2 == 1) {
								arr[i][2 * k] = s.charAt(index);
								index++;
							}
						}
					}
				}
			} // �迭 ä��� �ڵ� ����

			for (int i = 0; i < arr.length; i++) { // ��� �ڵ�
				for (int k = 0; k < arr[i].length; k++) {
					System.out.print(arr[i][k]);
				}
				System.out.println();
			} // ��� �ڵ� ����
		} // �׽�Ʈ ���̽� ��ȸ ����
	}
}