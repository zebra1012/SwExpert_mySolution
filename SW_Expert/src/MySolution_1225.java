import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//1225. [S/W 문제해결 기본] 7일차 - 암호생성기
public class MySolution_1225 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
            int test_case = sc.nextInt();
            Queue q = new LinkedList();
            for (int i = 0 ; i<8 ;i++){
                q.add(sc.nextInt());
            }
            q=makePassword(q);
           System.out.print("#"+test_case);
            while(q.peek()!=null) {
                System.out.printf(" %d",q.poll());
            }
            System.out.println();
        }
	}
    public static Queue makePassword(Queue q){
        int minus=1;
        while(true){
             int temp = (Integer)q.poll();
             if(temp-minus<=0) {
                 q.add(0);
                 break;
             }
            else{
                q.add(temp-minus);
                minus++;
                if(minus==6) minus=1;
             }
        }
        return q;
    }
}
