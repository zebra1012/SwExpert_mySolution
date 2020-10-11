import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class MySolution_1983 {
 //1983.조교의 성적 매기기
/*
[제약사항]

1. N은 항상 10의 배수이며, 10이상 100이하의 정수이다. (10 ≤ N ≤ 100)

2. K는 1 이상 N 이하의 정수이다. (1 ≤ K ≤ N)

3. K 번째 학생의 총점과 다른 학생의 총점이 동일한 경우는 입력으로 주어지지 않는다.


[입력]

입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.

다음 줄부터 각 테스트 케이스가 주어진다.

테스트 케이스의 첫 번째 줄은 학생수 N 과, 학점을 알고싶은 학생의 번호 K 가 주어진다.

테스트 케이스 두 번째 줄 부터 각각의 학생이 받은 시험 및 과제 점수가 주어진다.


[출력]

테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
*/
	public static void main(String[] args) throws Exception {
		String path="C:\\Users\\pipyr\\downloads\\input.txt";
		System.setIn(new FileInputStream(path));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int K = sc.nextInt();
			double[] scores = new double[N];
			for (int i= 0 ; i<N; i++) {
				double total = 0;
				for (int k = 0 ; k<3;k++) {
					double score = sc.nextDouble();
					switch(k) {
					case 0: total=total+score*0.35; break;
					case 1: total=total+score*0.45; break;
					case 2: total=total+score*0.2;
					}
				}
				scores[i]=-total; //정렬을 위해 부호 바꿈
			}
			double target = scores[K-1];
			Arrays.sort(scores);
			int rank=Arrays.binarySearch(scores, target);
			String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
			int count= N/10; //한 학점당 인원수
			for (int i = 0 ; i<grade.length;i++) {
				if(rank>=count*i&&rank<count*(i+1)) {
					System.out.printf("#%d %s\n",test_case,grade[i]);
					break;
				}
			}
		}
	}

}
