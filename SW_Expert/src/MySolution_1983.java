import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class MySolution_1983 {
 //1983.������ ���� �ű��
/*
[�������]

1. N�� �׻� 10�� ����̸�, 10�̻� 100������ �����̴�. (10 �� N �� 100)

2. K�� 1 �̻� N ������ �����̴�. (1 �� K �� N)

3. K ��° �л��� ������ �ٸ� �л��� ������ ������ ���� �Է����� �־����� �ʴ´�.


[�Է�]

�Է��� ù �ٿ� �� �׽�Ʈ ���̽��� ���� T�� �´�.

���� �ٺ��� �� �׽�Ʈ ���̽��� �־�����.

�׽�Ʈ ���̽��� ù ��° ���� �л��� N ��, ������ �˰���� �л��� ��ȣ K �� �־�����.

�׽�Ʈ ���̽� �� ��° �� ���� ������ �л��� ���� ���� �� ���� ������ �־�����.


[���]

�׽�Ʈ ���̽� t�� ���� ����� ��#t���� ���, �� ĭ ���, ������ ����Ѵ�.

(t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
*/
	public static void main(String[] args) throws Exception {
		String path="C:\\Users\\pipyr\\downloads\\input.txt";
		System.setIn(new FileInputStream(path));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int K = sc.nextInt();
			double[] scores = new double[N];
			for (int i= 0 ; i<N; i++) {
				double total = 0;
				for (int k = 0 ; k<3;k++) {
					double score = sc.nextDouble();
					switch(k) {
					case 0: total=total+score*0.35; break;
					case 1: total=total+score*0.45; break;
					case 2: total=total+score*0.2;
					}
				}
				scores[i]=-total; //������ ���� ��ȣ �ٲ�
			}
			double target = scores[K-1];
			Arrays.sort(scores);
			int rank=Arrays.binarySearch(scores, target);
			String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
			int count= N/10; //�� ������ �ο���
			for (int i = 0 ; i<grade.length;i++) {
				if(rank>=count*i&&rank<count*(i+1)) {
					System.out.printf("#%d %s\n",test_case,grade[i]);
					break;
				}
			}
		}
	}

}
