import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_1976 {
//1976. �ð� ����
/*
[���� ����]

�ô� 1 �̻� 12 ������ �����̴�. ���� 0 �̻� 59 ������ �����̴�.


[�Է�]

���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� 4���� ���� �־�����.

ù ��° ���� �ø� ��Ÿ���� �� ��° ���� ���� ��Ÿ����. �� ���� ���� �������� �� ��° �ð��� �־�����.


[���]

����� �� ���� '#t'�� �����ϰ� ������ �� ĭ �� ����, �ø� ����ϰ� ������ �� ĭ �� ���� ���� ����Ѵ�.

(t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
*/
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\Users\\pipyr\\downloads\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int hour=0;
			int min=0;
			int first_hour = sc.nextInt();
			int first_min = sc.nextInt();
			int second_hour=sc.nextInt();
			int second_min = sc.nextInt();
			hour=first_hour+second_hour;
			min=first_min+second_min;
			if(hour>12) hour-=12;
			if(min>59) {
				hour++;
				min-=60;
			}
			System.out.printf("#%d %d %d\n", test_case,hour,min);
		}
	}
}
/* �� �ð��� ���� ���
  if(first_hour>second_hour) {//ù ��° �ð��� �� Ŭ �� 
		if(first_min>=second_min) {
			hour=first_hour-second_hour;
			min=first_min-second_min;
		}
		else {
			hour=first_hour-second_hour-1;
			min=first_min-second_min+60;
		}
	}
		else if (first_hour<second_hour) { //�� ��° �ð��� �� Ŭ ��
		if(first_min<=second_min) {
			hour=second_hour-first_hour;
			min=second_min-first_min;
		}
		else {
			hour=second_hour-first_hour-1;
			min=second_min-first_min+60;
		}
	}
		else if(first_hour==second_hour) {//�ð� �Ȱ��� ��
		if(first_min<=second_min) {
			min=second_min-first_min;
		}
		else {
			min=first_min-second_min;
		}
	}*/