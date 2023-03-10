package SlidingWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11003 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Deque<Node> dq = new LinkedList<>();
		
		for(int i = 0; i < N; i++)
		{
			int num = Integer.parseInt(st.nextToken());
			
			while(!dq.isEmpty() && dq.getLast().value > num)
			{
				dq.removeLast();
			}
			
			dq.addLast(new Node(i, num));
			
			if(i - dq.getFirst().index >= L)
			{
				dq.removeFirst();
			}
			
			bw.write(dq.getFirst().value + " ");
			
		}
		
		bw.flush();
		bw.close();
		

	}
	
	static class Node {
		public int index;
		public int value;
		
		Node(int i, int v)
		{
			this.index = i;
			this.value = v;
		}
	}

}
