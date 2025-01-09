import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;

public class B1260_kimjiheej {

    static int graph[][];
    static boolean check[];

    static int a ;
    static int b;

    static int count;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

         a = Integer.parseInt(st.nextToken());
         b = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new int[a+1][a+1];
        check = new boolean[a+1];

        for(int i=0; i<b; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(start);
        System.out.println();
        bfs(start);
    }

    public static void dfs(int t){ // stack 사용하지 않고 그냥 재귀로 해준다

        check[t] = true;
        System.out.println(t+" ");

        for(int i=1; i<=a; i++){
            if(!check[i] && graph[t][i] != 0)
            {
                dfs(t);
            }
        }
    }

    public static void bfs(int t){
         boolean[] visited = new boolean[a+1];
         Queue<Integer> q = new LinkedList<>();

         check[t] = true;
         q.add(t);

         while(!q.isEmpty()){
             int curr = q.remove();
             System.out.println(curr + " ");

             for(int i = 1; i<=a; i++){
                 if(!check[i] && graph[curr][i] != 0){
                     check[i] = true;
                     q.add(i);
                 }
             }
         }
    }
}
/*
  BFS 와 DFS 의 기본 틀이다 잘 외워두자 !!

 */
