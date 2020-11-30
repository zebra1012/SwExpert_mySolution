import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_7732 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String present = sc.next();
            String promise =sc.next();
            String[] arr_present=present.split(":");
            String[] arr_promise=promise.split(":");
            int H = Integer.parseInt(arr_promise[0])-Integer.parseInt(arr_present[0]);
            int M = Integer.parseInt(arr_promise[1])-Integer.parseInt(arr_present[1]);
            int S = Integer.parseInt(arr_promise[2])-Integer.parseInt(arr_present[2]);
            if(S<0) {
                M--; S+=60;
            }
            if(M<0){
                H--; M+=60;
            }
            if (H<0) {
                H+=24;
            }
            System.out.printf("#%d %02d:%02d:%02d\n",test_case,H,M,S);
		}
	}
}