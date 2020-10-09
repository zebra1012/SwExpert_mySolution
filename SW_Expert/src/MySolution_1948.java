import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Scanner;

public class MySolution_1948 {
/*
[���� ����]

���� 1 �̻� 12 ������ �����̴�. �� ���� ������ ��¥�� ������ ����.

1/31, 2/28, 3/31, 4/30, 5/31, 6/30, 7/31, 8/31, 9/30, 10/31, 11/30, 12/31

�� ��° ��¥�� ù ��° ��¥���� �׻� ũ�� �־�����.


[�Է�]

���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� 4���� ���� �־�����.

ù ��° ���� ���� ��Ÿ���� �� ��° ���� ���� ��Ÿ����. �� ���� ���� �������� �� ��° ��¥�� �־�����.


[���]

����� �� ���� '#t'�� �����ϰ�, ������ �� ĭ �� ���� ������ ����Ѵ�. (t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("D:\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			Calendar c1= Calendar.getInstance();
			Calendar c2= Calendar.getInstance();
			int month = sc.nextInt();//ù ��° ��
			int date = sc.nextInt();//�� ��° ��
			c1.set(2019, month-1, date); //ù ��° ��¥ , ������ ���� �� ����
			month=sc.nextInt();//�� ��° ��
			date=sc.nextInt(); //�� ��° ��
			c2.set(2019,month-1,date); //�� ��° ��¥;
			int count=0;
			while(c2.compareTo(c1)>=0) { //c2�� c1���� ũ�� 0���� ũ�� ������ 0, ������ 0���� �۴�.
				count++;
				c1.add(Calendar.DAY_OF_MONTH, 1);
			}
			System.out.printf("#%d %d\n", test_case,count);
		}
	}
}

