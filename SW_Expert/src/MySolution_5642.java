import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_5642 {
	//5642. [Professional] ��
	/*
	 [�Է�]
		ù �ٿ� �׽�Ʈ���̽��� ���� T�� �־�����. (1 �� T �� 20)

		�� �׽�Ʈ ���̽� ù° �ٿ� ���� N�� �־�����. (3 �� N �� 100,000)

		��° �ٿ��� ���밪�� 1000������ ���� N���� ������ ���̿� �ΰ� �Էµȴ�.

	[���]
		�� �׽�Ʈ���̽����� �� �ٿ� ����, �׽�Ʈ���̽� �� ��#(TC) ���� ����ϰ�, ���ӵ� ������ ���� �ִ밪�� ����Ͻÿ�.
	 */

	public static void main(String[] args) throws Exception {
		String path="";//�Է����� ���
		System.setIn(new FileInputStream(path));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N =sc.nextInt();
            int[] Na=new int[N];
            for (int i = 0 ; i<N;i++){
                Na[i]=sc.nextInt();
            }
            int answer=getMax(Na);
            System.out.printf("#%d %d\n",test_case,answer);
		}
	}
    public static int getMax(int[] Na){
        int max=Na[0];
        int guess=0;
        for (int i = 0 ; i<Na.length;i++) {
        	if(guess<0) { //���������� ���� ������ 
        		guess=0; 
        	}
        	guess+=Na[i];
        	if(max<guess) {
        		max=guess;
        	}
        }
        return max;
    }
}