package Prefixsum;

import java.util.Scanner;

public class BOJ_1546 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] score = new int[N];
		long sum = 0;
		
		for(int i = 0; i < N; i++)
		{
			score[i] = sc.nextInt();
			sum += score[i];
		}
		
		long max = 0;
		
		for(int j = 0; j < N; j++)
		{
			if(max < score[j])
			{
				max = score[j];
			}
		}
		
		System.out.println(sum * 100.0 / max / N);
		
		sc.close();

	}

}
