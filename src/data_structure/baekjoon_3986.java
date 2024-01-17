package data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_3986 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int t=0; t<N; t++){
            Stack<String> stack = new Stack<>();
            String[] inputs = br.readLine().split("");
            for(int i=0; i<inputs.length; i++){
                if(stack.isEmpty()){
                    stack.push(inputs[i]);
                    continue;
                }
                String temp = stack.peek();
                if(temp.equals(inputs[i])){
                    stack.pop();
                } else {
                    stack.push(inputs[i]);
                }
            }
            if(stack.isEmpty()){
               count++;
            }
        }
        System.out.println(count);
    }
}
