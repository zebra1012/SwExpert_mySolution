import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_2001 {
	//2001. 파리 퇴치
	/*
[제약 사항]

1. N 은 5 이상 15 이하이다.

2. M은 2 이상 N 이하이다.

3. 각 영역의 파리 갯수는 30 이하 이다.


[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에 N 과 M 이 주어지고,

다음 N 줄에 걸쳐 N x N 배열이 주어진다.


[출력]

출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
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
			int[][] arr =new int[N][N]; //주어진 영역의 크기
			for (int i = 0 ; i<arr.length;i++) {
				for (int k = 0 ; k<arr.length;k++) {
					arr[i][k]=sc.nextInt();
				}
			}
			
			for (int i = 0 ; i<=arr.length-M;i++) { //생각해야 하는 최대 행
				for (int k = 0 ; k<=arr.length-M;k++) { //생각햐애 하는 최대 열
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
