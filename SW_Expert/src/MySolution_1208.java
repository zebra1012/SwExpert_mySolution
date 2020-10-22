import java.io.FileInputStream;
import java.util.Scanner;
import java.util.*;

public class MySolution_1208 {
/*
 * 1208. [S/W 문제해결 기본] 1일차 - Flatten
 * [제약 사항]

가로 길이는 항상 100으로 주어진다.

모든 위치에서 상자의 높이는 1이상 100이하로 주어진다.

덤프 횟수는 1이상 1000이하로 주어진다.

주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상 덤프를 수행할 수 없으므로 그 때의 최고점과 최저점의 높이 차를 반환한다 (주어진 data에 따라 0 또는 1이 된다).

[입력]

총 10개의 테스트 케이스가 주어지며, 각 테스트 케이스의 첫 번째 줄에는 덤프 횟수가 주어진다. 그리고 다음 줄에 각 상자의 높이값이 주어진다.

[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 최고점과 최저점의 높이 차를 출력한다.
 */
	public static void main(String[] args) throws Exception {
		String path="";//입력파일 경로
		System.setIn(new FileInputStream(path));
		Scanner sc = new Scanner(System.in);
		int test_case=0;
		while(sc.hasNext()){
            test_case++;
            int dump = sc.nextInt();
            int[] boxes=new int[100]; //가로 길이는 항상 100
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
            boxes[0]+=1; //덤프 1회, 가장 높은 곳에서 가장 낮은 곳으로
            dump--;
            Arrays.sort(boxes); //덤프를 실행하면 다시 정렬
        }
        return boxes[99]-boxes[0];
    }
}
