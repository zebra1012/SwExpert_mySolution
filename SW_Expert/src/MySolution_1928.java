import java.io.FileInputStream;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Scanner;

// SW Expert 1928. Base64 Decoder

//입력 형식
//T
//TGlmZSBpdHNlbGYgaXMgYSBxdW90YXRpb24u
//U3VzcGljaW9uIGZvbGxvd3MgY2xvc2Ugb24gbWlzdHJ1c3Qu
//...
//출력 형식 

//#1 Life itself is a quotation.
//#2 Suspicion follows close on mistrust.
//...

public class MySolution_1928 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("D:\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt(); //테스트 케이스의 갯수
		String dummy=sc.nextLine();//라인 넘기기
		for(int test_case = 1; test_case <= T; test_case++){
			String s=sc.nextLine(); //인코딩 된 문자열을 저장
			Decoder decode = Base64.getDecoder(); //디코더 획득
			byte[] bytes=decode.decode(s); //인코딩 된 문자열 디코딩
			s=new String(bytes); //문자열 생성
			System.out.printf("#%d %s\n", test_case,s); 
		}
	}
}
