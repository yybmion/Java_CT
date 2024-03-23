package Part3.BOJ11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725_llocr {
    static boolean[] check;
    static int[] parent;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        check = new boolean[n+1];
        parent = new int[n+1];
        arr = new ArrayList[n+1];

        for(int i=0; i<n+1; i++){ //배열 초기화
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            //양쪽에 다 넣기
            arr[first].add(second);
            arr[second].add(first);
        }

        //루트부터 탐색
        find(1);

        for(int i = 2; i<=n; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void find(int num) {
        check[num] = true;  //방문 체크

        for(int i : arr[num]) { //자식 노드 탐색, 방문했으면 부모 노드
            if(!check[i]) {
                parent[i] = num;
                find(i);
            }
        }
    }
}
