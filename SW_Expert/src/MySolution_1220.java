import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_1220 {
//1220. [S/W �����ذ� �⺻] 5���� - Magnetic
//�浹����(����)
//1. �� �Ʒ� ������ ���� ����� ���� �ݴ뼺��
//2. 1����ġ�κ��� �ݴ� ���� ���� �ϳ��� ������ �浹�� �߻��Ѵ�.
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
	           int[] temp = new int[length]; //�浹����� ���� �迭
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
	        for (int start = 0 ; start<temp.length;start++){ //N�ؿ��� ����ؼ� S�� ��������
	            if(temp[start]==2) {  
	                S=true; 
	                if(N) { //�ռ� N�� �־����� �浹�߻�
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
