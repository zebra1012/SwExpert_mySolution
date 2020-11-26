import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class MySolution_9229 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int M =sc.nextInt();
            int[] arr = new int[N];
            int max=-1;
            for (int i = 0; i<arr.length;i++){ //과자무게배열
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = arr.length-1 ; i>=0 ; i--){
                if(arr[i]>M) continue; //한 개의 봉지만으로 제한을 넘으면 다음 반복
                for (int k= i-1; k>=0; k--){
                    if(arr[i]+arr[k]<=M) { //두 봉지의 합이 제한을 넘지 않고
                        if(max<arr[i]+arr[k]){ //기존의 최대값을 넘으면
                        max=arr[i]+arr[k]; //최대값 변경
                        }
                        break; //arr[i]가 정해졌을 때, 제한을 넘지 않는 최대값을 이미 봤으므로 다음 반복
                    }
                }
            }
           System.out.printf("#%d %d\n",test_case,max);
		}
	}
}