package Part1.BOJ1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1181_limjunhyuk97 {

    static int N;

    // Set 내부 iteration 위한 iterator 활용
    static Set<String> dupRemoval = new HashSet<String>();

    static ArrayList<String> words = new ArrayList<String>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; ++i) {
            dupRemoval.add(br.readLine());
        }

        for(String word : dupRemoval) {
            words.add(word);
        }

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) return o1.length() - o2.length();
                else {
                    return o1.compareTo(o2);
                }
            }
        });

        for(int i=0; i< words.size(); ++i) {
            sb.append(words.get(i)).append('\n');
        }

        System.out.println(sb);
    }

}

/**
 *
 * String.compareTo()
 * - 사전식으로 정렬됨
 *
 * Set<T>
 * - HashSet
 * - TreeSet
 * - LinkedHashSet
 *
 * Set iteration (https://codemanager.tistory.com/107)
 * - [for] for(T t : set)
 * - [while] while(iterator.hasNext())
 * - [forEach] set.forEach(el -> ...)
 *
 */
