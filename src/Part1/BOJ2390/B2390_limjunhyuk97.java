package Part1.BOJ2390;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2390_limjunhyuk97 {

    static int MAX_DWARF_COUNT = 9;

    static int dwarfs[] = new int[MAX_DWARF_COUNT];

    static boolean selectedDwarfs[] = new boolean[MAX_DWARF_COUNT];

    static ArrayList<Integer> orderedDwarfs = new ArrayList<Integer>();

    static Scanner sc = new Scanner(System.in);

    public static boolean dfs(int idx, int cnt, int sum) {
        // 키 합 계산
        if(sum == 100 && cnt == 7) {
            return true;
        }

        // 7명 초과면 탈출
        if(cnt > 7) return false;

        // idx MAX_DWARF_COUNT 까지 오면 탈출
        if(idx >= MAX_DWARF_COUNT) return false;

        // 조합 구하기
        for(int i=idx; i<MAX_DWARF_COUNT; ++i) {
            selectedDwarfs[i] = true;
            if(dfs(i+1, cnt+1, sum + dwarfs[i])) return true;
            selectedDwarfs[i] = false;
        }

        return false;

    }

    public static void main(String[] args) {

        // 난쟁이 입력
        for(int i=0; i<MAX_DWARF_COUNT; ++i) {
            dwarfs[i] = sc.nextInt();
        }

        // dfs (조합 찾기)
        dfs(0, 0, 0);

        // 정렬
        for(int i=0; i<MAX_DWARF_COUNT; ++i) {
            if(selectedDwarfs[i]) orderedDwarfs.add(dwarfs[i]);
        }
        Collections.sort(orderedDwarfs);

        // 출력
        orderedDwarfs.forEach(dwarf -> System.out.println(dwarf));

    }


}
