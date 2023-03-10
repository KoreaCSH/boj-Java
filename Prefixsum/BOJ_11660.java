package Prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int S[][] = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++)
			{
				S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		
		for(int t = 0; t < M; t++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			result = S[c][d] - S[a-1][d] - S[c][b-1] + S[a-1][b-1];
			
			System.out.println(result);
		}

	}

}
