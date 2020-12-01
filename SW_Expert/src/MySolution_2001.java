import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_2001 {
	//2001. �ĸ� ��ġ
	/*
[���� ����]

1. N �� 5 �̻� 15 �����̴�.

2. M�� 2 �̻� N �����̴�.

3. �� ������ �ĸ� ������ 30 ���� �̴�.


[�Է�]

���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ� N �� M �� �־�����,

���� N �ٿ� ���� N x N �迭�� �־�����.


[���]

����� �� ���� '#t'�� �����ϰ�, ������ �� ĭ �� ���� ������ ����Ѵ�.

(t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
*/
	public static void main(String[] args) throws Exception {
		String path="";
		System.setIn(new FileInputStream(path));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int max=0;
			int N=sc.nextInt();
			int M = sc.nextInt();
			int[][] arr =new int[N][N]; //�־��� ������ ũ��
			for (int i = 0 ; i<arr.length;i++) {
				for (int k = 0 ; k<arr.length;k++) {
					arr[i][k]=sc.nextInt();
				}
			}
			
			for (int i = 0 ; i<=arr.length-M;i++) { //�����ؾ� �ϴ� �ִ� ��
				for (int k = 0 ; k<=arr.length-M;k++) { //������� �ϴ� �ִ� ��
					max= getMax(arr,M,i,k,max);
				}
			}

			System.out.printf("#%d %d\n",test_case,max);
		}
	}
	public static int getMax(int[][] arr, int M,int col, int row,int max) {
		int sum=0;
		for (int i = 0 ;i<M;i++) {
			for (int k=0 ;k<M;k++) {
				sum+=arr[col+i][row+k];
			}
		}
		if(sum>max) max=sum;
		return max;
	}
}
