package Part2.BOJ2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630_99hyeon {

    static int white = 0;
    static int blue = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        paper = new int[size][size];

        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        countPaper(0, 0, size);
        System.out.print(white + "\n" + blue);
    }

    public static void countPaper(int x, int y, int size){
        int count = 0;

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                count += paper[i][j];
            }
        }

        if(count == size*size){ //색종이가 다 파란색
            blue++;
            return;
        }else if(count == 0){   //색종이가 다 하얀색
            white++;
            return;
        }else{
            countPaper(x, y,size/2);    //1사분면
            countPaper(x + size/2, y,size/2);   //2사분면
            countPaper(x, y + size/2,size/2);   //3사분면
            countPaper(x + size/2, y + size/2,size/2);  //4사분면
        }
    }
}

/**
 * 종이의 색상이 다 같아야 하므로, 즉 배열이 모두 1이거나 0이어야하므로
 * 배열의 합을 이용하였다.
 *
 * 색종이가 다 파란색이라면 (종이의 넓이) == (배열 값의 총 합)이어야하고
 * 색종이가 다 하얀색이라면 0 == (배열 값의 총 합)이어야 한다.
 *
 * 따라서 countPaper함수에서 총 합이 어떤지 확인하고 색이 하얀색과 파란색이 섞여있으면
 * 4등분 해서 재귀적으로 수행해야하므로 1,2,3,4사분면으로 나누어서 재귀호출을 하는 방식으로 하였다.
 */
