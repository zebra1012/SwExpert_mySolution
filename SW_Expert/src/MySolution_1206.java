import java.io.FileInputStream;
import java.util.Scanner;

public class MySolution_1206 {
	/* 1206. [S/W 문제해결 기본] 1일차 - View
	 * 
	 * [제약 사항]

		가로 길이는 항상 1000이하로 주어진다.
		
		맨 왼쪽 두 칸과 맨 오른쪽 두 칸에는 건물이 지어지지 않는다. (예시에서 빨간색 땅 부분)
		
		각 빌딩의 높이는 최대 255이다.
		 
		[입력]
		
		입력 파일의 첫 번째 줄에는 테스트케이스의 길이가 주어진다. 그 바로 다음 줄에 테스트 케이스가 주어진다.
		
		총 10개의 테스트케이스가 주어진다.
		 
		[출력]
		
		#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 조망권이 확보된 세대의 수를 출력한다.
	 */
	public static void main(String[] args) throws Exception {
		String path="";//입력파일 경로
		System.setIn(new FileInputStream(path));
		Scanner sc = new Scanner(System.in);
		int test_case=0;
		while(sc.hasNext()){
            test_case++;
            int length=sc.nextInt();
     		int[] buildings=new int[length];
            for (int i = 0 ; i<length;i++){ //배열에 저장
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
            //좌측 두 개중 가장 높은 건물
            if(buildings[i-2] > buildings[i-1]) leftside=buildings[i-2]; 
            else leftside=buildings[i-1];
            //우측 두 개중 가장 높은 건물
            if(buildings[i+2]>buildings[i+1]) rightside=buildings[i+2]; 
            else rightside=buildings[i+1];
            //조망권이 있는 세대 추가
            if(leftside>rightside && buildings[i]>leftside) count+=buildings[i]-leftside;
            else if(rightside>=leftside && buildings[i]>rightside)  count+=buildings[i]-rightside;
    	}
        return count;
	}
}
