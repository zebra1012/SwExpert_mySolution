import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class MySolution_5789 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int[] boxes = new int[sc.nextInt()]; //크기가 N인 배열
            int Q = sc.nextInt(); //작업 갯수
            for (int i = 1 ; i<=Q;i++){
                int L=sc.nextInt()-1;
                int R = sc.nextInt();
                Arrays.fill(boxes,L,R,i);
            }
            
            //출력
            System.out.printf("#%d ",test_case);
            for (int i : boxes){
                System.out.printf("%d ",i);
            }
            System.out.println();
		}
	}
}