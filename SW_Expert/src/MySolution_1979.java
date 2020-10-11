import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*  1979. ��� �ܾ �� �� ������
 [���� ����]

1. N�� 5 �̻� 15 ������ �����̴�. (5 �� N �� 15)

2. K�� 2 �̻� N ������ �����̴�. (2 �� K �� N)


[�Է�]

�Է��� ù �ٿ� �� �׽�Ʈ ���̽��� ���� T�� �´�.

���� �ٺ��� �� �׽�Ʈ ���̽��� �־�����.

�׽�Ʈ ���̽��� ù ��° �ٿ��� �ܾ� ������ ����, ���� ���� N ��, �ܾ��� ���� K �� �־�����.

�׽�Ʈ ���̽��� �� ��° �ٺ��� ������ ����� 2���� ������ �־�����.

������ �� �� ��, ��� �κ��� 1, ������ �κ��� 0 ���� �־�����.


[���]

�׽�Ʈ ���̽� t�� ���� ����� ��#t���� ���, �� ĭ ���, ������ ����Ѵ�.

(t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
 */
public class MySolution_1979 {
	static class Cordinator{
		int row;
		int col;
		int direction; //����, 0�� ������ 1�� �Ʒ�
		Cordinator(int col, int row,int direction) {
			this.col=col;
			this.row=row;
			this.direction=direction; 
		}
	}
	public static void main(String[] args) throws Exception {
		String path="C:\\Users\\pipyr\\downloads\\input.txt";
		System.setIn(new FileInputStream(path));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] arr =new int[N+2][N+2];
			for (int i = 1 ; i < N+1 ; i++) {
				for (int k = 1 ; k < N+1;k++) {
					arr[i][k]=sc.nextInt();
				}
			}
			int count = isvaild(arr,K);
			System.out.printf("#%d %d\n", test_case,count);
		}
	}
	public static int isvaild(int[][] arr,int K) {
		Queue<Cordinator> Q = new LinkedList();
		
		int count=0;
		for (int i = 1 ; i<arr.length-1;i++) {
			for (int k = 1 ; k<arr.length-1;k++) {
				if(arr[i][k]==1) {
					if(i>0) {
						if(arr[i-1][k]==0&&arr[i+1][k]==1) {
							Q.add(new Cordinator(i,k,1));
						}
					}
					else if (arr[i+1][k]==1) Q.add(new Cordinator(i,k,1));
					if(k>0) {
						if(arr[i][k-1]==0&&arr[i][k+1]==1) {
							Q.add(new Cordinator(i,k,0));
						}
					}
					else if (arr[i][k+1]==1) Q.add(new Cordinator(i,k,0)); 
				}
			}
		}
		while(!Q.isEmpty()) {
			Cordinator c = Q.poll();
			int length=K;
			int i = c.col;
			int k = c.row;
			int direction = c.direction;
			if(direction==0) {
				for (int row = k ; row<arr.length-1;row++) {
					if(arr[i][row]==0) { //�ܾ �� ���� ���� ���� ĭ�� ���� ���
						break; //�� �� ����
					}
					length--;
					if(length==0) {
						if(arr[i][row+1]==1) break; //�ܾ �� ���µ� ���� ĭ�� ��� ���� ��� �� �� ����
						else count++;
					}
				}
			}
			else if (direction==1) {
				for (int col = i ; col<arr.length-1;col++) {
					if(arr[col][k]==0) { //�ܾ �� ���� ���� ���� ĭ�� ���� ���
						break; //�� �� ����
					}
					length--;
					if(length==0) {
						if(arr[col+1][k]==1) break; // �ܾ �� ���µ� ���� ĭ�� ��� ���� ���� �� ����
						else count++;
					}
				}
			}
		}
		return count;
	}
}
