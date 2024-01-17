package data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_2504 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        int result = 0;
        int value = 1;
        boolean can = true;
        for(int i=0; i<inputs.length; i++) {
            if (inputs[i].equals("(")) {
                stack.push("(");
                value *= 2;
            } else if (inputs[i].equals("[")) {
                stack.push("[");
                value *= 3;
            } else if (inputs[i].equals(")")) {
                if (stack.isEmpty() || stack.peek().equals("[")) {
                    result = 0;
                    break;
                } else {
                    if (inputs[i - 1].equals("(")) {
                        result += value;
                    }
                    stack.pop();
                    value /= 2;
                }
            } else {
                if (stack.isEmpty() || stack.peek().equals("(")) {
                    result = 0;
                    break;
                } else {
                    if (inputs[i - 1].equals("[")) {
                        result += value;
                    }
                    stack.pop();
                    value /= 3;
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }
}
