package Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_14425 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            set.add(tmp);
        }

        int count = 0;

        for(int i = 0; i < m; i++) {
            String target = br.readLine();
            if(set.contains(target)) {
                count += 1;
            }
        }

        System.out.println(count);

    }

}
