import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10989_samgashyeong {

    //문제의 제한시간, 제한 메모리를 보고 도수 정렬이 떠올라 푼 문제
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        int max = 0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            int tmp = Integer.parseInt(br.readLine());

            arr[i] = tmp;
            if(tmp > max){
                max = tmp;
            }
        }

        int[] arrCnt = new int[max];

        for(int i =0;i<max;i++){
            arrCnt[i] = 0;
        }

        for(int i =0;i<n;i++){
            arrCnt[arr[i]-1] = arrCnt[arr[i]-1]+1;
        }
        
        for(int i = 0;i<max;i++){

            if(arrCnt[i] != 0){
                for(int j=0;j<arrCnt[i];j++){
                    sb.append(i+1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}