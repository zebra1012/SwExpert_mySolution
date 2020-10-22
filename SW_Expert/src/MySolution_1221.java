import java.io.FileInputStream;
import java.util.Scanner;
//[S/W 문제해결 기본] 5일차 - GNS
public class MySolution_1221 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		String[] numbers={"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String TC = sc.next();
            int[] arr = new int[10];
            int length = sc.nextInt();
            for (int i = 0 ; i<length;i++){
                String target=sc.next();
                for (int k = 0 ; k<numbers.length;k++){
                    if(target.equals(numbers[k])){
                        arr[k]++;
                        break;
                    }
                }
            }
            System.out.println(TC);
            for (int i = 0 ; i<arr.length;i++){
                for (int k = 0; k<arr[i];k++){
                    System.out.printf("%s ",numbers[i]);
                }
            }
            System.out.println();
        }
    }
}
