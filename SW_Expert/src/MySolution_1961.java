import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_1961 {
//1961. 숫자 배열 회전
/*
[제약 사항]

N은 3 이상 7 이하이다.

[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에 N이 주어지고,

다음 N 줄에는 N x N 행렬이 주어진다.

[출력]

출력의 첫 줄은 '#t'로 시작하고,

다음 N줄에 걸쳐서 90도, 180도, 270도 회전한 모양을 출력한다.

입력과는 달리 출력에서는 회전한 모양 사이에만 공백이 존재함에 유의하라.

(t는 테
스트 케이스의 번호를 의미하며 1부터 시작한다.)
 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\Users\\pipyr\\downloads\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt(); 
			int[][] arr = new int[N][N]; //N x N 행렬
			arr = makeArray(arr,N,sc);
			int[][] arr90=rocation90(arr);
			int[][] arr180=rocation90(arr90);
			int[][] arr270=rocation90(arr180);
			System.out.printf("#%d\n", test_case); //출력시작
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
			} 										//출력 끝
		}
	}
	public static int[][] makeArray(int[][] arr,int N,Scanner sc){ //N x N 배열 생성 메소드
		for (int i = 0 ; i<N;i++) {
			for (int k = 0 ; k<N;k++) {
				arr[i][k]=sc.nextInt();
			}
		}
		return arr;
	}
	public static int[][] rocation90(int[][] arr) { //배열 회전 메소드
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
