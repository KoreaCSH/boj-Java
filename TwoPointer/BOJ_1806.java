package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] S = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N ;i++)
		{
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = S[end] - S[start];
		int result = N+1;
		
		while(!(start == N && end == N))
		{
			if(sum >= M)
			{
				if(result > end-start)
				{
					result = end - start;
				}
			}
			
			if( end == N || sum > M )
			{
				start++;
			}
			else
			{
				end++;
			}
			
			sum = S[end] - S[start];
			
		}
		
		if(result == N+1)
		{
			System.out.println(0);
		}
		else
		{
			System.out.println(result);
		}

	}

}
