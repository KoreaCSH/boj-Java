package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int cnt = 0;
		
		for(int i = 0; i < N; i++)
		{
			int M = arr[i];
			int start = 0;
			int end = N-1;
			int num = i;
			
			while(start < end)
			{
				if(start == num)
				{
					start++;
					continue;
				}
				else if(end == num)
				{
					end--;
					continue;
				}
				
				if(arr[start] + arr[end] == M)
				{
					cnt++;
					break;
				}
				else if(arr[start] + arr[end] > M)
				{
					end--;
				}
				else
				{
					start++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
