package Part2.BOJ2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630_yybmion {
    public static int white =0;
    public static int blue =0;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr= new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer stt = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]= Integer.parseInt(stt.nextToken());
            }
        }

        makeSquare(0,0,N);   // 분할 부분 함수 호출

        System.out.println(white);
        System.out.println(blue);
    }

    /**
     * 분할을 통해서 4분면을 나눈후 checkSquare을 통해서 0또는 1, 같은 숫자로 채워져있는지 체크
     * @param row x좌표
     * @param col y좌표
     * @param size
     */
    static void makeSquare(int row,int col,int size){
        if(checkSquare(row,col,size)) {         // 0 또는 1, 같은 숫자로 채워져있는지 체크
            if (arr[row][col] == 0) {           // 체크 부분의 첫번쨰 블록이 0 이면 white ++    (일단 여기 오면 다 같은 숫자로 채워져있다는 의미)
                white++;
            } else {
                blue++;                         // 체크 부분의 첫번째 블록이 1 이면 blue++;
            }
            return;
        }

        int newSize = size/2;                   // 4분면을 나누기 위한 newSize

        makeSquare(row,col,newSize);            // 4분면 나누기
        makeSquare(row,col+newSize,newSize);
        makeSquare(row+newSize,col,newSize);
        makeSquare(row+newSize,col+newSize,newSize);
    }

    static boolean checkSquare(int row,int col,int size){       // check 같은 숫자
        int color = arr[row][col];

        for(int x=row;x<row+size;x++){
            for(int y=col;y<col+size;y++){
                if(arr[x][y] != color){                         // 첫번쨰 블록의 색과 다른 색이 있다면 그냥 false 리턴
                    return false;
                }
            }
        }
        return true;
    }


}
/**
 * 분할정복 문제인것은 쉽게 판단하여 계속해서 2를 나누며 4분면을 나누어가며 각각 1또는 0이 같은 숫자로 채워져 있는지 확인만 하면 되는 이론적으로는 굉장히 쉬워
 * 코드를 짜려는데 생각은 했지만 왜이리 안짜지는 걸까... 그냥 실력이 부족해서 그런것 같다.... 그래도 하면 할 수록 재귀에 대한 이해도와 분할정복에 대해 깨달아가는 것 같다.
 *
 * 어디에서 막혔냐면 일단 4분면을 자른 것을 어떻게 row와 col을 재귀부분에 나타내주어야할지 몰랐다.
 * 풀이에서는 newSize를 다시 정의하고 그걸 2로 나눈후 row와 col에 적절하게 더하여 재귀를 호출하는 것을 볼 수 있다.
 *
 * 그것외에는 각각 같은 숫자에 square인지 체크만 해주면 되니 이건 아주 쉬웠다.
 * 생각해보면 별것 아닌것을 생각을 못했다...
 *
 * https://velog.io/@lifeisbeautiful/%EB%B0%B1%EC%A4%80-2630%EB%B2%88-%EC%83%89%EC%A2%85%EC%9D%B4%EB%A7%8C%EB%93%A4%EA%B8%B0-Java
 */

