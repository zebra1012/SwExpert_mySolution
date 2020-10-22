import java.io.FileInputStream;
import java.util.Scanner;
//1217. [S/W 문제해결 기본] 4일차 - 거듭 제곱
public class MySolution_1217 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
            int test_case = sc.nextInt();
            int a = sc.nextInt();
            int b= sc.nextInt();
            int result=getresult(a,b);
          	System.out.printf("#%d %d\n",test_case,result);
        }
	}
	
    public static int getresult(int a , int b){
        if(b==1) return a;
        else return a*getresult(a,b-1);
    }
}