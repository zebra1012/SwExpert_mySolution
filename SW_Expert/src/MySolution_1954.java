import java.io.FileInputStream;
import java.util.Scanner;
//1954. ������ ����
/*
[�������]

�������� ũ�� N�� 1 �̻� 10 ������ �����̴�. (1 �� N �� 10)


[�Է�]

���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽����� N�� �־�����.


[���]

�� ���� '#t'�� �����ϰ�, ���� �ٺ��� ��ĭ�� ���̿� �ΰ� ������ ���ڸ� ����Ѵ�.

(t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
 */
public class MySolution_1954 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("D:\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		int count=1;
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();//�������� ũ��
			int[][] snail=new int[N][N];
			boolean[][] visited = new boolean[N][N];
			snail =fill(snail,visited,0,0,count);
			System.out.printf("#%d\n",test_case);
			for (int i=0;i<snail.length;i++) {
				for (int k=0;k<snail.length;k++) {
					System.out.printf("%d ",snail[i][k]);
				}
				System.out.println();
			}
			
		}
	}
	public static int[][] fill(int[][] snail,boolean[][] visited,int x,int y,int count) { //������ ���ڸ� ä��� �޼ҵ�
		int[] dY= {1,0,-1,0};
		int[] dX= {0,1,0,-1};
		int max=snail.length;//������ ��
		visited[x][y]=true; //�湮 ǥ��
		snail[x][y]=count; //���� ä���
		count++;
		for (int i = 0 ; i<dX.length;i++) {
			int nx=x+dX[i];
			int ny=y+dY[i];
			if (nx>=0&&nx<max&&ny>=0&&ny<max) { //������ ����� �ʾƾ� ��
				if(!visited[nx][ny])//�湮�� ���� ����� ��
					fill(snail,visited,nx,ny,count);
			}
		}
		return snail;
	}
}
