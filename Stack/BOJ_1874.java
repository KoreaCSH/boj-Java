package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_1874 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new LinkedList<>();

        int j = 1;
        boolean flag = false;
        StringBuffer bf = new StringBuffer();

        for(int i = 0; i < N; i++)
        {
            int num = Integer.parseInt(br.readLine());

            for( ; j <= num; j++)
            {
                stack.addLast(j);
                bf.append("+\n");
            }

            if(stack.getLast() == num)
            {
                stack.removeLast();
                bf.append("-\n");
            }
            else
            {
                flag = true;
                break;
            }
        }

        if(flag)
        {
            System.out.println("NO");
        }
        else
        {
            System.out.println(bf.toString());
        }

    }

}
