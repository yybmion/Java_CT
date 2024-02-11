package Part1.BOJ10819;

import java.util.Scanner;
import java.util.Stack;

public class B10819_limjunhyuk97 {

    public static int N;

    public static int arr[];

    public static boolean visited[];

    public static int answer = 0;

    public static Scanner sc = new Scanner(System.in);

    // 식에 따른 선택된 인자들 연산
    public static int calculateEquation(Stack<Integer> selected) {
        int result = 0;

        for(int i=0; i<selected.size()-1; ++i) {
            result += Math.abs(arr[selected.get(i)] - arr[selected.get(i+1)]);
        }

        return result;
    }

    // 순열 구하기
    public static void permutation(Stack<Integer> selected) {

        // 선택 끝났다면 계산 후 answer 갱신
        if (selected.size() == N) {
            int calculatedResult = calculateEquation(selected);
            answer = answer >calculatedResult ? answer : calculatedResult;
            return;
        }

        // 선택
        for(int i=0; i<N; ++i) {
            if(visited[i]) continue;
            visited[i]=true;
            selected.push(i);
            permutation(selected);
            selected.pop();
            visited[i]=false;
        }

    }

    public static void main(String[] args) {

        N = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; ++i) {
            arr[i] = sc.nextInt();
        }

        permutation(new Stack<Integer>());

        System.out.println(answer);

    }
}
