package data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_2493 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(1, Integer.parseInt(st.nextToken())));
        bw.write(0+" ");
        for(int i=1; i<N; i++){
            int input = Integer.parseInt(st.nextToken());
            while(true){
                if(stack.isEmpty()){
                    stack.push(new Node(i+1, input));
                    bw.write(0+" ");
                    break;
                } else {
                    int peekNum = stack.peek().num;
                    if(input > peekNum){
                        stack.pop();
                    } else if(input < peekNum){
                        bw.write(stack.peek().order+" ");
                        stack.push(new Node(i+1, input));
                        break;
                    }
                }
            }
        }
        bw.close();
    }

    public static class Node{

        int order;
        int num;

        public Node(int order, int num){
            this.order = order;
            this.num = num;
        }

    }
}
