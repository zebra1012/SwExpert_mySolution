import java.io.FileInputStream;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Scanner;

// SW Expert 1928. Base64 Decoder

//�Է� ����
//T
//TGlmZSBpdHNlbGYgaXMgYSBxdW90YXRpb24u
//U3VzcGljaW9uIGZvbGxvd3MgY2xvc2Ugb24gbWlzdHJ1c3Qu
//...
//��� ���� 

//#1 Life itself is a quotation.
//#2 Suspicion follows close on mistrust.
//...

public class MySolution_1928 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("D:\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt(); //�׽�Ʈ ���̽��� ����
		String dummy=sc.nextLine();//���� �ѱ��
		for(int test_case = 1; test_case <= T; test_case++){
			String s=sc.nextLine(); //���ڵ� �� ���ڿ��� ����
			Decoder decode = Base64.getDecoder(); //���ڴ� ȹ��
			byte[] bytes=decode.decode(s); //���ڵ� �� ���ڿ� ���ڵ�
			s=new String(bytes); //���ڿ� ����
			System.out.printf("#%d %s\n", test_case,s); 
		}
	}
}
