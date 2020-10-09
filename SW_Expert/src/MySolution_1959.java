import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MySolution_1959 {
/*
[���� ����]
N �� M�� 3 �̻� 20 �����̴�.

[�Է�]

���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ� N �� M �� �־�����,

�� ��° �ٿ��� Ai,

�� ��° �ٿ��� Bj �� �־�����.

[���]

����� �� ���� '#t'�� �����ϰ�, ������ �� ĭ �� ���� ������ ����Ѵ�.

(t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\Users\\pipyr\\downloads\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int left=0; int right=0;
			boolean flag=false;
			int max= 0;
			ArrayList AL = new ArrayList();
			int N = sc.nextInt(); int M = sc.nextInt();//N�� M
			int[] AN =new int[N];
			int[] BM =new int[M];
			for (int i = 0 ; i<N; i++) {
				AN[i]=sc.nextInt();
			}
			for (int i = 0 ; i<M;i++) {
				BM[i]=sc.nextInt();
			}
			if(N>M) { //N�� �� �� ��
				left=0;
				right=M-1;
				
			}
			else if (N<M) { //M�� �� �� ��
				left=0;
				right=N-1;
				flag=true;
			}
			if(flag) { //M�� �� �� ��
				while(right<M) {
					int sum=0;
					int index=0;
					for (int i=left ; i<=right;i++) {
						sum+=AN[index]*BM[i];
						index++;
					}
					AL.add(sum);
					left++;
					right++;
				}
			}
			else {
				while(right<N) {
					int sum=0;
					int index=0;
					for (int i = left ; i<=right;i++) {
						sum+=AN[i]*BM[index];
						index++;
					}
					AL.add(sum);
					left++;
					right++;
				}
			}
			for (int i=0; i<AL.size();i++) {
				if(max<(int)AL.get(i)) {
					max=(int)AL.get(i);
				}
			}
			System.out.printf("#%d %d\n",test_case,max);
		}
	}
}
