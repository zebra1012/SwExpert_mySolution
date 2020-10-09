import java.io.FileInputStream;
import java.util.Scanner;
//1954. 달팽이 숫자
/*
[제약사항]

달팽이의 크기 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)


[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스에는 N이 주어진다.


[출력]

각 줄은 '#t'로 시작하고, 다음 줄부터 빈칸을 사이에 두고 달팽이 숫자를 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
 */
public class MySolution_1954 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("D:\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		int count=1;
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();//달팽이의 크기
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
	public static int[][] fill(int[][] snail,boolean[][] visited,int x,int y,int count) { //달팽이 숫자를 채우는 메소드
		int[] dY= {1,0,-1,0};
		int[] dX= {0,1,0,-1};
		int max=snail.length;//달팽이 끝
		visited[x][y]=true; //방문 표시
		snail[x][y]=count; //숫자 채우기
		count++;
		for (int i = 0 ; i<dX.length;i++) {
			int nx=x+dX[i];
			int ny=y+dY[i];
			if (nx>=0&&nx<max&&ny>=0&&ny<max) { //범위를 벗어나지 않아야 함
				if(!visited[nx][ny])//방문한 적이 없어야 함
					fill(snail,visited,nx,ny,count);
			}
		}
		return snail;
	}
}
