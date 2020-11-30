import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_5356 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String answer="";
            //배열생성
            char[][] play = new char[5][];
            for (int i = 0 ; i<5;i++){
                play[i]=sc.nextLine().toCharArray();
            }
            //answer
           for (int i = 0 ; i<15;i++){
               for (int k = 0 ; k<5;k++){
                   try {
                   answer+=play[k][i];
                   }
                   catch(Exception E){
                       continue;
                   }
               }
           }
            //출력
            System.out.printf("#%d %s\n",test_case,answer);
		}
	}
}