import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630_kimjiheej {

    static int arr[][];

    static int a;

    static int blue = 0;
    static int white = 0;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         a = Integer.parseInt(br.readLine());

         arr = new int[a][a];

        for(int i=0; i<a; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<a; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calculate(0,0,a);

        System.out.println(white);
        System.out.println(blue);

    }

    public static void calculate(int row, int col, int size) {


        if(colorCheck(row,col,size)==true){ // true 이면 호출을 끝내야 한다. 이것이 종료 조건이다.
            if(arr[row][col] == 0)
                white++;
            else
                blue++;

            return; // 항상 종료시켜주기 !!
        }


        int length = size /2;

        calculate(row, col, length);						// 2사분면
        calculate(row, col+length , length);				// 1사분면
        calculate(row + length, col, length);				// 3사분면
        calculate(row + length, col + length, length);	// 4사분면

    }


    public static boolean colorCheck(int row, int col, int size) {

        int color = arr[row][col];	// 첫 번째 원소를 기준으로 검사

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                // 색상이 같이 않다면 false를 리턴
                if(arr[i][j] != color) {
                    return false;
                }
            }
        }
        // 검사가 모두 통과했다는 의미이므로 true 리턴
        return true;
    }

}
/*

   사분면은 항상 저 순서대로 탐색해주어야 한다.
 */
