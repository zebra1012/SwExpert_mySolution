import java.io.FileInputStream;
import java.util.Scanner;
//1216. [S/W 문제해결 기본] 3일차 - 회문2
public class MySolution_1216 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
            int test_case=sc.nextInt();
            boolean flag=false;
            sc.nextLine();
            char[][] puzzle= new char[100][100];
            for (int i = 0 ; i<puzzle.length;i++){
                puzzle[i]=sc.next().toCharArray();
            }
            for (int length=100; length>0;length--){
                 for (int i = 0 ; i<puzzle.length;i++){
                     for (int k = 0 ; k<puzzle[i].length;k++){
                         if(i+length>puzzle.length||k+length>puzzle[i].length) break; //현재위치+길이가 배열길이보다 크면 반복문 종료
                         flag=isSame(puzzle , i , k , length); //회문검사
                         if(flag) break; //회문이 있으면 반복문 종료
                     }
                     if(flag) break;
                 }
                if(flag) {
                    System.out.printf("#%d %d\n",test_case,length);
                    break;
                         }
            }
        }
	}
    public static boolean isSame(char[][] puzzle, int i , int k , int length){//회문1 코드 사용
        int index=0;
        StringBuffer sb =new StringBuffer();
        //오른쪽으로
        for (int row=k;row<puzzle[i].length;row++){
            sb.append(puzzle[i][row]);
            index++;
            if(index>=length) break;
        }
        if(index>=length&&sb.toString().equals(sb.reverse().toString())) return true;
        sb.setLength(0);
        index=0;
        //아래로
         for (int col=i;col<puzzle.length;col++){
             sb.append(puzzle[col][k]);
             index++;
             if(index==length) break;
       }
        if(index>=length&&sb.toString().equals(sb.reverse().toString())) return true;
        return false;
    }
}