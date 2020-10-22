import java.io.FileInputStream;
import java.util.Scanner;
/*
 * 1209. [S/W �����ذ� �⺻] 2���� - Sum
 * 
[���� ����]

�� 10���� �׽�Ʈ ���̽��� �־�����.

�迭�� ũ��� 100X100���� �����ϴ�.

�� ���� ���� integer ������ �Ѿ�� �ʴ´�.

������ �ִ��� ���� ���, �ϳ��� ���� ����Ѵ�.
 
[�Է�]

�� �׽�Ʈ ���̽��� ù �ٿ��� �׽�Ʈ ���̽� ��ȣ�� �־����� �� ���� �ٺ��ʹ� 2���� �迭�� �� �� ���� �־�����.

[���]

#��ȣ�� �Բ� �׽�Ʈ ���̽��� ��ȣ�� ����ϰ�, ���� ���� �� �׽�Ʈ ���̽��� ���� ����Ѵ�.
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
            int sum = 0 ; //i��° ���հ�
            for (int k = 0 ; k<arr[i].length;k++){
              sum+=arr[i][k];
              if(i==k) LeftCross+=arr[i][k]; //���ʿ��� ������ �缱
              if (i+k==99) RightCross=arr[i][k]; //�����ʿ��� ���� �缱
            }
            if (sum>RowMax) RowMax=sum;
        }
         for (int i = 0 ; i < arr.length;i++){
            int sum = 0 ; //i��° ���հ�
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
