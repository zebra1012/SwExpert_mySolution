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
            for (int i = 0; i<arr.length;i++){ //���ڹ��Թ迭
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = arr.length-1 ; i>=0 ; i--){
                if(arr[i]>M) continue; //�� ���� ���������� ������ ������ ���� �ݺ�
                for (int k= i-1; k>=0; k--){
                    if(arr[i]+arr[k]<=M) { //�� ������ ���� ������ ���� �ʰ�
                        if(max<arr[i]+arr[k]){ //������ �ִ밪�� ������
                        max=arr[i]+arr[k]; //�ִ밪 ����
                        }
                        break; //arr[i]�� �������� ��, ������ ���� �ʴ� �ִ밪�� �̹� �����Ƿ� ���� �ݺ�
                    }
                }
            }
           System.out.printf("#%d %d\n",test_case,max);
		}
	}
}