import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10819_kimjiheej {

    static int arr[]; // 원래 있던 배열
    static boolean issued[];

    static int array[];

    static int a;

    static int total = 0;

    static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         a = Integer.parseInt(br.readLine());

         StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[a];
        array = new int[a];
        issued = new boolean[a];

        for(int i=0; i<a; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(ans);

    }

    public static void dfs(int k) {

        if(k==a){
            total = 0;

            for(int d=0; d<a-1; d++){
                total += Math.abs(array[d]-array[d+1]);
            }

            ans = Math.max(ans,total);
            return;
        }

        // 백 트래킹 적용해주기

        for(int i=0; i<a; i++){
            if(!issued[i]){
                array[k] = arr[i];
                issued[i] = true;
                dfs(k+1);
                issued[i] = false;
            }
        }

    }
}
/*

  백트래킹을 활용하여 풀어줍니다...!
 */

