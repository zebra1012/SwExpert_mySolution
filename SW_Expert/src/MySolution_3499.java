import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MySolution_3499 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();//카드 갯수
            //정확히 절반을 나눠 큐에 저장
           	Queue<String> q1 = new LinkedList();
            Queue<String> q2 = new LinkedList(); 
            if(N%2==0){ 
                for (int i = 0 ; i<N/2;i++){
                    q1.add(sc.next());
                }
                for (int i =0 ; i<N/2; i++){
                    q2.add(sc.next());
                }
            }
            else{
                for (int i = 0 ; i<N/2+1;i++){
                	q1.add(sc.next());
                }
                for (int i = 0 ; i<N/2;i++){
                    q2.add(sc.next());
                }
            }
            //교대로 뽑아 바로 출력
            System.out.printf("#%d ",test_case);
            while(q1.peek()!=null){
                System.out.printf("%s ",q1.poll());
                if(q2.peek()!=null){
                	System.out.printf("%s ",q2.poll());
                }
            }
            System.out.println();
		}
	}
}