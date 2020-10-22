import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_1220 {
//1220. [S/W 문제해결 기본] 5일차 - Magnetic
//충돌조건(열별)
//1. 위 아래 끝에서 가장 가까운 블럭이 반대성질
//2. 1번위치로부터 반대 성질 블럭이 하나라도 있으면 충돌이 발생한다.
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		 int test_case=0;
	       while(sc.hasNext()){
	           int length=sc.nextInt();
	           test_case++;
	           int contact= 0;
	           int[][] table = new int[length][length];
	           for (int i = 0 ; i<length;i++){
	               for (int k = 0 ; k<length;k++){
	                   table[i][k]=sc.nextInt();
	               }
	           }
	           int[] temp = new int[length]; //충돌계산을 위한 배열
	           for (int i = 0 ; i<length;i++){
	               for (int k = 0 ; k<length;k++){
	                   temp[k]=table[k][i];
	               }
	               contact+=getcontact(temp);
	           }
	           System.out.printf("#%d %d\n",test_case,contact);
	        }
	    }
	    public static int getcontact(int[] temp){
	        boolean N=false;
	        boolean S=false;
	        int contact=0;
	        for (int start = 0 ; start<temp.length;start++){ //N극에서 출발해서 S극 방향으로
	            if(temp[start]==2) {  
	                S=true; 
	                if(N) { //앞서 N이 있었으면 충돌발생
	                    contact++;  
	                    N=false;
	                }
	            }
	            if(temp[start]==1) {  
	                N=true;
	            }
	        }
	        return contact;
	    }
	}
