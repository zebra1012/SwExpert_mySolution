import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Scanner;

public class MySolution_1948 {
/*
[제약 사항]

월은 1 이상 12 이하의 정수이다. 각 달의 마지막 날짜는 다음과 같다.

1/31, 2/28, 3/31, 4/30, 5/31, 6/30, 7/31, 8/31, 9/30, 10/31, 11/30, 12/31

두 번째 날짜가 첫 번째 날짜보다 항상 크게 주어진다.


[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 4개의 수가 주어진다.

첫 번째 수가 월을 나타내고 두 번째 수가 일을 나타낸다. 그 다음 같은 형식으로 두 번째 날짜가 주어진다.


[출력]

출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다. (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("D:\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			Calendar c1= Calendar.getInstance();
			Calendar c2= Calendar.getInstance();
			int month = sc.nextInt();//첫 번째 월
			int date = sc.nextInt();//두 번째 월
			c1.set(2019, month-1, date); //첫 번째 날짜 , 윤달이 없는 해 선정
			month=sc.nextInt();//두 번째 월
			date=sc.nextInt(); //두 번째 일
			c2.set(2019,month-1,date); //두 번째 날짜;
			int count=0;
			while(c2.compareTo(c1)>=0) { //c2가 c1보다 크면 0보다 크고 같으면 0, 작으면 0보다 작다.
				count++;
				c1.add(Calendar.DAY_OF_MONTH, 1);
			}
			System.out.printf("#%d %d\n", test_case,count);
		}
	}
}

