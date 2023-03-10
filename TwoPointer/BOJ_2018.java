package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2018 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[N+1];
		
		for(int i = 1; i <= N; i++)
		{
			S[i] = S[i-1] + i;
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int ans = 0;
		
		while(!(start == N && end == N))
		{
			if(sum > N || end == N)
			{
				start++;
			}
			else
			{
				end++;
			}
			
			sum = S[end] - S[start];
			
			if(sum == N)
			{
				ans++;
			}
			
		}
		
		System.out.println(ans);
		

	}

}
