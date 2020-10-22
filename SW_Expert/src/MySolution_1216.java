import java.io.FileInputStream;
import java.util.Scanner;
//1216. [S/W �����ذ� �⺻] 3���� - ȸ��2
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
                         if(i+length>puzzle.length||k+length>puzzle[i].length) break; //������ġ+���̰� �迭���̺��� ũ�� �ݺ��� ����
                         flag=isSame(puzzle , i , k , length); //ȸ���˻�
                         if(flag) break; //ȸ���� ������ �ݺ��� ����
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
    public static boolean isSame(char[][] puzzle, int i , int k , int length){//ȸ��1 �ڵ� ���
        int index=0;
        StringBuffer sb =new StringBuffer();
        //����������
        for (int row=k;row<puzzle[i].length;row++){
            sb.append(puzzle[i][row]);
            index++;
            if(index>=length) break;
        }
        if(index>=length&&sb.toString().equals(sb.reverse().toString())) return true;
        sb.setLength(0);
        index=0;
        //�Ʒ���
         for (int col=i;col<puzzle.length;col++){
             sb.append(puzzle[col][k]);
             index++;
             if(index==length) break;
       }
        if(index>=length&&sb.toString().equals(sb.reverse().toString())) return true;
        return false;
    }
}