package SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int P = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] A = new int[P+1];
		int[] C = new int[P+1];
		int[] G = new int[P+1];
		int[] T = new int[P+1];
		String pwd = br.readLine();
		
		for(int i = 1; i <= pwd.length(); i++)
		{
			A[i] = A[i-1];
			C[i] = C[i-1];
			G[i] = G[i-1];
			T[i] = T[i-1];
			
			if(pwd.charAt(i-1) == 'A')
			{
				A[i] = A[i-1] + 1;
			}
			if(pwd.charAt(i-1) == 'C')
			{
				C[i] = C[i-1] + 1;
			}
			if(pwd.charAt(i-1) == 'G')
			{
				G[i] = G[i-1] + 1;
			}
			if(pwd.charAt(i-1) == 'T')
			{
				T[i] = T[i-1] + 1;
			}
		}
		
		int[] lower = new int[4];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 4; i++)
		{
			lower[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 1;
		int end = S;
		int cnt = 0;
		
		while(end != P+1)
		{
			int check_a = A[end] - A[start-1];
			int check_c = C[end] - C[start-1];
			int check_g = G[end] - G[start-1];
			int check_t = T[end] - T[start-1];
			
			if(check_a >= lower[0] && check_c >= lower[1] && check_g >= lower[2] && check_t >= lower[3])
			{
				cnt++;
			}
			
			start++;
			end++;
		}
		
		System.out.println(cnt);

	}

}
