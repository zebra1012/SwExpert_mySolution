import java.io.FileInputStream;
import java.util.Scanner;
//1215. [S/W 문제해결 기본] 3일차 - 회문1

public class MySolution_1215 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		 int test_case=0;
			while(sc.hasNext()) {
	            test_case++;
	            int count=0;
	            int length=sc.nextInt();
	            sc.nextLine();
	            char[][] puzzle= new char[8][8];
	            for (int i = 0 ; i<puzzle.length;i++){
	                puzzle[i]=sc.next().toCharArray();
	            }
	             for (int i = 0 ; i<puzzle.length;i++){
	                 for (int k = 0 ; k<puzzle[i].length;k++){
	                     count+=getcount(puzzle,i,k,length); //해당 위치에서 회문검사수행
	                 }
	             }
	            System.out.printf("#%d %d\n",test_case,count);
	        }
	    }
	    public static int getcount(char[][] puzzle, int i , int k , int length){
	        StringBuffer sb =new StringBuffer();
	        int count=0;
	        int index=0;
	        //오른쪽으로
	        for (int row=k;row<puzzle[i].length;row++){
	            sb.append(puzzle[i][row]);
	            index++;
	            if(index>=length) break;
	        }
	        if(index>=length&&sb.toString().equals(sb.reverse().toString())) count++;
	        sb.setLength(0);
	        index=0;
	        //아래로
	         for (int col=i;col<puzzle.length;col++){
	             sb.append(puzzle[col][k]);
	             index++;
	             if(index==length) break;
	       }
	        if(index>=length&&sb.toString().equals(sb.reverse().toString())) count++;
	        return count;
	    }
	}
