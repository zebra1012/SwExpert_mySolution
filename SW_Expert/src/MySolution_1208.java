import java.io.FileInputStream;
import java.util.Scanner;
import java.util.*;

public class MySolution_1208 {
/*
 * 1208. [S/W �����ذ� �⺻] 1���� - Flatten
 * [���� ����]

���� ���̴� �׻� 100���� �־�����.

��� ��ġ���� ������ ���̴� 1�̻� 100���Ϸ� �־�����.

���� Ƚ���� 1�̻� 1000���Ϸ� �־�����.

�־��� ���� Ƚ�� �̳��� ��źȭ�� �Ϸ�Ǹ� �� �̻� ������ ������ �� �����Ƿ� �� ���� �ְ����� �������� ���� ���� ��ȯ�Ѵ� (�־��� data�� ���� 0 �Ǵ� 1�� �ȴ�).

[�Է�]

�� 10���� �׽�Ʈ ���̽��� �־�����, �� �׽�Ʈ ���̽��� ù ��° �ٿ��� ���� Ƚ���� �־�����. �׸��� ���� �ٿ� �� ������ ���̰��� �־�����.

[���]

#��ȣ�� �Բ� �׽�Ʈ ���̽��� ��ȣ�� ����ϰ�, ���� ���� �� �׽�Ʈ ���̽��� �ְ����� �������� ���� ���� ����Ѵ�.
 */
	public static void main(String[] args) throws Exception {
		String path="";//�Է����� ���
		System.setIn(new FileInputStream(path));
		Scanner sc = new Scanner(System.in);
		int test_case=0;
		while(sc.hasNext()){
            test_case++;
            int dump = sc.nextInt();
            int[] boxes=new int[100]; //���� ���̴� �׻� 100
            for ( int i = 0 ; i<boxes.length;i++){ 
                boxes[i]=sc.nextInt();
            }
            int diff = getDiff(boxes,dump);
            System.out.printf("#%d %d\n",test_case,diff);
        }
	}
    public static int getDiff(int[] boxes,int dump){
        Arrays.sort(boxes);
        while(dump>0){
            boxes[99]-=1;
            boxes[0]+=1; //���� 1ȸ, ���� ���� ������ ���� ���� ������
            dump--;
            Arrays.sort(boxes); //������ �����ϸ� �ٽ� ����
        }
        return boxes[99]-boxes[0];
    }
}
