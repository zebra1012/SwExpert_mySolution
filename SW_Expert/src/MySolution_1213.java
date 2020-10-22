import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_1213 {
	/*1213. [S/W �����ذ� �⺻] 3���� - String
	 * 
[���� ����]

�� 10���� �׽�Ʈ ���̽��� �־�����.

������ ���̴� 1000�ڸ� �Ѿ�� �ʴ´�.

�� ���忡�� �˻��ϴ� ���ڿ��� ���̴� �ִ� 10�� ���� �ʴ´�.

�� ���忡���� �ϳ��� ���ڿ��� �˻��Ѵ�. 

[�Է�]

�� �׽�Ʈ ���̽��� ù �ٿ��� �׽�Ʈ ���̽��� ��ȣ�� �־����� �� ���� �ٿ��� ã�� ���ڿ�, �� ���� �ٿ��� �˻��� ������ �־�����.

[���]

#��ȣ�� �Բ� �׽�Ʈ ���̽��� ��ȣ�� ����ϰ�, ���� ���� �� �׽�Ʈ ���̽��� ���� ����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
	        int test_case = sc.nextInt();
	        int count=0;
	        String find = sc.next();
	        String phrase = sc.next();
	       	while(phrase.contains(find)){
	            phrase=phrase.replaceFirst(find,"-");
	            count++;
	        }
	        System.out.printf("#%d %d\n",test_case,count);
	    }
	}
}
