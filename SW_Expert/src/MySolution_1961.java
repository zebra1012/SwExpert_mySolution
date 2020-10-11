import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_1961 {
//1961. ���� �迭 ȸ��
/*
[���� ����]

N�� 3 �̻� 7 �����̴�.

[�Է�]

���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ� N�� �־�����,

���� N �ٿ��� N x N ����� �־�����.

[���]

����� ù ���� '#t'�� �����ϰ�,

���� N�ٿ� ���ļ� 90��, 180��, 270�� ȸ���� ����� ����Ѵ�.

�Է°��� �޸� ��¿����� ȸ���� ��� ���̿��� ������ �����Կ� �����϶�.

(t�� ��
��Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\Users\\pipyr\\downloads\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt(); 
			int[][] arr = new int[N][N]; //N x N ���
			arr = makeArray(arr,N,sc);
			int[][] arr90=rocation90(arr);
			int[][] arr180=rocation90(arr90);
			int[][] arr270=rocation90(arr180);
			System.out.printf("#%d\n", test_case); //��½���
			for (int i = 0 ; i<N;i++) {
				for (int k = 0 ; k<N;k++) {
					System.out.print(arr90[i][k]);
				}
				System.out.print(" ");
				for (int k = 0 ; k<N;k++) {
					System.out.print(arr180[i][k]);
				}
				System.out.print(" ");
				for (int k = 0 ; k<N;k++) {
					System.out.print(arr270[i][k]);
				}
				System.out.println();
			} 										//��� ��
		}
	}
	public static int[][] makeArray(int[][] arr,int N,Scanner sc){ //N x N �迭 ���� �޼ҵ�
		for (int i = 0 ; i<N;i++) {
			for (int k = 0 ; k<N;k++) {
				arr[i][k]=sc.nextInt();
			}
		}
		return arr;
	}
	public static int[][] rocation90(int[][] arr) { //�迭 ȸ�� �޼ҵ�
		int N = arr.length;
		int[][] new_arr=new int[N][N];
		for (int i = 0 ; i<N;i++) {
			for (int k = 0 ; k<N;k++) {
				new_arr[i][k]=arr[N-1-k][i];
			}
		}
		return new_arr;
	}
}
