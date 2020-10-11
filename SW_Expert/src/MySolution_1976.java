import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_1976 {
//1976. 시각 덧셈
/*
[제약 사항]

시는 1 이상 12 이하의 정수이다. 분은 0 이상 59 이하의 정수이다.


[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 4개의 수가 주어진다.

첫 번째 수가 시를 나타내고 두 번째 수가 분을 나타낸다. 그 다음 같은 형식으로 두 번째 시각이 주어진다.


[출력]

출력의 각 줄은 '#t'로 시작하고 공백을 한 칸 둔 다음, 시를 출력하고 공백을 한 칸 둔 다음 분을 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
*/
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\Users\\pipyr\\downloads\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int hour=0;
			int min=0;
			int first_hour = sc.nextInt();
			int first_min = sc.nextInt();
			int second_hour=sc.nextInt();
			int second_min = sc.nextInt();
			hour=first_hour+second_hour;
			min=first_min+second_min;
			if(hour>12) hour-=12;
			if(min>59) {
				hour++;
				min-=60;
			}
			System.out.printf("#%d %d %d\n", test_case,hour,min);
		}
	}
}
/* 두 시간의 차이 출력
  if(first_hour>second_hour) {//첫 번째 시간이 더 클 때 
		if(first_min>=second_min) {
			hour=first_hour-second_hour;
			min=first_min-second_min;
		}
		else {
			hour=first_hour-second_hour-1;
			min=first_min-second_min+60;
		}
	}
		else if (first_hour<second_hour) { //두 번째 시간이 더 클 때
		if(first_min<=second_min) {
			hour=second_hour-first_hour;
			min=second_min-first_min;
		}
		else {
			hour=second_hour-first_hour-1;
			min=second_min-first_min+60;
		}
	}
		else if(first_hour==second_hour) {//시가 똑같을 때
		if(first_min<=second_min) {
			min=second_min-first_min;
		}
		else {
			min=first_min-second_min;
		}
	}*/