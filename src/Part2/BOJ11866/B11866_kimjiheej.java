import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;



public class B11866_kimjiheej {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int answer[] = new int[a];
        int cnt = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=a; i++){
            q.add(i);
        }

        while(!q.isEmpty()){
              for(int i=1; i<b; i++)
              {
                  int p = q.poll();
                  q.add(p);
              }

              answer[cnt++] = q.poll();
        }

        System.out.print("<");

       for(int i=0; i<cnt-1; i++){
           System.out.print(answer[i]+", ");
       }
       System.out.print(answer[cnt-1]);

        System.out.print(">");

    }
}
/*
   큐의 성질을 잘 생각하면서 활용해보면 된다 !!
 */
