import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_5642 {
	//5642. [Professional] 합
	/*
	 [입력]
		첫 줄에 테스트케이스의 개수 T가 주어진다. (1 ≤ T ≤ 20)

		각 테스트 케이스 첫째 줄에 숫자 N이 주어진다. (3 ≤ N ≤ 100,000)

		둘째 줄에는 절대값이 1000이하의 정수 N개가 공백을 사이에 두고 입력된다.

	[출력]
		각 테스트케이스마다 한 줄에 걸쳐, 테스트케이스 수 “#(TC) “를 출력하고, 연속된 정수의 합의 최대값을 출력하시오.
	 */

	public static void main(String[] args) throws Exception {
		String path="";//입력파일 경로
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
        	if(guess<0) { //이전까지의 합이 음수면 
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