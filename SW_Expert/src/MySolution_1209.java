import java.io.FileInputStream;
import java.util.Scanner;
/*
 * 1209. [S/W 문제해결 기본] 2일차 - Sum
 * 
[제약 사항]

총 10개의 테스트 케이스가 주어진다.

배열의 크기는 100X100으로 동일하다.

각 행의 합은 integer 범위를 넘어가지 않는다.

동일한 최댓값이 있을 경우, 하나의 값만 출력한다.
 
[입력]

각 테스트 케이스의 첫 줄에는 테스트 케이스 번호가 주어지고 그 다음 줄부터는 2차원 배열의 각 행 값이 주어진다.

[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 답을 출력한다.
 */

public class MySolution_1209 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\Users\\pipyrus\\Downloads\\input.txt"));
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
           	int test_case = sc.nextInt();
            int[][] arr = new int[100][100];
            for (int i = 0 ; i < arr.length;i++){
                for (int k = 0 ; k<arr[i].length;k++){
                    arr[i][k]=sc.nextInt();
                }
            }
            int max = getMax(arr);
            System.out.printf("#%d %d\n",test_case,max);
        }
	}
    public static int getMax(int[][] arr){
        int RowMax=0;
        int	ColMax=0;
        int LeftCross=0;
        int RightCross=0;
        for (int i = 0 ; i < arr.length;i++){
            int sum = 0 ; //i번째 열합계
            for (int k = 0 ; k<arr[i].length;k++){
              sum+=arr[i][k];
              if(i==k) LeftCross+=arr[i][k]; //왼쪽에서 오른쪽 사선
              if (i+k==99) RightCross=arr[i][k]; //오른쪽에서 왼쪽 사선
            }
            if (sum>RowMax) RowMax=sum;
        }
         for (int i = 0 ; i < arr.length;i++){
            int sum = 0 ; //i번째 행합계
            for (int k = 0 ; k<arr[i].length;k++){
              sum+=arr[k][i];
            }
            if (sum>ColMax) ColMax=sum;
        }
        int first = Math.max(RowMax,ColMax);
        int second =Math.max(LeftCross,RightCross);
        return Math.max(first,second);
    }
}
