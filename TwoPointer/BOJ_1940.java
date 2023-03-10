package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = N-1;
		int count = 0;
		
		while(start < end)
		{
			if(arr[start] + arr[end] == M)
			{
				count++;
			}
			
			if(arr[start] + arr[end] < M)
			{
				start++;
			}
			else
			{
				end--;
			}
			
		}
		
		System.out.println(count);

	}

}
