import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_1213 {
	/*1213. [S/W 문제해결 기본] 3일차 - String
	 * 
[제약 사항]

총 10개의 테스트 케이스가 주어진다.

문장의 길이는 1000자를 넘어가지 않는다.

한 문장에서 검색하는 문자열의 길이는 최대 10을 넘지 않는다.

한 문장에서는 하나의 문자열만 검색한다. 

[입력]

각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고 그 다음 줄에는 찾을 문자열, 그 다음 줄에는 검색할 문장이 주어진다.

[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 답을 출력한다.
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
