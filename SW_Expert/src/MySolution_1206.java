import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_1206 {
	/* 1206. [S/W �����ذ� �⺻] 1���� - View
	 * 
	 * [���� ����]

		���� ���̴� �׻� 1000���Ϸ� �־�����.
		
		�� ���� �� ĭ�� �� ������ �� ĭ���� �ǹ��� �������� �ʴ´�. (���ÿ��� ������ �� �κ�)
		
		�� ������ ���̴� �ִ� 255�̴�.
		 
		[�Է�]
		
		�Է� ������ ù ��° �ٿ��� �׽�Ʈ���̽��� ���̰� �־�����. �� �ٷ� ���� �ٿ� �׽�Ʈ ���̽��� �־�����.
		
		�� 10���� �׽�Ʈ���̽��� �־�����.
		 
		[���]
		
		#��ȣ�� �Բ� �׽�Ʈ ���̽��� ��ȣ�� ����ϰ�, ���� ���� �� �׽�Ʈ ���̽��� �������� Ȯ���� ������ ���� ����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		String path="";//�Է����� ���
		System.setIn(new FileInputStream(path));
		Scanner sc = new Scanner(System.in);
		int test_case=0;
		while(sc.hasNext()){
            test_case++;
            int length=sc.nextInt();
     		int[] buildings=new int[length];
            for (int i = 0 ; i<length;i++){ //�迭�� ����
                buildings[i]=sc.nextInt();
            }
            int Rights=getMax(buildings);
            System.out.printf("#%d %d\n",test_case,Rights);
        }
	}
    public static int getMax(int[] buildings){
        int count=0;
        int leftside=0;
        int rightside=0;
        for (int i = 2; i<buildings.length-2;i++){ 
            //���� �� ���� ���� ���� �ǹ�
            if(buildings[i-2] > buildings[i-1]) leftside=buildings[i-2]; 
            else leftside=buildings[i-1];
            //���� �� ���� ���� ���� �ǹ�
            if(buildings[i+2]>buildings[i+1]) rightside=buildings[i+2]; 
            else rightside=buildings[i+1];
            //�������� �ִ� ���� �߰�
            if(leftside>rightside && buildings[i]>leftside) count+=buildings[i]-leftside;
            else if(rightside>=leftside && buildings[i]>rightside)  count+=buildings[i]-rightside;
    	}
        return count;
	}
}
