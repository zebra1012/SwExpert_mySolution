import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MySolution_1959 {
/*
[제약 사항]
N 과 M은 3 이상 20 이하이다.

[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에 N 과 M 이 주어지고,

두 번째 줄에는 Ai,

세 번째 줄에는 Bj 가 주어진다.

[출력]

출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
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
			int N = sc.nextInt(); int M = sc.nextInt();//N과 M
			int[] AN =new int[N];
			int[] BM =new int[M];
			for (int i = 0 ; i<N; i++) {
				AN[i]=sc.nextInt();
			}
			for (int i = 0 ; i<M;i++) {
				BM[i]=sc.nextInt();
			}
			if(N>M) { //N이 더 길 때
				left=0;
				right=M-1;
				
			}
			else if (N<M) { //M이 더 길 때
				left=0;
				right=N-1;
				flag=true;
			}
			if(flag) { //M이 더 길 때
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
