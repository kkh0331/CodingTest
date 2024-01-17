package data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_10828 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if(input.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            } else if(input.equals("pop")){
                if(stack.isEmpty()){
                    bw.write(-1+"\n");
                } else {
                    bw.write(stack.pop()+"\n");
                }
            } else if(input.equals("size")){
                bw.write(stack.size()+"\n");
            } else if(input.equals("empty")){
                if(stack.isEmpty()){
                    bw.write(1+"\n");
                } else {
                    bw.write(0+"\n");
                }
            } else if(input.equals("top")){
                if(stack.isEmpty()){
                    bw.write(-1+"\n");
                } else {
                    bw.write(stack.peek()+"\n");
                }
            }
        }
        bw.close();
    }
}
