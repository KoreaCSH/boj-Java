package Prefixsum;

import java.util.Scanner;

public class BOJ_11720 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String sNum = sc.next();
		
		int sum = 0;
		
		for(int i = 0; i < N; i++)
		{
			sum += sNum.charAt(i) - '0';
		}

		System.out.println(sum);
		
		sc.close();
	}

}
