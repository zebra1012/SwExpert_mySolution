import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*  1979. 어디에 단어가 들어갈 수 있을까
 [제약 사항]

1. N은 5 이상 15 이하의 정수이다. (5 ≤ N ≤ 15)

2. K는 2 이상 N 이하의 정수이다. (2 ≤ K ≤ N)


[입력]

입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.

다음 줄부터 각 테스트 케이스가 주어진다.

테스트 케이스의 첫 번째 줄에는 단어 퍼즐의 가로, 세로 길이 N 과, 단어의 길이 K 가 주어진다.

테스트 케이스의 두 번째 줄부터 퍼즐의 모양이 2차원 정보로 주어진다.

퍼즐의 각 셀 중, 흰색 부분은 1, 검은색 부분은 0 으로 주어진다.


[출력]

테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
 */
public class MySolution_1979 {
	static class Cordinator{
		int row;
		int col;
		int direction; //방향, 0은 오른쪽 1은 아래
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
					if(arr[i][row]==0) { //단어가 다 들어가기 전에 막힌 칸이 나올 경우
						break; //들어갈 수 없음
					}
					length--;
					if(length==0) {
						if(arr[i][row+1]==1) break; //단어가 다 들어갔는데 다음 칸이 비어 있을 경우 들어갈 수 없음
						else count++;
					}
				}
			}
			else if (direction==1) {
				for (int col = i ; col<arr.length-1;col++) {
					if(arr[col][k]==0) { //단어가 다 들어가기 전에 막힌 칸이 나올 경우
						break; //들어갈 수 없음
					}
					length--;
					if(length==0) {
						if(arr[col+1][k]==1) break; // 단어가 다 들어갔는데 다음 칸이 비어 있을 경우들어갈 수 없음
						else count++;
					}
				}
			}
		}
		return count;
	}
}
