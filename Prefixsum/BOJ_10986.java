package Prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10986 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] S = new long[N];
		long[] D = new long[M];
		long result = 0;
		
		st = new StringTokenizer(br.readLine());
		
		S[0] = Long.parseLong(st.nextToken());
		
		for(int i = 1; i < N; i++)
		{
			S[i] = S[i-1] + Long.parseLong(st.nextToken());
		}
		
		for(int k = 0; k < N; k++)
		{
			int r = (int) (S[k] % M);
			if(r == 0) result++;
			D[r]++;
		}
		
		for(int j = 0; j < M; j++)
		{
			if(D[j] > 1)
			{
				result += (D[j] * (D[j]-1)) / 2;
			}
		}
		
		System.out.println(result);

	}

}
